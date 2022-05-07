<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
	<c:url var="urlLO" value="/logout" />
	<!-- Tag nav -->
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark sticky-top">
		<a class="navbar-brand" href="#"> <img src="https://e7.pngegg.com/pngimages/387/462/png-clipart-outlast-2-outlast-whistleblower-computer-icons-outlast-logo-monochrome.png"
			height="35">
		</a>

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="/WebMovie/manager/editUser/index">Người
						dùng</a></li>
				<li class="nav-item"><a class="nav-link" href="/WebMovie/UserServlet">Quản Trị</a></li>
				
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbardrop"
					data-toggle="dropdown"> Phim </a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="/WebMovie/manager/editPage/index">Tạo phim</a> 
						<a class="dropdown-item" href="/WebMovie/manager/editTL/index">Thể loại</a>
						<a class="dropdown-item" href="/WebMovie/manager/editPTH/index">Tổng hợp phim</a>
					</div></li>
				<li class="navbar-item"><a class="nav-link" href="/WebMovie/manager/BinhLuan/index">Bình
						luận</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbardrop"
					data-toggle="dropdown"> Thống kê </a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="/WebMovie/manager/favoritemanager/index">Yêu thích</a> <a
							class="dropdown-item" href="/WebMovie/manager/FavoritesUsers/index">Người dùng yêu thích</a> 
							<!-- <a class="dropdown-item" href="/WebMovie/manager/ShareUser/index"">Chia sẻ</a> -->
					</div></li>


			</ul>

			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" href="#"><i
						class="fas fa-globe-asia"></i> VietNam</a></li>

				<c:if test="${empty sessionScope.taiKhoan}">

					<li class="nav-item dropdown" id="NotLogin"><a
						class="nav-link dropdown-toggle" href="#" id="navdrop"
						data-toggle="dropdown"> <i class="fas fa-sign-in-alt"></i>
							Đăng nhập / Đăng ký
					</a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="/WebMovie/login">Đăng nhập</a>
							<hr>
							<a class="dropdown-item" href="/WebMovie/register">Đăng ký</a>
						</div></li>
				</c:if>

				<c:if test="${!empty sessionScope.taiKhoan}">
					<li class="nav-item dropdown" id="Login"><a
						style="width: 180px;" class="nav-link dropdown-toggle" href="#"
						id="navdrop" data-toggle="dropdown"> <i
							class="fas fa-user-circle"></i> ${sessionScope.taiKhoan}
					</a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="/WebMovie/page/profile/index">Thông tin</a>
							<hr>
							<a class="dropdown-item" href="${urlLO}">Đăng xuất</a>
						</div></li>
				</c:if>

			</ul>
		</div>
	</nav>
	<!-- Thẻ Nav -->
</body>
</html>