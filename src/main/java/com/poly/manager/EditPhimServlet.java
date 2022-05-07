package com.poly.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.DAO.PhimDAO;
import com.poly.Entity.Phims;

@WebServlet({ "/manager/editPage/index", "/manager/editPage/editPH/*", "/manager/editPage/deletePH",
		"/manager/editPage/back", "/manager/editPage/next", "/manager/editPage/watch/*", "/manager/editPage/add" })
public class EditPhimServlet extends HttpServlet {

	int maxPage = 0;
	int i = 0;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PhimDAO dao = new PhimDAO();
		List<Phims> list = new ArrayList();
		list = dao.findItem(i);
		req.setAttribute("list", list);
		int result = 0;
		if (dao.Count() <= 10) {
			maxPage = 1;
		} else {
			result = (int) ((dao.Count()-1) / 10);
			if ((dao.Count() / 10) != 0) {
				result++;
			}
			maxPage = result;
		}

		if(i == 0) {
			req.setAttribute("disBack", true);
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
		req.getRequestDispatcher("/manager/EditPhim.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = req.getRequestURI();
		System.out.println(uri);
		if (uri.contains("edit")) {

		}
		if (uri.contains("next")) {
			doNext(req, resp);
			// req.getRequestDispatcher("/manager/EditPhim.jsp").forward(req, resp);
		}
		if (uri.contains("back")) {
			doBack(req, resp);
			// req.getRequestDispatcher("/manager/EditPhim.jsp").forward(req, resp);
		}
		if (uri.contains("watch")) {
			System.out.println(123);
			doWatch(req, resp);
		}
		if (uri.contains("editPH")) {
			doEdit(req, resp);
		}
		if (uri.contains("add")) {
			doAdd(req, resp);
		}
		if (uri.contains("deletePH")) {
			doDeleteP(req, resp);
		}
		try {
			req.getRequestDispatcher("/manager/EditPhim.jsp").forward(req, resp);
		} catch (Exception e) {

		}
	}

	private void doNext(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PhimDAO dao = new PhimDAO();
		Phims entity = new Phims();
		List<Phims> list = new ArrayList();
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
		PhimDAO dao = new PhimDAO();
		Phims entity = new Phims();
		List<Phims> list = new ArrayList();
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

	private void doWatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String id = uri.substring(uri.lastIndexOf("/") + 1);
		req.getSession().setAttribute("maTruyen", id);
		// req.getRequestDispatcher("/manager/loadinfo").forward(req, resp);
		resp.sendRedirect("/WebMovie/manager/loadinfo");
	}

	private void doEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String id = uri.substring(uri.lastIndexOf("/") + 1);
		req.getSession().setAttribute("maPH", id);
		resp.sendRedirect("/WebMovie/manager/index");
	}

	private void doAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().removeAttribute("maPH");
	    resp.sendRedirect("/WebMovie/manager/index");
	}
	
	private void doDeleteP(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String id = req.getParameter("maXoa");
		PhimDAO dao = new PhimDAO();
		dao.delete(id);
		resp.sendRedirect("/WebMovie/manager/editPage/index");
	}
}
