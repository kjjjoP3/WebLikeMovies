package com.poly.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.DAO.NguoiDungDAO;
import com.poly.DAO.TheLoaiDAO;
import com.poly.DAO.YeuThichDAO;
import com.poly.Entity.NguoiDungs;
import com.poly.Entity.Phims;
import com.poly.Entity.TheLoais;
import com.poly.Entity.YeuThichs;

/**
 * Servlet implementation class FavoriteManagerServlet
 */
@WebServlet("/manager/favoritemanager/index")
public class FavoriteManagerServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("utf-8");

		YeuThichs entity = new YeuThichs();
		YeuThichDAO dao = new YeuThichDAO();
		List<YeuThichs> list = new ArrayList();
		list = dao.findAll();
		System.out.println("thong bao: "+list.size());
		request.setAttribute("list", list);

		request.getRequestDispatcher("/manager/favoritemanager.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		String id = req.getParameter("maXoa");
//		YeuThichDAO dao = new YeuThichDAO();
//		dao.delete(getLastModified(req));
//		resp.sendRedirect("/WebMovie/manager/editUser/index");
//		doGet(req, resp);
	}

}
