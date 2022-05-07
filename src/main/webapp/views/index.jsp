<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Index</title>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/675bbfe78c.js" crossorigin="anonymous"></script>
<link href="https://use.fontawesome.com/releases/v5.0.4/css/all.css" rel="stylesheet">


<!-- nav-slide show -->
<style type="text/css">
    <%@include file="../css/css.css" %>
</style>
<!-- nav-slide show -->

<style type="text/css">
    <%@include file="../css/css2.css" %>
</style>


<!-- Contact -->
<style type="text/css">
    <%@include file="../css/style2.css" %>
</style>
<!-- Contact -->



<!-- slider item -->
<style type="text/css">
    <%@include file="../css/style.css" %>
    <%@include file="../css/lightslider.css" %>
</style>
<script type="text/javascript" src="/WebMovie/js/Jquery.js"></script>
<script type="text/javascript" src="/WebMovie/js/lightslider.js"></script>
<!-- slider item -->

</head>
<body>
	<%@include file="nav.jsp" %>    

	<!-- Tab Search -->
		<jsp:include page="search.jsp"></jsp:include>
	<!-- Tag Search -->

	<!-- Tag Slide-show -->
		<jsp:include page="slideshow.jsp"></jsp:include>
	<!-- Tag Slide-show -->

	<!-- <div class="container-fluid pt-3 bg-primary" id="wid" style="text-align: center; height: 300px; width: 95%;">
        <div class="row text-center">
            <div class="col-md-3">
             
            </div>

            <div class="col-md-3">

            </div>

            <div class="col-md-3">
               
            </div>

            <div class="col-md-3">
               
            </div>
        </div>
    </div> -->


	<!-- Tag Phim đề cử -->
	<%-- <%@include file="carouselitem.jsp" %> --%>
	<jsp:include page="carouselitem.jsp"></jsp:include>
	<!-- Tag Phim đề cử -->

	<!-- Tag Phim chiếu rạp -->
	<div class="container container-2">
		<h1 class="text-center">PHIM CHIẾU RẠP</h1>
		<hr class="line">
		<jsp:include page="navPCR.jsp"></jsp:include>
	</div>
	<!-- Tag Phim chiếu rạp -->

	<!-- Tag Xem thêm -->
	<div class="container pt-4">
		<a href="/WebMovie/page/item/1" class="btn btn-outline-info btn-block">Xem
			thêm</a>
	</div>
	<!-- Tag Xem thêm -->

	<!-- Tag Phim bộ -->
	<div class="container container-2">
		<h1 class="text-center">PHIM HOẠT HÌNH</h1>
		<hr class="line">
		<jsp:include page="navPHH.jsp"></jsp:include>
	</div>
	<!-- Tag Phim bộ -->

	<!-- Tag Xem thêm -->
	<div class="container pt-4 pb-4">
		<a href="/WebMovie/page/item/0" class="btn btn-outline-info btn-block">Xem
			thêm</a>
	</div>
	<!-- Tag Xem thêm -->

	<!-- Tag Liên hệ -->
	<jsp:include page="contact.jsp"></jsp:include>
	<!-- Tag Liên hệ -->

	<!-- Tag Footer -->
	<footer>
		<div class="container-fluid w-100 text-center"
			style="color: white; height: 100px; background-color: grey;">
			<div class="social pt-3">
				<i class="fab fa-facebook"></i> <i class="fab fa-instagram"></i> <i
					class="fab fa-skype"></i> <i class="fab fa-youtube"></i> <i
					class="fab fa-google-plus-square"></i> <i class="fab fa-twitter"></i>
			</div>
			
		</div>
	</footer>
	<!-- Tag Footer -->

	<!-- Tag To top -->
	<a href="#" class="to-top"> <i class="fas fa-chevron-up"></i>
	</a>
	<!-- Tag To top -->

	<!-- Link Javascript -->
	<script type="text/javascript" src="/WebMovie/js/javascript.js"></script>
	<script type="text/javascript" src="/WebMovie/js/script.js"></script>
	<!-- Link Javascript -->



</body>
</html>