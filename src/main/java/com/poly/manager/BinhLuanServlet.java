package com.poly.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.DAO.BinhLuanDAO;
import com.poly.DAO.YeuThichDAO;
import com.poly.Entity.BinhLuans;
import com.poly.Entity.YeuThichs;

/**
 * Servlet implementation class BinhLuanServlet
 */
@WebServlet("/manager/BinhLuan/index")
public class BinhLuanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("utf-8");

		BinhLuans entity = new BinhLuans();
		BinhLuanDAO dao = new BinhLuanDAO();
		List<BinhLuans> list = new ArrayList();
		list = dao.findAll();
		System.out.println("thong bao: "+list.size());
		request.setAttribute("list", list);

		request.getRequestDispatcher("/manager/BinhLuan.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
	}

}
