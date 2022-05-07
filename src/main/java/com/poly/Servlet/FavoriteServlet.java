package com.poly.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.DAO.TheLoaiDAO;
import com.poly.DAO.YeuThichDAO;
import com.poly.Entity.Phims;
import com.poly.Entity.TheLoais;

@WebServlet({"/page/favorite/index", "/page/favorite/dislike/*"})
public class FavoriteServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("utf-8");
		
		String user = (String) req.getSession().getAttribute("taiKhoan");
		
		TheLoaiDAO daotl = new TheLoaiDAO(); 
		List<TheLoais> listTL = daotl.findAll();
		req.setAttribute("nav", listTL);
		
		YeuThichDAO dao = new YeuThichDAO();
		List<Phims> list = dao.fillToFavo(user);
		req.setAttribute("listItem", list);
		req.setAttribute("path", "Yêu thích");
		req.getRequestDispatcher("/views/favorite.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = req.getRequestURI();
		if(uri.contains("dislike")) {
			String id = uri.substring(uri.lastIndexOf("/") + 1);
			String user = (String) req.getSession().getAttribute("taiKhoan");
			YeuThichDAO dao = new YeuThichDAO();
			dao.delete(dao.selectId(id, user));
		}
		doGet(req, resp);
	}
}
