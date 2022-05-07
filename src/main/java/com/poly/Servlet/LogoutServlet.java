package com.poly.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.removeAttribute("user");
		req.removeAttribute("password");
		req.getSession().removeAttribute("taiKhoan");
		//resp.sendRedirect(getServletInfo());
		req.getRequestDispatcher("/login").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//if(req.getParameter("logout") != null) {
		//	req.removeAttribute("user");
		//	req.removeAttribute("password");
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
		//}
	}

}
