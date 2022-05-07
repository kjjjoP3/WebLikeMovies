package com.poly.manager;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import java.util.List;

import com.poly.DAO.NguoiDungDAO;
import com.poly.DAO.NguoiDungDAOFALL;
import com.poly.Entity.NguoiDungs;
import com.poly.Utils.JpaUtils;

/**
 * Servlet implementation class UsersManagementServlet
 */
@WebServlet({"/UserServlet","/UserServlet/create","/UserServlet/update","/UserServlet/delete",
	"/UserServlet/reset","/UserServlet/edit","/UserServlet/logout","/UserServlet/find","/WebMovie/manager/editUserManager/index"})
public class UsersManagementServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url=request.getRequestURI().toString();
		NguoiDungs user=null;
		if(url.contains("delete")) {
			delete(request, response);
			user=new NguoiDungs();
			request.setAttribute("user", user);
		}else if(url.contains("edit")) {
			edit(request, response);
		}
		else if(url.contains("reset")) {
			user=new NguoiDungs();
			request.setAttribute("user", user);
		}	
		findAll(request, response);
		request.getRequestDispatcher("/user.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url=request.getRequestURI();
		if(url.contains("create")) {
			insert(request, response);
		}else if(url.contains("update")) {
			update(request, response);
		}else if(url.contains("edit")) {
			edit(request, response);
		}else if(url.contains("delete")) {
			delete(request, response);
		}else if(url.contains("find"))	{
			find(request, response);
			return;
		}
		findAll(request, response);
		request.getRequestDispatcher("/user.jsp").forward(request, response);
	}
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("utf-8");
		try {
			NguoiDungs user=new NguoiDungs();
			BeanUtils.populate(user, request.getParameterMap());
			NguoiDungDAOFALL dao=new NguoiDungDAOFALL();
			dao.insert(user);
			request.setAttribute("message", "Thêm Thành Công");
		} catch (Exception e) {
		  e.printStackTrace();
		    request.setAttribute("error", "Có lỗi đã xảy ra");
		}
	}
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("utf-8");
		try {
			NguoiDungs user=new NguoiDungs();
			BeanUtils.populate(user, request.getParameterMap());
			NguoiDungDAOFALL dao=new NguoiDungDAOFALL();
			dao.update(user);
			request.setAttribute("message", "Sửa Thành Công");
		} catch (Exception e) {
		  e.printStackTrace();
		  request.setAttribute("error", "Có lỗi đã xảy ra");
		}
	}
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String tenDN=request.getParameter("tenDN");
			NguoiDungDAO dao=new NguoiDungDAO();
			NguoiDungs user=dao.findById(tenDN);
			request.setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error","Error: "+e.getMessage());
		}
		
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("utf-8");
		try {
			String tenDN=request.getParameter("tenDN");
			
			NguoiDungDAOFALL dao=new NguoiDungDAOFALL();
			dao.delete(tenDN);
			
			request.setAttribute("message","Xóa thành công");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error","Error: "+e.getMessage());
		}
		
	}
	
    protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			List<NguoiDungs> list=new NguoiDungDAO().findAll();
			request.setAttribute("users",list);
		} catch (Exception e) {
		  e.printStackTrace();
		}
	}
    
    protected void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("utf-8");
    	try {
			EntityManager em=JpaUtils.getEntityManager();
		    String find=request.getParameter("find");
		    if(find!=null) {
		    	NguoiDungs us=new NguoiDungDAOFALL().findById(find);
		    String sql="select o from NguoiDungs o where o.tenDN= :id";
		    TypedQuery<NguoiDungs> query=em.createQuery(sql, NguoiDungs.class);
		    query.setParameter("id",find);
		    List<NguoiDungs> ls=query.getResultList();
		    request.setAttribute("users", ls);
		    request.setAttribute("user",us);
		    request.getRequestDispatcher("/user.jsp").forward(request, response);
		    request.setAttribute("message","Đã Tìm Thấy "+ls +"Này");
		    }else {
			    	String sql="SELECT o from NguoiDungs o";
				    TypedQuery<NguoiDungs> query=em.createQuery(sql, NguoiDungs.class);
				    NguoiDungs user=null;
				    
				    user=new NguoiDungs();
					request.setAttribute("user", user);
				    
				    List<NguoiDungs> ls=query.getResultList();
				    request.setAttribute("users", ls);
				    request.getRequestDispatcher("/user.jsp").forward(request, response);
		    	
			    
		    }
		} catch (Exception e) {
		  e.printStackTrace();
		}
	}

}
