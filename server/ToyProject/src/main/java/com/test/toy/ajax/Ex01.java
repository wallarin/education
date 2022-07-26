package com.test.toy.ajax;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajax/ex01.do")
public class Ex01 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1. DB 작업 > DAO 위임 > select
		//2. 결과
		//3. JSP 호출하기
		
		AjaxDAO dao = new AjaxDAO();
		
		ArrayList<ResearchDTO> list = dao.listResearch();
		
		//3.
		req.setAttribute("dto", list.get(0));
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/ajax/ex01.jsp");

		dispatcher.forward(req, resp);

	}

}











