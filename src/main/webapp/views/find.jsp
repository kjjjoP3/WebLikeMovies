<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hành động</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link href="https://use.fontawesome.com/releases/v5.0.4/css/all.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js">
    </script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <script src="https://kit.fontawesome.com/675bbfe78c.js" crossorigin="anonymous"></script>
    <!-- nav-slide show -->
	<style type="text/css">
    	<%@include file="../css/css.css" %>
	</style>
	<!-- nav-slide show -->

    <!-- CONTENT -->
    <style type="text/css">
    	<%@include file="../css/css2.css" %>
	</style>
    <!-- CONTENT -->

    <!-- Contact -->
    <style type="text/css">
    	<%@include file="../css/style2.css" %>
	</style>
    <!-- Contact -->
    

</head>

<body>
	<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    <!-- Tag nav -->
    <%@include file="nav.jsp" %>
    <!-- Thẻ Nav -->

    <!-- Tab Search -->
    	<jsp:include page="search.jsp"></jsp:include>
    <!-- Tag Search -->

    <!-- Tag Slide-show -->
		<jsp:include page="slideshow.jsp"></jsp:include>
	<!-- Tag Slide-show -->

    <!-- Tag đường dẫn -->
    	<jsp:include page="path.jsp"></jsp:include>
    <!-- Tag đường dẫn -->

    <!-- Tag Phim chiếu rạp -->
	<jsp:include page="item.jsp"></jsp:include>
    <!-- Tag Phim chiếu rạp -->
 	
 	<div class="mb-4"></div>
 	
    <!-- Tag Liên hệ -->
    	<jsp:include page="contact.jsp"></jsp:include>
    <!-- Tag Liên hệ -->

    <!-- Tag Footer -->
    <footer>
        <div class="container-fluid w-100 text-center" style="color: white; height: 100px; background-color: grey;">
            <div class="social pt-3">
                <i class="fab fa-facebook"></i>
                <i class="fab fa-instagram"></i>
                <i class="fab fa-skype"></i>
                <i class="fab fa-youtube"></i>
                <i class="fab fa-google-plus-square"></i>
                <i class="fab fa-twitter"></i>
            </div>
            <h5>&copy; Copyright by Thanh</h5>
        </div>
    </footer>
    <!-- Tag Footer -->

    <!-- Tag To top -->
    <a href="#" class="to-top">
        <i class="fas fa-chevron-up"></i>
    </a>
    <!-- Tag To top -->


    <!-- Link Javascript -->
    <script type="text/javascript" src="/WebMovie/js/javascript.js"></script>
    <!-- <script type="text/javascript" src="js/script.js"></script> -->
    <!-- Link Javascript -->
</body>

</html>