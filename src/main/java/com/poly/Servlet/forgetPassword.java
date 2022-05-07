package com.poly.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.DAO.NguoiDungDAO;
import com.poly.Entity.NguoiDungs;
import com.poly.common.EmailUtils;
import com.poly.domain.Email;

/**
 * Servlet implementation class forgetPassword
 */
@WebServlet("/forgetPassword")
public class forgetPassword extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			request.getRequestDispatcher("/views/chanepassword.jsp").forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String emailAddress= request.getParameter("Email");
			String tenDN = request.getParameter("tenDN");
			NguoiDungDAO dao = new NguoiDungDAO();
			NguoiDungs user = dao.findByUsernameAndEmail(tenDN, emailAddress);
			if(user == null) {
				request.setAttribute("error", "Tên Hoặc Email Không Đúng");
			}else {
				Email email = new Email();
				email.setFrom("thanh12cok@gmail.com");
				email.setFromPassword("0905615266Haha");
				email.setTo(emailAddress);
				email.setSubject("Chuc Nang Quen Mat Khau");
				StringBuilder sb = new StringBuilder();
				sb.append("Gửi ").append(tenDN).append("<br>");
				sb.append("Bạn đã sử dụng chức năng quên mật khẩu. <br> ");
				sb.append("Mật khẩu của bạn là: <b> ").append(user.getMatKhau()).append("</b>");
				sb.append("Trân trọng<br>");
				sb.append("Administrator");
				email.setContent(sb.toString());
				EmailUtils.send(email);
				request.setAttribute("message", "Mật Khẩu Đã Gửi Đến Email" + " Vui Lòng Kiểm Tra Và Lấy Mật Khẩu Của Bạn");
				
			}
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		request.getRequestDispatcher("/views/chanepassword.jsp").forward(request, response);
	}

}
