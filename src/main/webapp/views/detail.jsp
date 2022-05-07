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

<!-- detail page -->
<style type="text/css">
    <%@include file="../css/detail.css" %>
</style>
<!-- detail page -->

<!-- Rating CSS modal -->
<style type="text/css">
    <%@include file="../css/rating.css" %>
</style>
<!-- Rating CSS modal -->

</head>
<body data-spy="scroll" data-target="#click1" data-offset="50"
	onload="check(${enaEdit}), check2(${message}), check3(${disEdit})">
	<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
	<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

	<!-- Thẻ Nav -->
	<%@include file="nav.jsp" %>
	<!-- Thẻ Nav -->

	<!-- Tab Search -->
		<jsp:include page="search.jsp"></jsp:include>
	<!-- Tag Search -->
	
	<!-- Tag Slide-show -->
		<jsp:include page="slideshow.jsp"></jsp:include>
		<!-- <img src="C:\Users\ADMIN\Desktop\your name\668521.jpg" width="300" height="300"> -->
	<!-- Tag Slide-show -->
	

	<!-- Tag đường dẫn -->
		<jsp:include page="path.jsp"></jsp:include>
	<!-- Tag đường dẫn -->

	<form class="form-2" action="/page/detail/index/${idFilm}" method="post">
	<!-- Tag Content -->
		<jsp:include page="content.jsp"></jsp:include>
	<!-- Tag Content -->

	<!-- Tag Information Film -->
	<h1 id="click2" class="text-center">REVIEW PHIM</h1>
	<hr class="line">
	<div class="container card container-4 ">
		<span> ${phim.getNoiDung()} </span>
	</div>
	<!-- Tag Information Film -->


	<!-- Tag Trailer phim -->
	<h1 id="" class="text-center pt-5">TRAILER</h1>
	<hr class="line">
	<div class="container card">
		<iframe width="100%" height="500"
			src="https://www.youtube.com/embed/${phim.getTrailer()}"
			frameborder=""
			allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
			allowfullscreen></iframe>
	</div>
	<!-- Tag Trailer phim -->

	<!-- Tag đánh giá -->
	<h1 class="text-center pt-5">ĐÁNH GIÁ</h1>
	<hr class="line">
	<jsp:include page="rating.jsp"></jsp:include>
	<!-- Tag đánh giá -->

	<!-- Tag Phim chiếu rạp -->
	<div class="container container-2">
		<h1 class="text-center">CÙNG THỂ LOẠI</h1>
		<hr class="line">
		<jsp:include page="navPCR.jsp"></jsp:include>
	</div>
	<!-- Tag Phim chiếu rạp -->

	<!-- Tag Comment  -->
		<jsp:include page="comment.jsp"></jsp:include>
	<!-- Tag Comment  -->
	</form>

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
			<h5>&copy; Copyright by Bui Thanh</h5>
		</div>
	</footer>
	<!-- Tag Footer -->

	<!-- Tag To top -->
	<a href="#" class="to-top"> <i class="fas fa-chevron-up"></i>
	</a>
	<!-- Tag To top -->
	
	<!-- Modal watch -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog modal-dialog2" role="document">
            <div class="modal-content">


                <div class="modal-body modal-body2">

                    <button type="button" class="close close2" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <!-- 16:9 aspect ratio -->
                    <div class="embed-responsive embed-responsive-16by9">
                        <iframe class="embed-responsive-item" src="" id="video" allowscriptaccess="always"
                            allow="autoplay" allowfullscreen></iframe>
                    </div>


                </div>

            </div>
        </div>
    </div>
    <!-- Modal watch -->

    <!-- Modal share -->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLabel">Chia sẻ: </h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <form action="/WebMovie/page/detail" method="post">
            <div class="modal-body">
              <c:if test="${message}">
              	<div class="alert alert-${color} alert-dismissible fade show">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>${status}</strong> ${text}
                </div>
              </c:if>
                <div class="form-group">
                  <label for="recipient-name" class="col-form-label">Đến:</label>
                  <input type="text" name="To" class="form-control" id="recipient-name">
                </div>
                <div class="form-group">
                  <label for="message-text" class="col-form-label">Nội dung:</label>
                  <textarea class="form-control" name="Content" id="message-text"></textarea>
                </div>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
              <button class="btn btn-primary" formaction="/WebMovie/page/detail/share/${idFilm}">Gửi</button>
            </div>
            </form>
          </div>
        </div>
      </div>
      <!-- Modal share -->
	

	<!-- Link Javascript -->
	<script type="text/javascript" src="/WebMovie/js/javascript.js"></script>
	<script type="text/javascript" src="/WebMovie/js/detail.js"></script>
	<script type="text/javascript" src="/WebMovie/js/rating.js"></script>
	<script>
        $(document).ready(function () {
            // Gets the video src from the data-src on each button
            var $videoSrc;
            $('.video-btn').click(function () {
                $videoSrc = $(this).data("src");
            });
            console.log($videoSrc);
            // when the modal is opened autoplay it  
            $('#myModal').on('shown.bs.modal', function (e) {

                // set the video src to autoplay and not to show related video. Youtube related video is like a box of chocolates... you never know what you're gonna get
                $("#video").attr('src', $videoSrc + "?autoplay=0&amp;modestbranding=1&amp;showinfo=0");
            })
            // stop playing the youtube video when I close the modal
            $('#myModal').on('hide.bs.modal', function (e) {
                // a poor man's stop video
                $("#video").attr('src', $videoSrc);
            })
            // document ready  
        });
		
        function check2(u){
            if(u == true){
                $("#exampleModal").modal("show");
            }
        }
        function check3(u){
            if(u == true){
                var edit = document.getElementById("edit");
                edit.style.pointerEvents = "none";
            }
        }
    </script>
	<!-- <script type="text/javascript" src="js/script.js"></script> -->
	<!-- Link Javascript -->
</body>
</html>