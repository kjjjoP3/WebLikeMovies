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
	<h1 class="text-center pt-5">BÌNH LUẬN</h1>
	<hr class="line">
	<div class="container card">
		<ul class="list-unstyled">
			 <c:forEach var="item" items="${listBL}">
				<li class="media my-4"><img class="d-flex mr-3"
				src="https://cdn-icons-png.flaticon.com/512/149/149071.png" width="70" height="70"
				alt="Generic placeholder image">
				<div class="media-body">
					<h5 class="mt-0 mb-2 font-weight-bold">${item.getHo()} ${item.getTen()}</h5>
					<!--Review-->
					<c:forEach begin="1" end="${item.getSao()}">
						<i class="fas fa-star blue-text checked"> </i>
					</c:forEach>
					<c:forEach begin="1" end="${5 - item.getSao()}">
						<i class="fas fa-star blue-text"> </i>
					</c:forEach>
					 <!-- <i
						class="fas fa-star blue-text checked"> </i> <i
						class="fas fa-star blue-text checked"> </i> <i
						class="fas fa-star blue-text"> </i> <i
						class="fas fa-star blue-text"> </i> -->
					<p>${item.getNoiDung()}</p>
				</div></li>
			</c:forEach> 
		
			
			<!-- <li class="media my-4"><img class="d-flex mr-3"
				src="https://mdbootstrap.com/img/Photos/Others/avatar-min2.jpg"
				alt="Generic placeholder image">
				<div class="media-body">
					<h5 class="mt-0 mb-2 font-weight-bold">Tom Brown</h5>
					Review
					<i class="fas fa-star blue-text"> </i> <i
						class="fas fa-star blue-text"> </i> <i
						class="fas fa-star blue-text"> </i> <i
						class="fas fa-star blue-text"> </i> <i
						class="fas fa-star grey-text"> </i>
					<p>Trang web cần khắc phục nhiều.</p>
				</div></li>
			<li class="media"><img class="d-flex mr-3"
				src="https://mdbootstrap.com/img/Photos/Others/avatar-min3.jpg"
				alt="Generic placeholder image">
				<div class="media-body">
					<h5 class="mt-0 mb-2 font-weight-bold">Natalie Doe</h5>
					Review
					<i class="fas fa-star blue-text"> </i> <i
						class="fas fa-star blue-text"> </i> <i
						class="fas fa-star blue-text"> </i> <i
						class="fas fa-star grey-text"> </i> <i
						class="fas fa-star grey-text"> </i>
					<p>Xem phim bị giật lab quá nhiều.</p>
				</div></li>
			<li class="media"><img class="d-flex mr-3"
				src="https://mdbootstrap.com/img/Photos/Others/avatar-min3.jpg"
				alt="Generic placeholder image">
				<div class="media-body">
					<h5 class="mt-0 mb-2 font-weight-bold">Natalie Doe</h5>
					Review
					<i class="fas fa-star blue-text"> </i> <i
						class="fas fa-star blue-text"> </i> <i
						class="fas fa-star blue-text"> </i> <i
						class="fas fa-star grey-text"> </i> <i
						class="fas fa-star grey-text"> </i>
					<p>Cras sit amet nibh libero, in gravida nulla. Nulla vel metus
						scelerisque ante sollicitudin. Cras purus odio, vestibulum in
						vulputate at, tempus viverra turpis. Fusce condimentum nunc ac
						nisi vulputate fringilla. Donec lacinia congue felis in faucibus.</p>
				</div></li> -->
		</ul>

		<!-- Tag pagination -->
		<ul class="pagination justify-content-center" id="page">
			<li class="page-item ${disBack?'disabled':''}"><button formaction="/WebMovie/page/detail/back/${idFilm}" id="prev" class="page-link"
				href="#"><i class="fas fa-angle-double-left"></i></button></li>
			<li class="page-item ${disNext?'disabled':''}"><button formaction="/WebMovie/page/detail/next/${idFilm}" id="next" class="page-link"><i
					class="fas fa-angle-double-right"></i></button></li>
		</ul>
		<!-- Tag pagination -->
	</div>

	<div class="pt-5"></div>
</body>
</html>