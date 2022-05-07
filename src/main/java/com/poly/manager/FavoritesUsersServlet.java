package com.poly.manager;

import java.io.IOException;import java.time.Year;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.DAO.NguoiDungDAO;
import com.poly.DAO.PhimDAO;
import com.poly.DAO.YeuThichDAO;
import com.poly.Entity.NguoiDungs;
import com.poly.Entity.Phims;
import com.poly.Entity.YeuThichs;

import net.bytebuddy.implementation.bytecode.Throw;

/**
 * Servlet implementation class FavoritesUsersServlet
 */
@WebServlet({ "/manager/FavoritesUsers/index", "/manager/FavoritesUsers/report"})
public class FavoritesUsersServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		reportFavorite(request, response);
		request.getRequestDispatcher("/manager/FavoritesUsers.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			
			YeuThichDAO yeuThichDAO = new YeuThichDAO();
         	String UserId = request.getParameter("UserId");
         	List<YeuThichs> ls=yeuThichDAO.selectListByTenDN(UserId);
         	request.setAttribute("yeuThichArrayList", ls);
    		reportFavorite(request, response);
    		request.getRequestDispatcher("/manager/FavoritesUsers.jsp").forward(request, response);
         	
		} catch (Exception e) {
			e.printStackTrace();
			
		}

	}
protected void reportFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		YeuThichDAO dao = new YeuThichDAO();
		
		String UserId = request.getParameter("UserId");
		String recordValue = request.getParameter("UserId");
		
		
		NguoiDungDAO daond = new NguoiDungDAO();
		List<NguoiDungs> usersArrayList = daond.findAll();
		if(UserId==null && usersArrayList.size()>0) {
			UserId=usersArrayList.get(0).getTenDN();
		}
		List<YeuThichs> ls=dao.selectListByTenDN(UserId);
		
		request.setAttribute("recordValue", recordValue);
		request.setAttribute("usersArrayList",usersArrayList);
     	request.setAttribute("yeuThichArrayList", ls);
			
		
	}
//	private void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//	}
	
	
	

}
