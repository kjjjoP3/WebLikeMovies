package com.poly.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.DAO.BinhLuanDAO;
import com.poly.DAO.NguoiDungDAO;
import com.poly.DAO.TheLoaiDAO;
import com.poly.DAO.YeuThichDAO;
import com.poly.Entity.NguoiDungs;
import com.poly.Entity.TheLoais;

@WebServlet({"/page/profile/index", "/page/profile/update"})
public class ProfileServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		TheLoaiDAO daotl = new TheLoaiDAO(); 
		List<TheLoais> listTL = daotl.findAll();
		req.setAttribute("nav", listTL);
		
		String id = (String) req.getSession().getAttribute("taiKhoan");
		NguoiDungDAO dao = new NguoiDungDAO();
		BinhLuanDAO daoBL = new BinhLuanDAO();
		YeuThichDAO daoYT = new YeuThichDAO();
		NguoiDungs entity = dao.findById(id);
		
		req.setAttribute("comment", daoBL.countById(id));
		req.setAttribute("profile", entity);
		req.setAttribute("path", "Thông Tin");
		req.setAttribute("favorite", daoYT.countById(id));
		
		
		req.getRequestDispatcher("/views/profile.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = req.getRequestURI();
		if(uri.contains("update")){
			doUpdate(req, resp);
		}
	}
	
	private void doUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		String id = (String) req.getSession().getAttribute("taiKhoan");
		String Ho = req.getParameter("Ho");
		String Ten = req.getParameter("Ten");
		String Email = req.getParameter("Email");
		String matKhau = req.getParameter("matKhau");
		String xnMatKhau = req.getParameter("xnMatKhau");
		
		NguoiDungDAO dao = new NguoiDungDAO();
		NguoiDungs entity = dao.findById(id);
		
		if(matKhau.equals(xnMatKhau) == false) {
			req.setAttribute("backround", "danger");
			req.setAttribute("message", "Xác nhận mật khẩu không khớp!");
			req.setAttribute("check", "true");
		}
		else {
			req.setAttribute("check", null);
			entity.setHo(Ho);
			entity.setTen(Ten);
			entity.setEmail(Email);
			entity.setMatKhau(xnMatKhau);
			req.setAttribute("message", "Cập Nhật Tài Khoản Thành Công!");
			req.setAttribute("backround", "success");
			
			req.setAttribute("check", "true");
			System.out.println("Thanh Cong");
			dao.update(entity);
			
			//resp.sendRedirect("/WebMovie/page/profile/index");
		}
		//req.getRequestDispatcher("/views/profile.jsp").forward(req, resp);
		req.setAttribute("message", "Cập Nhật Tài Khoản Không Thành Công!");
		doGet(req, resp);
		
	}
	
	
}
