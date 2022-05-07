package com.poly.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.DAO.PhimDAO;
import com.poly.Entity.Phims;
import java.sql.Date;

@WebServlet("/manager/loadinfo")
public class LoadIFServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = (String) req.getSession().getAttribute("maTruyen");
		Phims entity = new Phims();
		PhimDAO dao = new PhimDAO();
		entity = dao.findById(id);
		String review = "";
		try {
			review = entity.getNoiDung().substring(0, 295);
		} catch (Exception e) {
			review = entity.getNoiDung();
		}
		req.setAttribute("review", review);
		req.setAttribute("phim", entity);
		req.getRequestDispatcher("/manager/DetailMovie.jsp").forward(req, resp);
	}
}
