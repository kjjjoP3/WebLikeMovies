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
	<div class="row">
	
		<c:forEach var="item" items="${navPCR}">
			<div class="col-md-4 product-grid">
			<div class="image">
				<a href="/WebMovie/page/detail/${item.getMaPhim()}"> <img src="/WebMovie/fileImg1/${item.getPoster()}" class="w-100">
					<div class="overlay2">
						<div class="detail">Xem chi tiết</div>
					</div>
				</a>
			</div>
			<h5 class="text-center"><a href="#" data-toggle="tooltip" data-placement="top" title="${item.getTitle()}">${item.getTitle()}</a></h5>
			<h5 class="text-center">Thời lượng: ${item.getThoiLuong()} phút</h5>
			<a href="/WebMovie/page/detail/${item.getMaPhim()}" class="btn buy">Xem phim</a>
		</div>
		</c:forEach>
	
	</div>
</body>
</html>