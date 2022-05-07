package com.poly.Servlet;

import java.io.IOException;
import java.util.ArrayList;
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

@WebServlet({ "/page/item/*", "/page/item/next/*", "/page/item/back/*", "/page/item/index" })
public class PageItemServlet extends HttpServlet {
	int i = 0;
	int maxPage = 0;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("utf-8");
		i = 0;
		maxPage = 0;
		String uri = req.getRequestURI();
		String id = uri.substring(uri.lastIndexOf("/") + 1);
		req.setAttribute("nameUri", id);
		// System.out.println(id);
		PhimDAO dao = new PhimDAO();
		TheLoaiDAO daotl = new TheLoaiDAO();

		List<Phims> list = new ArrayList();
		List<TheLoais> listTL = daotl.findAll();
		req.setAttribute("nav", listTL);
		String nameTL = "";
		Long count = (long) 0;
		try {
			int idNumb = Integer.parseInt(id);
			if(idNumb == 0) {
				nameTL = "Phim Hoạt Hình";
				count = dao.countPageItem2(false);
			}
			else {
				nameTL = "Phim Chiếu Rạp";
				count = dao.countPageItem2(true);
			}
			list = dao.fillToType(i, idNumb);

			req.setAttribute("listItem", list);
		} catch (NumberFormatException e) {
			list = dao.fillPageItem(i, id.trim());
			req.setAttribute("listItem", list);
			count = dao.countPageItem(id);
			nameTL = daotl.nameTL(id);
		}
		int result = 0;

		if (count <= 12) {
			maxPage = 1;
		} else {
			result = (int) ((count - 1) / 12);
			if ((count / 12) != 0) {
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

		req.setAttribute("page", i + 1);

		

		req.setAttribute("path", nameTL);

		req.getRequestDispatcher("/views/pageitem.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = req.getRequestURI();
		if (uri.contains("back")) {
			doBack(req, resp);
		}
		if (uri.contains("next")) {
			doNext(req, resp);
		}

		req.getRequestDispatcher("/views/pageitem.jsp").forward(req, resp);
	}

	private void doNext(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("utf-8");String uri = req.getRequestURI();
		String id = uri.substring(uri.lastIndexOf("/") + 1);
		req.setAttribute("nameUri", id);

		PhimDAO dao = new PhimDAO();
		TheLoaiDAO daotl = new TheLoaiDAO();
		List<Phims> list = new ArrayList();
		List<TheLoais> listTL = daotl.findAll();

		i++;

		if (i >= (maxPage - 1)) {
			// list = dao.findItem(maxPage);
			req.setAttribute("disNext", true);
			i = maxPage - 1;
		} else {
			req.setAttribute("disNext", false);
		}

		req.setAttribute("nav", listTL);
		String nameTL = "";
		try {
			int idNumb = Integer.parseInt(id);
			if(idNumb == 0) {
				nameTL = "Phim Hoạt Hình";
			}
			else {
				nameTL = "Phim Chiếu Rạp";
			}
			list = dao.fillToType(i, idNumb);
			req.setAttribute("listItem", list);
		} catch (Exception e) {
			list = dao.fillPageItem(i, id.trim());
			req.setAttribute("listItem", list);
			nameTL = daotl.nameTL(id);
			nameTL = daotl.nameTL(id);
		}

		

		req.setAttribute("path", nameTL);
		req.setAttribute("page", i + 1);
		req.setAttribute("disBack", false);
	}

	private void doBack(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("utf-8");
		String uri = req.getRequestURI();
		String id = uri.substring(uri.lastIndexOf("/") + 1);
		req.setAttribute("nameUri", id);

		PhimDAO dao = new PhimDAO();
		TheLoaiDAO daotl = new TheLoaiDAO();
		List<Phims> list = new ArrayList();
		List<TheLoais> listTL = daotl.findAll();

		i--;
		if (i <= 0) {
			// list = dao.findItem(maxPage);
			req.setAttribute("disBack", true);
			i = 0;
		} else {
			req.setAttribute("disBack", false);
		}

		req.setAttribute("nav", listTL);
		String nameTL = "";
		try {
			int idNumb = Integer.parseInt(id);
			if(idNumb == 0) {
				nameTL = "Phim Hoạt Hình";
			}
			else {
				nameTL = "Phim Chiếu Rạp";
			}
			list = dao.fillToType(i, idNumb);
			req.setAttribute("listItem", list);
		} catch (Exception e) {
			list = dao.fillPageItem(i, id.trim());
			req.setAttribute("listItem", list);
			nameTL = daotl.nameTL(id);
			nameTL = daotl.nameTL(id);
		}

		

		req.setAttribute("path", nameTL);
		req.setAttribute("page", i + 1);
		req.setAttribute("disNext", false);
	}
}
