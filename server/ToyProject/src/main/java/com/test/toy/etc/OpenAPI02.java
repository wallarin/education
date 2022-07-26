package com.test.toy.etc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/etc/openapi02.do")
public class OpenAPI02 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String query = req.getParameter("query");
		
		
		String page = req.getParameter("page");
		
		int nowPage = 0;
		
		if (page != null && !page.equals("")) {
			nowPage = Integer.parseInt(page);
		} else {
			nowPage = 1;
		}
		
		
		//page=1 > 1
		//page=2 > 11
		//page=3 > 21
		nowPage = (nowPage - 1) * 10 + 1;
		
		OpenAPIDAO dao = new OpenAPIDAO();
		
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("query", query);
		map.put("nowPage", nowPage + "");
		
		ResultDTO rdto = dao.search(map);
		
		if (rdto != null) {
			rdto.setQuery(query);
			rdto.setTotalPage(String.valueOf((int)Math.ceil(Integer.parseInt(rdto.getTotal()) / 10.0)));
			req.setAttribute("rdto", rdto);
		}
		
//		req.setAttribute("list", list);
//		req.setAttribute("query", query);
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/etc/openapi02.jsp");

		dispatcher.forward(req, resp);

	}

}





























