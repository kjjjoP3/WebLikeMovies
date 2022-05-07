package com.poly.manager;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import com.poly.DAO.NguoiDungDAO;
import com.poly.DAO.PhimDAO;
import com.poly.Entity.NguoiDungs;
import com.poly.Entity.Phims;

@MultipartConfig()
@WebServlet({ "/manager/index", "/manager/update", "/manager/delete", "/manager/create", "/manager/edit/*",
		"/manager/list" })
public class PhimServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// resp.sendRedirect("/WebMovie/manager/index.jsp");
		try {
			Phims entity = new Phims();
			PhimDAO dao = new PhimDAO();
			String id = (String) req.getSession().getAttribute("maPH");
			entity = dao.findById(id);
			req.setAttribute("phim", entity);
			req.setAttribute("disMaPhim", true);
			req.setAttribute("edit", "yes");
		} catch (Exception e) {

		}
		req.getRequestDispatcher("/manager/index.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String uri = req.getRequestURI();
		// System.out.println(uri);
		if (uri.contains("create")) {
			doFill(req, resp);
			if (doValiadate(req, resp)) {
				try {
					Phims entity = new Phims();
					PhimDAO dao = new PhimDAO();

					BeanUtils.populate(entity, req.getParameterMap());

					Part poster = req.getPart("poster");
					Part hinh1 = req.getPart("hinh1");
					Part hinh2 = req.getPart("hinh2");
					Part hinh3 = req.getPart("hinh3");
					Part hinh4 = req.getPart("hinh4");
					entity.setPoster(poster.getSubmittedFileName());
					entity.setHinh1(hinh1.getSubmittedFileName());
					entity.setHinh2(hinh2.getSubmittedFileName());
					entity.setHinh3(hinh3.getSubmittedFileName());
					entity.setHinh4(hinh4.getSubmittedFileName());

					dao.create(entity);
					resp.sendRedirect("/WebMovie/manager/editPage/index");
				} catch (Exception e) {

				}
			}
		} else if (uri.contains("edit")) {
			doFill(req, resp);
			if (doValiadate1(req, resp)) {
				int i = 0;
				try {
					Phims entity = new Phims();
					PhimDAO dao = new PhimDAO();

					BeanUtils.populate(entity, req.getParameterMap());

					Part poster = req.getPart("poster");
					Part hinh1 = req.getPart("hinh1");
					Part hinh2 = req.getPart("hinh2");
					Part hinh3 = req.getPart("hinh3");
					Part hinh4 = req.getPart("hinh4");
					if(i == 0) {
						if (poster.getSubmittedFileName().isEmpty()) {
							String imgPos = req.getParameter("editPost");
							entity.setPoster(imgPos);
						}
						else {
							entity.setPoster(poster.getSubmittedFileName());							
						}
						i++;
					}
					
					if(i==1) {
						if(hinh1.getSubmittedFileName().isEmpty()) {
							String imgHinh1 = req.getParameter("editHinh1");
							entity.setHinh1(imgHinh1);							
						}
						else {
							entity.setHinh1(hinh1.getSubmittedFileName());
						}
						i++;
					}
					
					
					if(i == 2) {
						if(hinh2.getSubmittedFileName().isEmpty()) {
							String imgHinh2 = req.getParameter("editHinh2");
							entity.setHinh2(imgHinh2);							
						}
						else {
							entity.setHinh2(hinh2.getSubmittedFileName());
						}
						i++;
					}
					
					if(i==3) {
						if(hinh3.getSubmittedFileName().isEmpty()) {
							String imgHinh3 = req.getParameter("editHinh3");
							entity.setHinh3(imgHinh3);
						}
						else {
							entity.setHinh3(hinh3.getSubmittedFileName());
						}
						i++;
					}
					
					if(i == 4) {
						if(hinh4.getSubmittedFileName().isEmpty()) {
							String imgHinh4 = req.getParameter("editHinh4");
							entity.setHinh4(imgHinh4);
						}
						else {
							entity.setHinh4(hinh4.getSubmittedFileName());
						}
					}
					
					
//					entity.setPoster(poster.getSubmittedFileName());
//					entity.setHinh1(hinh1.getSubmittedFileName());
//					entity.setHinh2(hinh2.getSubmittedFileName());
//					entity.setHinh3(hinh3.getSubmittedFileName());
//					entity.setHinh4(hinh4.getSubmittedFileName());

					dao.update(entity);
					resp.sendRedirect("/WebMovie/manager/editPage/index");
				} catch (Exception e) {

				}
			}
		}

		else if (uri.contains("list")) {
			System.out.println(123);
			// resp.sendRedirect("/WebMovie/manager/editPage/index");
			resp.sendRedirect("/WebMovie/manager/editPage/index");
			// req.getRequestDispatcher("/manager/editPage/index").forward(req, resp);
		}

		try {
			req.getRequestDispatcher("/manager/index.jsp").forward(req, resp);
		} catch (Exception e) {

		}
	}

	private void doFill(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String maPhim = req.getParameter("maPhim");
		String title = req.getParameter("title");
		String noiDung = req.getParameter("noiDung");
		String doPhanGiai = req.getParameter("doPhanGiai");
		String daoDien = req.getParameter("daoDien");
		String phuDe = req.getParameter("phuDe");
		String trailer = req.getParameter("trailer");
		String link = req.getParameter("link");
		boolean hieuLuc = Boolean.parseBoolean(req.getParameter("hieuLuc"));
		int thoiLuong = 0;
		Date ngayCongChieu = null;

		try {
			thoiLuong = Integer.parseInt(req.getParameter("thoiLuong"));
			ngayCongChieu = Date.valueOf(req.getParameter("ngayCongChieu"));
			// System.out.println(req.getParameter("ngayCongChieu"));
		} catch (Exception e) {
		}

		Phims entity = new Phims();
		try {
			BeanUtils.populate(entity, req.getParameterMap());
		} catch (Exception e) {

		}
		req.setAttribute("phim", entity);
	}

	private boolean doValiadate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		File dir = new File(req.getServletContext().getRealPath("/fileImg1"));
		if (!dir.exists()) {
			dir.mkdirs();
		}

		// poster
		Part poster = req.getPart("poster");
		File file = new File(dir, poster.getSubmittedFileName());

		// poster

		// hinh1
		Part hinh1 = req.getPart("hinh1");
		File file1 = new File(dir, hinh1.getSubmittedFileName());

		// hinh1

		// hinh2
		Part hinh2 = req.getPart("hinh2");
		File file2 = new File(dir, hinh2.getSubmittedFileName());

		// hinh2

		// hinh3
		Part hinh3 = req.getPart("hinh3");
		File file3 = new File(dir, hinh3.getSubmittedFileName());

		// hinh3

		// hinh4
		Part hinh4 = req.getPart("hinh4");
		File file4 = new File(dir, hinh4.getSubmittedFileName());

		// hinh4

		try {
			poster.write(file.getAbsolutePath());
			hinh1.write(file1.getAbsolutePath());
			hinh2.write(file2.getAbsolutePath());
			hinh3.write(file3.getAbsolutePath());
			hinh4.write(file4.getAbsolutePath());
		} catch (Exception e) {

		}

		boolean check = false;
		String maPhim = req.getParameter("maPhim");
		String title = req.getParameter("title");
		String noiDung = req.getParameter("noiDung");
		String doPhanGiai = req.getParameter("doPhanGiai");
		String daoDien = req.getParameter("daoDien");
		int thoiLuong = 0;
		Date ngayCongChieu = null;
		try {
			thoiLuong = Integer.parseInt(req.getParameter("thoiLuong"));
			ngayCongChieu = Date.valueOf(req.getParameter("ngayCongChieu"));
		} catch (Exception e) {
		}
		// System.out.println(ngayCongChieu);
		String phuDe = req.getParameter("phuDe");
		String trailer = req.getParameter("trailer");
		String link = req.getParameter("link");
		boolean hieuLuc = Boolean.parseBoolean(req.getParameter("hieuLuc"));
		// System.out.println(poster);
		// System.out.println(hinh1);
		int i = 0;
		if (i == 0) {
			if (maPhim.isEmpty()) {
				doFill(req, resp);
				req.setAttribute("backround", "danger");
				req.setAttribute("message", "Mã phim không được để trống!");
				req.setAttribute("show", "true");
			} else {
				Phims entity = new Phims();
				PhimDAO dao = new PhimDAO();
				entity = dao.findById(maPhim);
				if (entity != null) {
					doFill(req, resp);
					req.setAttribute("backround", "danger");
					req.setAttribute("message", "Mã phim đã tồn tại!");
					req.setAttribute("show", "true");
				} else {
					doFill(req, resp);
					i++;
				}
//				NguoiDungs entity = new NguoiDungs();

			}
		}
		if (i == 1) {
			if (title.isEmpty()) {
				doFill(req, resp);
				req.setAttribute("backround", "danger");
				req.setAttribute("message", "Tiêu đề không đươc để trống!");
				req.setAttribute("show", "true");
			} else {
				doFill(req, resp);
				i++;
			}
		}
		if (i == 2) {
			if (noiDung.isEmpty()) {
				doFill(req, resp);
				req.setAttribute("backround", "danger");
				req.setAttribute("message", "Nội dung không được để trống !");
				req.setAttribute("show", "true");
			} else {
				doFill(req, resp);
				i++;
			}
		}
		if (i == 3) {
			if (doPhanGiai.equals("--Chọn--")) {
				doFill(req, resp);
				req.setAttribute("backround", "danger");
				req.setAttribute("message", "Chọn độ phân giải và không được để trống!");
				req.setAttribute("show", "true");
			} else {
				doFill(req, resp);
				i++;
			}
		}
		// System.out.println(doPhanGiai);
		if (i == 4) {
			if (daoDien.isEmpty()) {
				doFill(req, resp);
				req.setAttribute("backround", "danger");
				req.setAttribute("message", "Nhập tên giao diện!");
				req.setAttribute("show", "true");
			} else {
				doFill(req, resp);
				i++;
			}
		}
		if (i == 5) {
			// System.out.println(String.valueOf(ngayCongChieu));
			if (String.valueOf(ngayCongChieu).equals("null")) {
				doFill(req, resp);
				req.setAttribute("backround", "danger");
				req.setAttribute("message", "Chọn ngày công chiếu phim!");
				req.setAttribute("show", "true");
			} else {
				doFill(req, resp);
				i++;
			}
		}
		if (i == 6) {
			if (thoiLuong == 0) {
				doFill(req, resp);
				req.setAttribute("backround", "danger");
				req.setAttribute("message", "Nhập thời lượng phim!");
				req.setAttribute("show", "true");
			} else {
				doFill(req, resp);
				i++;
			}
		}
		if (i == 7) {
			if (phuDe.isEmpty()) {
				doFill(req, resp);
				req.setAttribute("backround", "danger");
				req.setAttribute("message", "Nhập Phụ Đề Của Phim!");
				req.setAttribute("show", "true");
			} else {
				doFill(req, resp);
				i++;
			}
		}
		if (i == 8) {
			if (trailer.isEmpty()) {
				doFill(req, resp);
				req.setAttribute("backround", "danger");
				req.setAttribute("message", "Trailer không được để trống!");
				req.setAttribute("show", "true");
			} else {
				doFill(req, resp);
				i++;
			}
		}
		if (i == 9) {
			if (link.isEmpty()) {
				doFill(req, resp);
				req.setAttribute("backround", "danger");
				req.setAttribute("message", "Link phim không được để trống!");
				req.setAttribute("show", "true");
			} else {
				doFill(req, resp);
				i++;
			}
		}
		if (i == 10) {
			if (poster.getSubmittedFileName().isEmpty()) {
				doFill(req, resp);
				req.setAttribute("backround", "danger");
				req.setAttribute("message", "Vui lòng nhập poster!");
				req.setAttribute("show", "true");
			} else {
				doFill(req, resp);
				i++;
			}
		}
		if (i == 11) {
			if (hinh1.getSubmittedFileName().isEmpty()) {
				doFill(req, resp);
				req.setAttribute("backround", "danger");
				req.setAttribute("message", "Vui lÃ²ng chá»�n hÃ¬nh 1!");
				req.setAttribute("show", "true");
			} else {
				doFill(req, resp);
				i++;
			}
		}
		if (i == 12) {
			if (hinh2.getSubmittedFileName().isEmpty()) {
				doFill(req, resp);
				req.setAttribute("backround", "danger");
				req.setAttribute("message", "Vui lÃ²ng chá»�n hÃ¬nh 2!");
				req.setAttribute("show", "true");
			} else {
				doFill(req, resp);
				i++;
			}
		}
		if (i == 13) {
			if (hinh3.getSubmittedFileName().isEmpty()) {
				doFill(req, resp);
				req.setAttribute("backround", "danger");
				req.setAttribute("message", "Vui lÃ²ng chá»�n hÃ¬nh 3!");
				req.setAttribute("show", "true");
			} else {
				i++;
			}
		}
		if (i == 14) {
			if (hinh4.getSubmittedFileName().isEmpty()) {
				doFill(req, resp);
				req.setAttribute("backround", "danger");
				req.setAttribute("message", "Vui lÃ²ng chá»�n hÃ¬nh 4!");
				req.setAttribute("show", "true");
			} else {
				doFill(req, resp);
				i++;
			}
		}
		if (i == 15) {
			check = true;
		}

		return check;
	}

	private boolean doValiadate1(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		File dir = new File(req.getServletContext().getRealPath("/fileImg1"));
		if (!dir.exists()) {
			dir.mkdirs();
		}

		// poster
		Part poster = req.getPart("poster");
		File file = new File(dir, poster.getSubmittedFileName());

		// poster

		// hinh1
		Part hinh1 = req.getPart("hinh1");
		File file1 = new File(dir, hinh1.getSubmittedFileName());

		// hinh1

		// hinh2
		Part hinh2 = req.getPart("hinh2");
		File file2 = new File(dir, hinh2.getSubmittedFileName());

		// hinh2

		// hinh3
		Part hinh3 = req.getPart("hinh3");
		File file3 = new File(dir, hinh3.getSubmittedFileName());

		// hinh3

		// hinh4
		Part hinh4 = req.getPart("hinh4");
		File file4 = new File(dir, hinh4.getSubmittedFileName());

		// hinh4

		try {
			poster.write(file.getAbsolutePath());
			hinh1.write(file1.getAbsolutePath());
			hinh2.write(file2.getAbsolutePath());
			hinh3.write(file3.getAbsolutePath());
			hinh4.write(file4.getAbsolutePath());
		} catch (Exception e) {

		}

		boolean check = false;
		String maPhim = req.getParameter("maPhim");
		String title = req.getParameter("title");
		String noiDung = req.getParameter("noiDung");
		String doPhanGiai = req.getParameter("doPhanGiai");
		String daoDien = req.getParameter("daoDien");
		int thoiLuong = 0;
		Date ngayCongChieu = null;
		try {
			thoiLuong = Integer.parseInt(req.getParameter("thoiLuong"));
			ngayCongChieu = Date.valueOf(req.getParameter("ngayCongChieu"));
		} catch (Exception e) {
		}
		// System.out.println(ngayCongChieu);
		String phuDe = req.getParameter("phuDe");
		String trailer = req.getParameter("trailer");
		String link = req.getParameter("link");
		boolean hieuLuc = Boolean.parseBoolean(req.getParameter("hieuLuc"));
		// System.out.println(poster);
		// System.out.println(hinh1);
		int i = 1;
		if (i == 1) {
			if (title.isEmpty()) {
				doFill(req, resp);
				req.setAttribute("backround", "danger");
				req.setAttribute("message", "Tiêu Đề Không Được Để Trống!");
				req.setAttribute("show", "true");
			} else {
				doFill(req, resp);
				i++;
			}
		}
		if (i == 2) {
			if (noiDung.isEmpty()) {
				doFill(req, resp);
				req.setAttribute("backround", "danger");
				req.setAttribute("message", "Nội dung không được để trống!");
				req.setAttribute("show", "true");
			} else {
				doFill(req, resp);
				i++;
			}
		}
		if (i == 3) {
			if (doPhanGiai.equals("--Chọn--")) {
				doFill(req, resp);
				req.setAttribute("backround", "danger");
				req.setAttribute("message", "Chọn độ phân giải và độ phân giải không được để trống!");
				req.setAttribute("show", "true");
			} else {
				doFill(req, resp);
				i++;
			}
		}
		// System.out.println(doPhanGiai);
		if (i == 4) {
			if (daoDien.isEmpty()) {
				doFill(req, resp);
				req.setAttribute("backround", "danger");
				req.setAttribute("message", "Nhập Tên Giao Diện!");
				req.setAttribute("show", "true");
			} else {
				doFill(req, resp);
				i++;
			}
		}
		if (i == 5) {
			// System.out.println(String.valueOf(ngayCongChieu));
			if (String.valueOf(ngayCongChieu).equals("null")) {
				doFill(req, resp);
				req.setAttribute("backround", "danger");
				req.setAttribute("message", "Chưa nhập ngày công chiếu phim!");
				req.setAttribute("show", "true");
			} else {
				doFill(req, resp);
				i++;
			}
		}
		if (i == 6) {
			if (thoiLuong == 0) {
				doFill(req, resp);
				req.setAttribute("backround", "danger");
				req.setAttribute("message", "Nhập Thời Lượng phim!");
				req.setAttribute("show", "true");
			} else {
				doFill(req, resp);
				i++;
			}
		}
		if (i == 7) {
			if (phuDe.isEmpty()) {
				doFill(req, resp);
				req.setAttribute("backround", "danger");
				req.setAttribute("message", "Nhập phụ đề phim!");
				req.setAttribute("show", "true");
			} else {
				doFill(req, resp);
				i++;
			}
		}
		if (i == 8) {
			if (trailer.isEmpty()) {
				doFill(req, resp);
				req.setAttribute("backround", "danger");
				req.setAttribute("message", "Trailer không được để trống!");
				req.setAttribute("show", "true");
			} else {
				doFill(req, resp);
				i++;
			}
		}
		if (i == 9) {
			if (link.isEmpty()) {
				doFill(req, resp);
				req.setAttribute("backround", "danger");
				req.setAttribute("message", "Link phim không được để trống");
				req.setAttribute("show", "true");
			} else {
				doFill(req, resp);
				i++;
			}
		}
		if (i == 10) {
			check = true;
		}

		return check;
	}

}
