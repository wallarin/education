package com.test.toy.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/editcommentajaxok.do")
public class EditCommentAjaxOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 인코딩
		//2. 데이터 가져오기
		//3. DB 작업 > DAO 위임 > update
		//4. 결과
		//5. 피드백
		
		//1.
		req.setCharacterEncoding("UTF-8");
		
		//2.
		String seq = req.getParameter("seq");
		String conent = req.getParameter("content");
		
		
		//3.
		CommentDTO dto = new CommentDTO();
		
		dto.setSeq(seq);
		dto.setContent(conent);
		
		BoardDAO dao = new BoardDAO();
		
		int result = dao.editComment(dto);
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		PrintWriter writer = resp.getWriter();
		
		writer.printf("{ \"result\": %d }", result);
		
		writer.close();
		
		/* { "result": %d } */

	}

}

















