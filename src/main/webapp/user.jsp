<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link href="https://use.fontawesome.com/releases/v5.0.4/css/all.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js">
    </script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <script src="https://kit.fontawesome.com/675bbfe78c.js" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

    <style type="text/css">
       <%@include file="../css/delete.css" %>
    </style>
<base href="/WebMovie/" />
<title>Hello, world!</title>
</head>
<body>
	
	
	<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
	
	

	<!-- Tag nav -->
	<%@include file="manager/nav.jsp"%>
	<!-- Thẻ Nav -->
	
	
	
	<div style="padding-top: 25px" class="row">
			<div class="col">
			  <c:if test="${not empty message }">
				<div class="alert alert-success">${message }</div>
				</c:if>
				 <c:if test="${not empty error }">
				<div class="alert alert-danger">${error }</div>
				</c:if>
			</div>
		</div>
		
		<h2 style="margin-left: 25px">Danh sách người dùng Theo Mã</h2>
		
		<div style="margin-top: 15px;margin-left: 25px"  class="row">
		
			<div class="col">
				<form action="UserServlet" method="post">
					<div class="form-group">
						<label for="tenDN">Tên Đăng Nhập:</label> <input type="text"
							name="tenDN" id="tenDN" class="form-control" value="${user.tenDN }"/>
					</div>
					<div class="form-group">
						<label for="matKhau">Mật Khẩu:</label> <input type="matKhau"
							class="form-control" name="matKhau" id="matKhau" value="${user.getMatKhau() }" />
					</div>
					<div class="form-group">
						<label for="ho">Ho:</label> <input type="text"
							class="form-control" name="ho" id="ho" value="${user.getHo() }"
							/>
					</div>
					<div class="form-group">
						<label for="ten">Tên:</label> <input type="text"
							class="form-control" name="ten" id="ten" value="${user.getTen() }"
							/>
					</div>
					<div class="form-group">
						<label for="email">Email:</label> <input type="text"
							class="form-control" id="email" name="email" value="${user.getEmail() }"
							/>
					</div>
					
					
					
					<div class="form-check form-check-inline">
					
					
						<label for="">Vai Trò:&nbsp;&nbsp;&nbsp;&nbsp;</label> <label class="ml-2">Quản Trị&nbsp;&nbsp;<input
							type="radio" class="form-check-input" id="vaiTro" name="vaiTro" value="true" ${user.vaiTro? 'checked':'' } /></label>
							 <label class="ml-2">Người Dùng&nbsp;&nbsp;&nbsp;<input
							type="radio" class="form-check-input" id="vaiTro" name="vaiTro" value="false" ${! user.vaiTro? 'checked':'' }
							 /></label>
					</div>
					<div class="form-group">
						<button class="btn btn-primary" formaction="UserServlet/create">Thêm</button>
						<button class="btn btn-success" formaction="UserServlet/update">Cập Nhật</button>
						<button class="btn btn-danger" formaction="UserServlet/delete">Xóa</button>
						<button class="btn btn-warning" formaction="UserServlet/reset">Làm Mới</button>		
						<input type="text" name="find" id="" />
						<button class="btn btn-primary" formaction="UserServlet/find">Find</button>				
					</div>
				</form>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<table class="table table-stripe">
					<tr>
						<td>Tên Đăng Nhập</td>
						<td>Họ</td>
						<td>Tên</td>
						<td>Email</td>
						<td>Mật Khẩu</td>
						<td>&nbsp;</td>
					</tr>
					<c:forEach var="item" items="${users }">
						<tr>
							<td> ${item.tenDN}</td>
							<td> ${item.getHo()}</td>
							<td> ${item.getTen()}</td>
							<td> ${item.getEmail()}</td>
							<td> ${item.getMatKhau()}</td>
							<td><a href="UserServlet/edit?tenDN=${item.tenDN }">Edit</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	
	<!-- Modal xóa HTML -->
			<div id="myModal" class="modal fade">
				<div class="modal-dialog modal-confirm">
					<div class="modal-content">
						<div class="modal-header flex-column">
							<div class="icon-box">
								<i class="material-icons">&#xE5CD;</i>
							</div>
							<h4 class="modal-title w-100">Bạn có chắc?</h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
						</div>
						<div class="modal-body">
							<p>Mọi thông tin liên quan tới người dùng này sẽ bị xóa mất.
								Bạn có thực sự muốn xóa người dùng này không?</p>
						</div>
						<div class="modal-footer justify-content-center">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Cancel</button>
							<button formaction="${urlUser}/delete" class="btn btn-danger">Delete</button>
							<input type="text" name="maXoa" id="result"
								style="display: none;">
						</div>
					</div>
				</div>
			</div>

			<!-- Modal cập nhật HTML -->
			<div id="myModal2" class="modal fade">
				<div class="modal-dialog modal-confirm">
					<div class="modal-content">
						<div class="modal-header flex-column">
							<div class="icon-box">
								<i class="material-icons">&#xE5CD;</i>
							</div>
							<h4 class="modal-title w-100">Bạn có chắc?</h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
						</div>
						<div class="modal-body">
							<p>Bạn có muốn thay đổi vai trò của người dùng này không?</p>
						</div>
						<div class="modal-footer justify-content-center">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Cancel</button>
							<button formaction="${urlUser}/update" class="btn btn-danger">Update</button>
							<input type="text" name="maUpdate" id="result2"
								style="display: none;">
						</div>
					</div>
				</div>
			</div>
	</form>
	</div>



	<!-- Tag Footer -->
	<footer>
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


	<script type="text/javascript">
		function result1(u) {
			var temp = document.getElementById("result");
			temp.value = u;
			//salert(temp);
		}

		function result2(u) {
			var temp = document.getElementById("result2");
			temp.value = u;
			//salert(temp);
		}
	</script>

</body>
</html>