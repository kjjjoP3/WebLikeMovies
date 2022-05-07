package com.poly.Servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.poly.DAO.YeuThichDAO;
import com.poly.Entity.YeuThichs;


public class demo{
    public static void main(String[] args) {
		YeuThichDAO dao = new YeuThichDAO();
    	YeuThichs entity = dao.selectByUser("khoahoanghh", "");
    	System.out.println(entity);
	}
     
}
