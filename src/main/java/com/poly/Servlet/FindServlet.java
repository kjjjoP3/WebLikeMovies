package com.poly.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.DAO.PhimDAO;
import com.poly.DAO.TheLoaiDAO;
import com.poly.Entity.Phims;
import com.poly.Entity.TheLoais;

@WebServlet("/page/find/index")
public class FindServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("utf-8");
		
		TheLoaiDAO daotl = new TheLoaiDAO(); 
		List<TheLoais> listTL = daotl.findAll();
		req.setAttribute("nav", listTL);
		
		req.setAttribute("path", "Tìm Kiếm");
		
		Phims entity = new Phims();
		PhimDAO dao = new PhimDAO();
		
		String name = req.getParameter("search");
		
		List<Phims> list = dao.findFilm(name);
	    
		req.setAttribute("listItem", list);
		
		req.getRequestDispatcher("/views/find.jsp").forward(req, resp);
	}
}
