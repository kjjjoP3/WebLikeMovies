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
import com.poly.DAO.PhimDAO;
import com.poly.Entity.NguoiDungs;
import com.poly.Entity.Phims;

@WebServlet({"/manager/editUser/index", "/manager/editUser/back", "/manager/editUser/next", "/manager/editUser/update", "/manager/editUser/delete"})
public class EditUserServlet extends HttpServlet {
	int maxPage = 0;
	int i = 0;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		NguoiDungs entity = new NguoiDungs();
		NguoiDungDAO dao = new NguoiDungDAO();
		List<NguoiDungs> list = new ArrayList();
		list = dao.findItem(i);
		req.setAttribute("list", list);
		int result = 0;
		if (dao.Count() <= 10) {
			maxPage = 1;
		} else {
			result = (int) (dao.Count() / 10);
			if ((dao.Count() / 10) != 0) {
				result++;
			}
			maxPage = result;
		}
		
		if(i == 0) {
			req.setAttribute("disBack", true);
		//	req.setAttribute("disNext", false);
		}	
		
		if((i == (maxPage-1))&&(i==0)) {
			req.setAttribute("disBack", true);
			req.setAttribute("disNext", true);
		}
		
		if((i == (maxPage-1))&&(i!=0)) {
			req.setAttribute("disBack", false);
			req.setAttribute("disNext", true);
		}
		
		req.setAttribute("maxPage", maxPage);
		req.setAttribute("page", i + 1);
	//	req.getRequestDispatcher("/manager/EditPhim.jsp").forward(req, resp);
		req.getRequestDispatcher("/manager/editUser.jsp").forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = req.getRequestURI();
		if(uri.contains("delete")){
			doDeleteU(req, resp);
		}
		
		if(uri.contains("update")) {
			doUpdateU(req, resp);
		}
		
		if (uri.contains("next")) {
			doNext(req, resp);
			// req.getRequestDispatcher("/manager/EditPhim.jsp").forward(req, resp);
		}
		if (uri.contains("back")) {
			doBack(req, resp);
			// req.getRequestDispatcher("/manager/EditPhim.jsp").forward(req, resp);
		}
		
	}
	
	private void doNext(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		NguoiDungDAO dao = new NguoiDungDAO();
		NguoiDungs entity = new NguoiDungs();
		List<NguoiDungs> list = new ArrayList();
		i++;
		if (i >= (maxPage - 1)) {
			// list = dao.findItem(maxPage);
			req.setAttribute("disNext", true);
			i = maxPage - 1;
		} else {
			req.setAttribute("disNext", false);
		}
		list = dao.findItem(i);
		req.setAttribute("list", list);
		req.setAttribute("page", i + 1);
		req.setAttribute("maxPage", maxPage);
		req.setAttribute("disBack", false);
	}

	private void doBack(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		NguoiDungDAO dao = new NguoiDungDAO();
		NguoiDungs entity = new NguoiDungs();
		List<NguoiDungs> list = new ArrayList();
		i--;
		if (i <= 0) {
			// list = dao.findItem(maxPage);
			req.setAttribute("disBack", true);
			i=0;
		} else {
			req.setAttribute("disBack", false);
		}
		list = dao.findItem(i);
		req.setAttribute("list", list);
		req.setAttribute("page", i + 1);
		req.setAttribute("maxPage", maxPage);
		req.setAttribute("disNext", false);
	}
	
	private void doDeleteU(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String id = req.getParameter("maXoa");
		NguoiDungDAO dao = new NguoiDungDAO();
		dao.delete(id);
		resp.sendRedirect("/WebMovie/manager/editUser/index");
	}
	
	private void doUpdateU(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String id = req.getParameter("maUpdate");
		NguoiDungDAO dao = new NguoiDungDAO();
		NguoiDungs entity = new NguoiDungs();
		entity = dao.findById(id);
		boolean temp = entity.isVaiTro();
		entity.setVaiTro(!temp);
		dao.update(entity);
		resp.sendRedirect("/WebMovie/manager/editUser/index");
	}
}
