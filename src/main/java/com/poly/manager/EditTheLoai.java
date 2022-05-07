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
import com.poly.DAO.TheLoaiDAO;
import com.poly.Entity.Phims;
import com.poly.Entity.TheLoais;

@WebServlet({ "/manager/editTL/index", "/manager/editTL/back", "/manager/editTL/next", "/manager/editTL/deleteTL",
		"/manager/editTL/create", "/manager/editTL/update/*", "/manager/editTL/fillEdit/*" })
public class EditTheLoai extends HttpServlet {
	int maxPage = 0;
	int i = 0;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPage(req, resp);
		req.getRequestDispatcher("/manager/editTL.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String uri = req.getRequestURI();
		
		if(uri.contains("index")) {
			resp.sendRedirect("/WebMovie/manager/editTL/index");
		}
		
		if (uri.contains("create")) {
			doFill(req, resp);
			if (doValiadate(req, resp)) {
				try {
					TheLoais entity = new TheLoais();
					TheLoaiDAO dao = new TheLoaiDAO();
					BeanUtils.populate(entity, req.getParameterMap());
					dao.create(entity);
					resp.sendRedirect("/WebMovie/manager/editTL/index");
				} catch (Exception e) {

				}
			}
		}

		if (uri.contains("deleteTL")) {
			String id = req.getParameter("maXoa");
			TheLoaiDAO dao = new TheLoaiDAO();
			dao.delete(id);
			resp.sendRedirect("/WebMovie/manager/editTL/index");
		}

		if (uri.contains("fillEdit")) {
			doFillEdit(req, resp);
		}

		if (uri.contains("update")) {
			doFill(req, resp);
			if(doValiadate1(req, resp)) {
				doUpdate(req, resp);
			}
		}
		
		if(uri.contains("next")) {
			doNext(req, resp);
		}
		
		if(uri.contains("back")) {
			doBack(req, resp);
		}

		try {
			req.getRequestDispatcher("/manager/editTL.jsp").forward(req, resp);
		} catch (Exception e) {

		}
	}
	
	
	private void doNext(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TheLoaiDAO dao = new TheLoaiDAO();
		TheLoais entity = new TheLoais();
		List<TheLoais> list = new ArrayList();
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
		TheLoaiDAO dao = new TheLoaiDAO();
		TheLoais entity = new TheLoais();
		List<TheLoais> list = new ArrayList();
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

	private void doFill(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String maTL = req.getParameter("maTheLoai");
		String tenTL = req.getParameter("tenTheLoai");

		TheLoais entity = new TheLoais();
		try {
			BeanUtils.populate(entity, req.getParameterMap());
		} catch (Exception e) {

		}

		doPage(req, resp);
		req.setAttribute("tl", entity);
	}

	private boolean doValiadate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String maTL = req.getParameter("maTheLoai");
		String tenTL = req.getParameter("tenTheLoai");

		boolean check = false;
		int i = 0;

		if (i == 0) {
			if (maTL.isEmpty()) {
				doFill(req, resp);
				req.setAttribute("backround", "danger");
				req.setAttribute("message", "Mã Thể Loại Không Được Để Trống!");
				req.setAttribute("show", "true");
			} else {
				TheLoais entity = new TheLoais();
				TheLoaiDAO dao = new TheLoaiDAO();
				entity = dao.findById(maTL);
				if (entity != null) {
					doFill(req, resp);
					req.setAttribute("backround", "danger");
					req.setAttribute("message", "Mã thể loại đã tồn tại!");
					req.setAttribute("show", "true");
				} else {
					doFill(req, resp);
					i++;
				}
			}
		}

		if (i == 1) {
			if (tenTL.isEmpty()) {
				doFill(req, resp);
				req.setAttribute("backround", "danger");
				req.setAttribute("message", "Tên thể loại không được để trống!");
				req.setAttribute("show", "true");
			} else {
				doFill(req, resp);
				i++;
			}
		}

		if (i == 2) {
			check = true;
		}

		return check;

	}
	
	private boolean doValiadate1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String maTL = req.getParameter("maTheLoai");
		String tenTL = req.getParameter("tenTheLoai");

		boolean check = false;
		int i = 1;

		if (i == 1) {
			if (tenTL.isEmpty()) {
				doFill(req, resp);
				req.setAttribute("backround", "danger");
				req.setAttribute("message", "Tên thể loại không được để trống!");
				req.setAttribute("show", "true");
			} else {
				doFill(req, resp);
				i++;
			}
		}

		if (i == 2) {
			check = true;
		}

		return check;

	}

	private void doPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TheLoaiDAO dao = new TheLoaiDAO();
		TheLoais entity = new TheLoais();
		List<TheLoais> list = new ArrayList();
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

	private void doFillEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String id = uri.substring(uri.lastIndexOf("/") + 1);
		TheLoais entity = new TheLoais();
		TheLoaiDAO dao = new TheLoaiDAO();
		entity = dao.findById(id);
		req.setAttribute("tl", entity);
		req.setAttribute("edit", "yes");
		req.setAttribute("disMaTL", true);
		doPage(req, resp);
		// resp.sendRedirect("/WebMovie/manager/editTL/index");
	}

	private void doUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String uri = req.getRequestURI();
//		String id = req.getParameter("maTheLoai");
		TheLoais entity = new TheLoais();
		TheLoaiDAO dao = new TheLoaiDAO();
		try {
			BeanUtils.populate(entity, req.getParameterMap());
			dao.update(entity);
			resp.sendRedirect("/WebMovie/manager/editTL/index");
		} catch (Exception e) {

		}
		// entity = dao.findById(id);

	}
}
