package com.test.toy.ajax;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajax/ex07.do")
public class Ex07 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		AjaxDAO dao = new AjaxDAO();
		
		ArrayList<AddressDTO> alist = dao.listAddress();
		
		for (AddressDTO dto : alist) {
			dto.setGender(dto.getGender().equals("m") ? "남" : "여");
		}
		
		req.setAttribute("alist", alist);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/ajax/ex07.jsp");

		dispatcher.forward(req, resp);

	}

}

