<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<style>
body {
	color: #fff;
	background: #63738a;
	font-family: 'Roboto', sans-serif;
}

.form-control {
	height: 40px;
	box-shadow: none;
	color: #969fa4;
}

.form-control:focus {
	border-color: #5cb85c;
}

.form-control, .btn {
	border-radius: 3px;
}

.signup-form {
	width: 450px;
	margin: 0 auto;
	padding: 30px 0;
	font-size: 15px;
}

.signup-form h2 {
	color: #636363;
	margin: 0 0 15px;
	position: relative;
	text-align: center;
}

.signup-form h2:before, .signup-form h2:after {
	content: "";
	height: 2px;
	width: 28%;
	background: #d4d4d4;
	position: absolute;
	top: 50%;
	z-index: 2;
}

.signup-form h2:before {
	left: 0;
}

.signup-form h2:after {
	right: 0;
}

.signup-form .hint-text {
	color: #999;
	margin-bottom: 30px;
	text-align: center;
}

.signup-form form {
	color: #999;
	border-radius: 3px;
	margin-bottom: 15px;
	background: #f2f3f7;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	padding: 30px;
}

.signup-form .form-group {
	margin-bottom: 20px;
}

.signup-form input[type="checkbox"] {
	margin-top: 3px;
}

.signup-form .btn {
	font-size: 16px;
	font-weight: bold;
	min-width: 140px;
	outline: none !important;
}

.signup-form .row div:first-child {
	padding-right: 10px;
}

.signup-form .row div:last-child {
	padding-left: 10px;
}

.signup-form a {
	color: #fff;
	text-decoration: underline;
}

.signup-form a:hover {
	text-decoration: none;
}

.signup-form form a {
	color: #5cb85c;
	text-decoration: none;
}

.signup-form form a:hover {
	text-decoration: underline;
}
</style>
</head>
<body>
	<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
	<c:url var="url" value="/login" />

	<c:if test="${!empty requestScope.show}">
		<div class="container pt-4" style="display: block">
			<div
				class="alert alert-${backround} alert-dismissible fade show text-center">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				<strong style="color: red;">Thông báo!</strong> ${message}
			</div>
		</div>
	</c:if>

	<div class="signup-form">

		<form action="${url}" method="post">
			<h2>Đăng nhập</h2>
			<p class="hint-text">Đăng nhập vào chương trình để có trải nghiệm
				tốt nhất.</p>
			<div class="form-group">
				<input type="text" class="form-control" name="tenDN"
					value="${tenDN}" placeholder="Tên đăng nhập">
			</div>
			<div class="form-group">
				<input type="password" class="form-control" name="matKhau"
					value="${matKhau}" placeholder="Mật khẩu">
			</div>
			<div class="form-group">
				<label class="form-check-label"><input type="checkbox"
					name="luuTK" value="true" ${luuTK?'checked':''}> Lưu tài khoản?</label> <a href="/WebMovie/forgetPassword"
					class="float-right" name="quenMK">Quên mật khẩu?</a>
			</div>

			<div class="form-group">
				<button type="submit" class="btn btn-success btn-lg btn-block">Đăng
					nhập</button>
			</div>
		</form>
		<div class="text-center">
			Bạn chưa có tài khoản? <a href="/WebMovie/register">Đăng ký</a>
		</div>
		<div class="text-center">
			Trở về <a href="/WebMovie/index">trang chủ</a>
		</div>
	</div>
</body>