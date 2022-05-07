package com.poly.Servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.DAO.BinhLuanDAO;
import com.poly.DAO.NguoiDungDAO;
import com.poly.DAO.PhimDAO;
import com.poly.DAO.PhimTHDAO;
import com.poly.DAO.TheLoaiDAO;
import com.poly.DAO.YeuThichDAO;
import com.poly.Entity.BinhLuans;
import com.poly.Entity.NguoiDungs;
import com.poly.Entity.Phims;
import com.poly.Entity.TamPTH;
import com.poly.Entity.TamRating;
import com.poly.Entity.TheLoais;
import com.poly.Entity.YeuThichs;

@WebServlet({ "/page/detail/*", "/page/detail/", "/page/detail/index", "/page/detail/favorite/*",
		"/page/detail/share/*", "/page/detail/back/*", "/page/detail/next/*", "/page/detail/rating/*",
		"/page/detail/editRating/*" })
public class DetailServlet extends HttpServlet {
	int i = 0;
	int maxPage = 0;
	int maxStart = 0;
	int size = 0;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// req.setAttribute("message", false);
		doCall(req, resp);

		// page
		String uri = req.getRequestURI();
		String id = uri.substring(uri.lastIndexOf("/") + 1);
		i = 0;
		maxPage = 0;
		maxStart = 0;
		size = 0;
		BinhLuans entityBL = new BinhLuans();
		BinhLuanDAO daoBL = new BinhLuanDAO();
		List<TamRating> listBL = daoBL.findItem(i, id);

		for (int i = 0; i < listBL.size(); i++) {
			maxStart = maxStart + listBL.get(i).getSao();
		}
		try {
			maxStart = Math.round(maxStart / (listBL.size()));
			size = listBL.size();
		} catch (Exception e) {
			maxStart = 0;
			size = 0;
		}

		req.setAttribute("enaStart", maxStart);
		req.setAttribute("maxRating", size);

		req.setAttribute("listBL", listBL);
		int result = 0;
		if (daoBL.Count(id) <= 5) {
			maxPage = 1;
		} else {
			result = (int) ((daoBL.Count(id) - 1) / 5);
			if ((daoBL.Count(id) / 5) != 0) {
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
		// page

		req.getRequestDispatcher("/views/detail.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// req.setAttribute("message", false);
		String uri = req.getRequestURI();
		if (uri.contains("favorite")) {
			doFavorite(req, resp);
		}
		if (uri.contains("share")) {
			doShare(req, resp);
		}
		if (uri.contains("rating")) {
			doRating(req, resp);
		}
		if (uri.contains("editRating")) {
			doEditRate(req, resp);
		}
		if (uri.contains("next")) {
			doNext(req, resp);
		}
		if (uri.contains("back")) {
			doBack(req, resp);
		}
		// req.getRequestDispatcher("/views/detail.jsp").forward(req, resp);
	}

	private void doNext(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String id = uri.substring(uri.lastIndexOf("/") + 1);

		i++;

		if (i >= (maxPage - 1)) {
			// list = dao.findItem(maxPage);
			req.setAttribute("disNext", true);
			i = maxPage - 1;
		} else {
			req.setAttribute("disNext", false);
		}
		BinhLuanDAO daoBL = new BinhLuanDAO();
		List<TamRating> listBL = daoBL.findItem(i, id);

		req.setAttribute("enaStart", maxStart);
		req.setAttribute("maxRating", size);

		req.setAttribute("listBL", listBL);
		doCall(req, resp);
		req.getRequestDispatcher("/views/detail.jsp").forward(req, resp);
	}

	private void doBack(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String id = uri.substring(uri.lastIndexOf("/") + 1);

		i--;
		if (i <= 0) {
			// list = dao.findItem(maxPage);
			req.setAttribute("disBack", true);
			i = 0;
		} else {
			req.setAttribute("disBack", false);
		}

		BinhLuanDAO daoBL = new BinhLuanDAO();
		List<TamRating> listBL = daoBL.findItem(i, id);
		req.setAttribute("listBL", listBL);

		req.setAttribute("enaStart", maxStart);
		req.setAttribute("maxRating", size);

		doCall(req, resp);
		req.getRequestDispatcher("/views/detail.jsp").forward(req, resp);
	}

	private void doCall(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// VỪA GỌI PHIM VÀ CUGF THỂ LOẠI PHIM 
		
		String uri = req.getRequestURI();
		String id = uri.substring(uri.lastIndexOf("/") + 1);
		req.setAttribute("idFilm", id);

		Phims entity = new Phims();
		TheLoais entitytl = new TheLoais();
		PhimDAO dao = new PhimDAO();
		TheLoaiDAO daotl = new TheLoaiDAO();
		entity = dao.findById(id);
		List<Phims> listCTL = dao.fillNavCTL(id);
		List<TheLoais> listTL = daotl.findAll();
		req.setAttribute("nav", listTL);
		req.setAttribute("navPCR", listCTL);

		String review = "";
		try {
			review = entity.getNoiDung().substring(0, 295);
		} catch (Exception e) {
			review = entity.getNoiDung();
		}
		req.setAttribute("review", review);
		req.setAttribute("theLoai", daotl.nameFilm(id));
		req.setAttribute("phim", entity);

//		Yêu Thích
		YeuThichDAO daoYT = new YeuThichDAO();
		YeuThichs entityYT = new YeuThichs();
		String user = (String) req.getSession().getAttribute("taiKhoan");
		boolean check;
		if (user == null) {
			check = false;
		} else {
			try {
				entityYT = daoYT.selectByUser(user, id);
				check = false;
			} catch (NoResultException e) {
				check = true;
			}
		}
		req.setAttribute("check", check);
//		Yêu Thích

		//Bình Luận
		BinhLuans entityBL = new BinhLuans();
		BinhLuanDAO daoBL = new BinhLuanDAO();
		if (user == null) {
			req.setAttribute("disEdit", true);
			req.setAttribute("enaEdit", false);
		} else {
			try {
				entityBL = daoBL.selectByUser(user, id);
				req.setAttribute("start", entityBL.getSao());
				req.setAttribute("noiDung", entityBL.getNoiDung());
				req.setAttribute("disEdit", false);
				req.setAttribute("enaEdit", false);
				req.setAttribute("editRate", true);
			} catch (NoResultException e) {
				req.setAttribute("disEdit", false);
				req.setAttribute("enaEdit", true);
				req.setAttribute("editRate", false);
			}
		}
		// Bình luận

		// Path
		PhimTHDAO daoTH = new PhimTHDAO();
		TamPTH entityPTH = daoTH.fillPath(id);
		req.setAttribute("path", entityPTH.getTenTheLoai());
		req.setAttribute("path2", entityPTH.getTitle());
		// Path
	}

	private void doFavorite(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String id = uri.substring(uri.lastIndexOf("/") + 1);
		String user = (String) req.getSession().getAttribute("taiKhoan");
		YeuThichDAO daoYT = new YeuThichDAO();
		NguoiDungDAO daoND = new NguoiDungDAO();
		PhimDAO daoP = new PhimDAO();

		YeuThichs entityYT = new YeuThichs();
		entityYT.setNguoidungs(daoND.findById(user));
		entityYT.setPhim(daoP.findById(id));
		daoYT.create(entityYT);

		resp.sendRedirect("/WebMovie/page/detail/" + id);
	}

	private void doRating(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String uri = req.getRequestURI();
		String id = uri.substring(uri.lastIndexOf("/") + 1);
		String user = (String) req.getSession().getAttribute("taiKhoan");

		BinhLuanDAO dao = new BinhLuanDAO();
		NguoiDungDAO daoND = new NguoiDungDAO();
		PhimDAO daoP = new PhimDAO();

		int start = Integer.parseInt(req.getParameter("rate"));
		String content = req.getParameter("cntRate");
		BinhLuans entity = new BinhLuans();

		entity.setNguoidungs(daoND.findById(user));
		entity.setPhims(daoP.findById(id));
		entity.setSao(start);
		entity.setNoiDung(content);

		dao.create(entity);

		resp.sendRedirect("/WebMovie/page/detail/" + id);
	}

	private void doEditRate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String uri = req.getRequestURI();
		String id = uri.substring(uri.lastIndexOf("/") + 1);
		String user = (String) req.getSession().getAttribute("taiKhoan");

		BinhLuanDAO dao = new BinhLuanDAO();

		int start = Integer.parseInt(req.getParameter("rate"));
		String content = req.getParameter("cntRate");
		BinhLuans entity = new BinhLuans();

		entity = dao.selectByUser(user, id);
		entity.setSao(start);
		entity.setNoiDung(content);
		dao.update(entity);

		resp.sendRedirect("/WebMovie/page/detail/" + id);
	}

	private void doShare(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String uri = req.getRequestURI();
		String id = uri.substring(uri.lastIndexOf("/") + 1);
		String user = (String) req.getSession().getAttribute("taiKhoan");
		NguoiDungDAO daoND = new NguoiDungDAO();
		PhimDAO daoP = new PhimDAO();
		NguoiDungs nguoiDung = daoND.findById(user);
		Phims phim = daoP.findById(id);

		String from = "thanh12cok@gmail.com";
		String to = req.getParameter("To");
		String content = req.getParameter("Content");
		String body = "Bạn <b>" + nguoiDung.getHo() + " " + nguoiDung.getTen() + "</b> đã chia sẻ phim <b>"
				+ phim.getTitle() + "</b> trên web http://localhost:8080/WebMovie/index. Chúc bạn xem phim vui vẻ!"
				+ "<br> <a href=\"http://localhost:8080/WebMovie/page/detail/" + id + "\">Link phim</a>"
				+ "<br> <p>Link Trailer: </p>" + "https://www.youtube.com/watch?v=" + phim.getTrailer();
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.starttls.required", "true");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		Session session = Session.getInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				String userName = "thanh12cok@gmail.com";
				String passWord = "0905615266Haha";
				return new PasswordAuthentication(userName, passWord);
			}

		});

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, to);
			message.setSubject(content, "utf-8");
			message.setText(body, "utf-8", "html");
			message.setReplyTo(message.getFrom());

			Transport.send(message);

			req.setAttribute("message", true);
			req.setAttribute("color", "success");
			req.setAttribute("status", "Thành công!");
			req.setAttribute("text", "Chia sẻ thành công!");
		} catch (Exception e) {
			req.setAttribute("message", true);
			req.setAttribute("color", "danger");
			req.setAttribute("status", "Thất Bại!");
			req.setAttribute("text", "Chia sẻ thất bại!");
		}
		// resp.sendRedirect("/WebMovie/page/detail/share/" + id);
		doGet(req, resp);
		// req.getRequestDispatcher("/views/detail.jsp").forward(req, resp);
	}
}
