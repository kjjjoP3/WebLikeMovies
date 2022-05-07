<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
	<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
	<div class="container pb-5">
		<div class="card">
			<div class="container-fliud">
				<div class="wrapper row">
					<div class="preview col-md-6">

						<div class="preview-pic tab-content">
							<div class="tab-pane active">
								<img id="pic-1" src="/WebMovie/fileImg1/${phim.getPoster()}" />
							</div>
						</div>
						<ul class="preview-thumbnail nav nav-tabs">
							<li class="active"><a data-target="#pic-1" data-toggle="tab"
								onclick="Choose(1)"><img
									src="/WebMovie/fileImg1/${phim.getPoster()}" id="img1" /></a></li>
							<li><a data-target="#pic-2" data-toggle="tab"
								onclick="Choose(2)"><img
									src="/WebMovie/fileImg1/${phim.getHinh1()}" id="img2" /></a></li>
							<li><a data-target="#pic-3" data-toggle="tab"
								onclick="Choose(3)"><img
									src="/WebMovie/fileImg1/${phim.getHinh2()}" id="img3" /></a></li>
							<li><a data-target="#pic-4" data-toggle="tab"
								onclick="Choose(4)"><img
									src="/WebMovie/fileImg1/${phim.getHinh3()}" id="img4" /></a></li>
							<li><a data-target="#pic-5" data-toggle="tab"
								onclick="Choose(5)"><img
									src="/WebMovie/fileImg1/${phim.getHinh4()}" id="img5" /></a></li>
						</ul>

					</div>
					<div class="details col-md-6">
						<h3 class="product-title">${phim.getTitle()}</h3>
						<div class="rating">
							<div class="stars">
								<c:forEach begin="1" end="${enaStart}">
									<i class="fas fa-star blue-text checked"> </i>
								</c:forEach>
								<c:forEach begin="1" end="${5 - enaStart}">
									<i class="fas fa-star blue-text"> </i>
								</c:forEach>
							</div>
							<span class="review-no">${maxRating} lượt đánh giá</span>
						</div>
						<p class="product-description">${review}
							<a href="#click2" id="click1" onclick="movePage()">Xem thêm</a>
						</p>
						<h4 class="price">
							ĐỘ PHÂN GIẢI: <span>${phim.getDoPhanGiai().toUpperCase()}</span>
						</h4>
						<p class="vote">
							<strong>Đạo diễn: </strong> ${phim.getDaoDien()}
						</p>
						<p class="vote">
							<strong>Ngày công chiếu: </strong><fmt:formatDate value="${phim.getNgayCongChieu()}" pattern="dd-MM-yyyy"/> 
						</p>
						<p class="vote">
							<strong>Thời lượng: </strong> ${phim.getThoiLuong()} phút
						</p>
						<p class="vote">
							<strong>Phụ đề: </strong> ${phim.getPhuDe()}
						</p>
						<p class="vote">
							<strong>Lượt xem: </strong> ${phim.getLuotXem()}
						</p>
						<p class="vote">
							<strong>Thể loại: </strong> ${theLoai}
						</p>
						
						<div class="action">
							<button class="add-to-cart btn btn-default video-btn" type="button" data-toggle="modal"
                                data-src="https://www.youtube.com/embed/${phim.getLink()}" data-target="#myModal">Xem
								phim</button>
							<c:if test="${!check}">
								<button class="like btn btn-default" type="button" disabled>
									<span >Đã Like</span>
								</button>
							</c:if>
							
							<c:if test="${check}">
								<button class="like btn btn-default" formaction="/WebMovie/page/detail/favorite/${idFilm}">
									<span >Like</span>
								</button>
							</c:if>
							
							<c:if test="${empty sessionScope.taiKhoan}">
								<button class="like btn btn-default" type="button" disabled>
									<span >Đã Chia Sẻ</span>
								</button>
							</c:if>
							
							<c:if test="${!empty sessionScope.taiKhoan}">
								<button class="like btn btn-default" type="button" data-toggle="modal"
                                data-target="#exampleModal" data-whatever="@mdo">
									 <span>Chia Sẻ</span>
								</button>
							</c:if>
							

						</div>
						
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>