package com.test.toy.board;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/board/delok.do")
public class DelOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1. 데이터 가져오기
		//2. DB작업 > DAO 위임 > seq
		//3. 결과 반환
		//4. JSP 호출
		HttpSession session = req.getSession();
		
		String seq = req.getParameter("seq");
		
		BoardDAO dao = new BoardDAO();
		
		int temp = 0;
		
		if (session.getAttribute("auth") == null) {
			temp = 1; //익명 사용자
		} else if (session.getAttribute("auth") != null) {
			
			if (session.getAttribute("auth").equals(dao.get(seq).getId())) {
				temp = 2;
			} else {
				//temp = 2;
				if (session.getAttribute("auth").toString().equals("admin")) {
					temp = 3;
				} else {
					temp = 4;
				}
			}
		}
		
		int result = 0;
		
		if (temp == 2 || temp == 3) {
			
			//댓글 삭제
			dao.delCommentAll(seq);
			
			//원글 첨부 파일 삭제
			BoardDTO dto = dao.get(seq);
			
			if (dto.getFilename() != null) {
				String path = req.getRealPath("files") + "\\" + dto.getFilename();
				File file = new File(path);
				file.delete();
			}
			
			//태그 삭제
			dao.delTag(seq);
			
			//좋아요 / 싫어요 삭제
			dao.delGoodBad(seq);
			
			//원글 삭제
			result = dao.del(seq);
		}
		
		req.setAttribute("result", result);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/delok.jsp");

		dispatcher.forward(req, resp);

	}

}

