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

@WebServlet("/index")
public class IndexServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PhimDAO dao = new PhimDAO();
		TheLoaiDAO daotl = new TheLoaiDAO(); 
		List<Phims> list = dao.fillCarouselItem();
		List<TheLoais> listTL = daotl.findAll();
		List<Phims> listPCR = dao.fillNavPCR();
		List<Phims> listPHH = dao.fillNavPHH();
		req.setAttribute("list", list);
		req.setAttribute("nav", listTL);
		req.setAttribute("navPCR", listPCR);
		req.setAttribute("navPHH", listPHH);
		req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
	}

	
}
