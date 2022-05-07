<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link href="https://use.fontawesome.com/releases/v5.0.4/css/all.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
	
</script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js">
	
</script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/675bbfe78c.js"
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>

<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">

    <style type="text/css">
       <%@include file="../css/delete.css" %>
    </style>
</head>
<body>
	<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
	<c:url var="urlTL" value="/manager/editTL" />

	<!-- Tag nav -->
	<%@include file="nav.jsp"%>
	<!-- Thẻ Nav -->

	<c:if test="${!empty requestScope.show}">
		<div class="container pt-4" style="display: block">
			<div
				class="alert alert-${backround} alert-dismissible fade show text-center">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				<strong style="color: red;">Thông báo!</strong> ${message}
			</div>
		</div>
	</c:if>

    <div class="pt-4"></div>
    
	<div class="container border pt-3">
		<h1 class="text-center">FORM THỂ LOẠI</h1>
		<form action="${urlTL}/index" method="post">
			<div class="form-group">
				<label>Mã thể loại:</label> <input type="text" class="form-control"
					name="maTheLoai" value="${tl.getMaTheLoai()}" ${disMaTL?'readonly':''}>
			</div>
			<div class="form-group">
				<label>Tên thể loại</label> <input type="text" class="form-control"
					name="tenTheLoai" value="${tl.getTenTheLoai()}">
			</div>
			<div class="text-center">
				<c:choose>
					<c:when test="${!empty edit}">
						<button formaction="${urlTL}/update/${phim.getMaPhim()}"
							class="btn btn-primary">Lưu</button>
					</c:when>
					<c:otherwise>
						<button formaction="${urlTL}/create" class="btn btn-primary">Lưu</button>
					</c:otherwise>
				</c:choose>
				<button class="btn btn-info" formaction="${urlTL}/index">Mới</button>
			</div>



			<h2 class="pt-4 text-center">Danh sách</h2>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Mã thể loại</th>
						<th>Tên thể loại</th>
						<th>Hành động</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="item" items="${list}">
						<tr>
							<td>${item.getMaTheLoai()}</td>
							<td>${item.getTenTheLoai()}</td>
							<td><button class="btn btn-primary btn-sm"
									formaction="${urlTL}/fillEdit/${item.getMaTheLoai()}">Sửa</button>
								| <a class="btn btn-danger btn-sm" href="#myModal"
								data-toggle="modal" onclick="result('${item.getMaTheLoai()}')">Xóa</a>
						</tr>
					</c:forEach>

				</tbody>
			</table>
	


	<div class="container pt-5 text-center pb-5">
		<ul class="pagination justify-content-center">
			<li class="page-item ${disBack?'disabled':''}"><button
					class="page-link" formaction="${urlTL}/back">
					<i class="fas fa-angle-double-left"></i>
				</button></li>
			<li class="page-item disabled"><a class="page-link">${page}</a></li>
			<li class="page-item ${disNext?'disabled':''}"><button
					class="page-link" formaction="${urlTL}/next">
					<i class="fas fa-angle-double-right"></i>
				</button></li>
		</ul>
		<label style="font-size: 15px;">Trang: <input type="number"
			max="${maxPage}" min="1" style="width: 30px;" value="${page}">/${maxPage}
		</label>
	</div>


	<!-- Modal HTML -->
	<div id="myModal" class="modal fade">
		<div class="modal-dialog modal-confirm">
			<div class="modal-content">
				<div class="modal-header flex-column">
					<div class="icon-box">
						<i class="material-icons">&#xE5CD;</i>
					</div>
					<h4 class="modal-title w-100">Bạn có chắc</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
				</div>
				<div class="modal-body">
					<p>Mọi thông tin liên quan đến thể loại phim này sẽ bị mất! Bạn
						thực sự muốn xóa?</p>
				</div>
				<div class="modal-footer justify-content-center">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Thoát</button>
					<button formaction="${urlTL}/deleteTL" name="path"
						class="btn btn-danger">Xóa</button>
					<input type="text" name="maXoa" id="result" style="display: none;">
				</div>
			</div>
		</div>
	</div>
	</form>
	</div>


	<!-- Tag Footer -->
	<footer class="pt-3">
		<div class="container-fluid w-100 text-center"
			style="color: white; height: 100px; background-color: grey;">
			<div class="social pt-3" style="font-size: 30px;">
				<i class="fab fa-facebook"></i> <i class="fab fa-instagram"></i> <i
					class="fab fa-skype"></i> <i class="fab fa-youtube"></i> <i
					class="fab fa-google-plus-square"></i> <i class="fab fa-twitter"></i>
			</div>
			<h5>&copy; Copyright by Thanh</h5>
		</div>
	</footer>
	<!-- Tag Footer -->


	<!-- Link Javascript -->
	<script type="text/javascript" src="../js/javascript.js"></script>
	<script type="text/javascript" src="../js/script.js"></script>
	<script src="js/managerPhim.js" type="../text/javascript"></script>
	<script>
		function result(u) {
			var temp = document.getElementById("result");
			temp.value = u;
			//salert(temp);
		}
	</script>
	<!-- Link Javascript -->

</body>
</html>