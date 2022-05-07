package com.poly.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.poly.DAO.PhimDAO;
import com.poly.DAO.PhimTHDAO;
import com.poly.DAO.TheLoaiDAO;
import com.poly.Entity.PhimTHs;
import com.poly.Entity.Phims;
import com.poly.Entity.TamPTH;
import com.poly.Entity.TheLoais;

@WebServlet({ "/manager/editPTH/index", "/manager/editPTH/create", "/manager/editPTH/deletePTH", "/manager/editPTH/next", "/manager/editPTH/back" })
public class EditPTHServlet extends HttpServlet {
	int maxPage = 0;
	int i = 0;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doFillData(req, resp);
		doPage(req, resp);
		req.getRequestDispatcher("/manager/PhimTHe.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = req.getRequestURI();
		if(uri.contains("create")) {		
			doCreate(req, resp);
			resp.sendRedirect("/WebMovie/manager/editPTH/index");
		}
		if(uri.contains("deletePTH")) {
			String id = req.getParameter("maXoa");
			PhimTHDAO dao = new PhimTHDAO();
			dao.delete(id);
			resp.sendRedirect("/WebMovie/manager/editPTH/index");
		}
		if(uri.contains("next")) {
			doFillData(req, resp);
			doNext(req, resp);
		}
		if(uri.contains("back")) {
			doFillData(req, resp);
			doBack(req, resp);
		}
		
		try {
			req.getRequestDispatcher("/manager/PhimTHe.jsp").forward(req, resp);
		} catch (Exception e) {

		}
	}

	private void doCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//doFillData(req, resp);
		String maPhim = req.getParameter("maPhim");
		String maTheLoai = req.getParameter("theLoai");
		boolean loaiPhim = Boolean.parseBoolean(req.getParameter("loaiPhim"));

//		System.out.println(maPhim);
//		System.out.println(maTheLoai);
//		System.out.println(loaiPhim);
		
		PhimTHs entity = new PhimTHs();
		PhimTHDAO dao = new PhimTHDAO();
		//Phims phim = new Phims();
		PhimDAO daoP = new PhimDAO();
		TheLoaiDAO daoTL = new TheLoaiDAO();
		try {
			//BeanUtils.populate(entity, req.getParameterMap());
			entity.setPhims(daoP.findById(maPhim));
			entity.setTheloais(daoTL.findById(maTheLoai));
			entity.setLoaiPhim(loaiPhim);
			dao.create(entity);
		} catch (Exception e) {

		}

	}
	
	
	private void doNext(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PhimTHDAO dao = new PhimTHDAO();
		TamPTH entity = new TamPTH();
		List<TamPTH> list = new ArrayList();
		i++;
		if (i >= (maxPage - 1)) {
			// list = dao.findItem(maxPage);
			req.setAttribute("disNext", true);
			i = maxPage - 1;
		} else {
			req.setAttribute("disNext", false);
		}
		list = dao.findItem(i);
		req.setAttribute("list3", list);
		req.setAttribute("page", i + 1);
		req.setAttribute("maxPage", maxPage);
		req.setAttribute("disBack", false);
	}

	private void doBack(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PhimTHDAO dao = new PhimTHDAO();
		TamPTH entity = new TamPTH();
		List<TamPTH> list = new ArrayList();
		i--;
		if (i <= 0) {
			// list = dao.findItem(maxPage);
			req.setAttribute("disBack", true);
			i=0;
		} else {
			req.setAttribute("disBack", false);
		}
		list = dao.findItem(i);
		req.setAttribute("list3", list);
		req.setAttribute("page", i + 1);
		req.setAttribute("maxPage", maxPage);
		req.setAttribute("disNext", false);
	}
	
	private void doFillData(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Phims phim = new Phims();
		TheLoais theLoai = new TheLoais();
		PhimTHDAO dao = new PhimTHDAO();
		List<Phims> list1 = new ArrayList();

		List<TheLoais> list2 = new ArrayList();

		list1 = dao.fillMaPhim();
		list2 = dao.fillTheLoai();
		req.setAttribute("list", list1);
		req.setAttribute("list2", list2);
	}
	
	private void doPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PhimTHDAO dao = new PhimTHDAO();
		TamPTH entity = new TamPTH();
		List<TamPTH> list = new ArrayList();
		list = dao.findItem(i);
		req.setAttribute("list3", list);
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

		if (i == 0) {
			req.setAttribute("disBack", true);
		}

		if ((i == (maxPage - 1)) && (i == 0)) {
			req.setAttribute("disBack", true);
			req.setAttribute("disNext", true);
		}

		if ((i == (maxPage - 1)) && (i != 0)) {
			req.setAttribute("disBack", false);
			req.setAttribute("disNext", true);
		}

		req.setAttribute("maxPage", maxPage);
		req.setAttribute("page", i + 1);
	}
}
