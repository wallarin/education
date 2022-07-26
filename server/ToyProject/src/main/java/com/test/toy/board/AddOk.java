package com.test.toy.board;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/board/addok.do")
public class AddOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 인코딩
		//2. 데이터 가져오기(subject, content)
		//3. DB작업 > DAO 위임 > insert
		//4. 결과
		//5. JSP 호출하기
		
		HttpSession session = req.getSession();
		
		req.setCharacterEncoding("UTF-8");
		
		
		
		//1.5 파일 업로드
		String path = req.getRealPath("/files");
		int size = 1024 * 1024 * 100;
		
		System.out.println(path);
		
		MultipartRequest multi = null;
		
		try {
			
			multi = new MultipartRequest(req, path, size, "UTF-8", new DefaultFileRenamePolicy());
			
		} catch (Exception e) {
			System.out.println("AddOk.doPost");
			e.printStackTrace();
		}
		
		
		String subject = multi.getParameter("subject");
		String content = multi.getParameter("content");
		
		
		//2.5 현재 새글 작성중인지? 답변글 작성중인지>?
		String reply = multi.getParameter("reply");
		
		int thread = -1;
		int depth = -1;
		
		
		BoardDAO dao = new BoardDAO();
		
		
		if (reply.equals("")) {
			//새글
			thread = dao.getMaxThread() + 1000;
			depth = 0;
		} else {
			//답변글
			int parentThread = Integer.parseInt(multi.getParameter("thread"));
			int parentDepth = Integer.parseInt(multi.getParameter("depth"));
			
			int previousThread = (int)Math.floor((parentThread - 1) / 1000) * 1000;
			
			//a
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			map.put("parentThread", parentThread);
			map.put("previousThread", previousThread);
			
			
			
			dao.updateThread(map);
			
			
			thread = parentThread - 1;
			depth = parentDepth + 1;
			
		}
		
		
		String filename = multi.getFilesystemName("attach");
		String orgfilename = multi.getOriginalFileName("attach");
		
		
		BoardDTO dto = new BoardDTO();
		
		dto.setSubject(subject);
		dto.setContent(content);
		dto.setId((String)session.getAttribute("auth"));
		
		dto.setThread(thread);
		dto.setDepth(depth);
		
		dto.setFilename(filename);
		dto.setOrgfilename(orgfilename);
		
		
		
		int result = 0;
		
		if (session.getAttribute("auth") != null) {
			result = dao.add(dto);
		}
		
		
		//방금 쓴 글번호
		String seq = dao.getSeq();
		
		
		//3.5 해시태그 작업
		String tags = multi.getParameter("tags");
		
		
		//게시물 1개 + 해시 태그 3개
		//- 게시물 1개 insert
		//- 게시물의 번호를 알아와야한다.
		//- 해시태그를 3개 insert
		//- 해시태그들의 번호들를 알아와야한다.
		//- 게시물의 번호와 해시태그들의 번호를 각각 넣어준. > insert 3번
		
		
		
		//Java > JSON format > JSON Simple
		
		//https://mvnrepository.com/
		//https://search.maven.org/
		
		//현재 tags가 JSON방식으로 넘어와서 value값이 넘어와서 그 값을 꺼내기 위해서
		//org.json.simple.parser.JSONParser;
		JSONParser parser = new JSONParser();
		
		try {
			
			//JSONArray list;
			//JSONObject obj;
			
			JSONArray list = (JSONArray)parser.parse(tags);
			
			//System.out.println(list);
			
			for (Object obj : list) {
				//System.out.println(obj);
				System.out.println(((JSONObject)obj).get("value"));
				
				String tag = (String)((JSONObject)obj).get("value");
				
				//HashTag > insert
				
				dao.addHashTag(tag);
				
				String hseq = dao.getHashTagSeq();
				
				//Tagging > insert
				HashMap<String,String> map = new HashMap<String,String>();
				map.put("bseq", seq);
				map.put("hseq", hseq);
				
				dao.addTagging(map);
				
			}
			
		} catch (Exception e) {
			System.out.println("AddOk.doPost");
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		req.setAttribute("result", result);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/addok.jsp");

		dispatcher.forward(req, resp);

	}

}













