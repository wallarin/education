package com.test.toy.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajax/ex07del.do")
public class Ex07Del extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String seq = req.getParameter("seq");
		
		AjaxDAO dao = new AjaxDAO();
		
		int result = dao.del(seq);
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		PrintWriter writer = resp.getWriter();
		
		writer.printf("{ \"result\": \"%d\" }", result);
		writer.close();
		
		/*   
		 { "result": "%d" }
		 	"name": "%s",
		 	"age": "%s",
		 	"gender": "%s",
		 	"tel": "%s",
		 	"address": "%s"
		 		 
		 */

	}

}







