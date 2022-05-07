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
	<div
		class="container card bg-dark d-flex flex-wrap align-content-center">
		<div class="container-5">
			<div class="post-1">
				<div class="text-1">Cảm ơn bạn đã đánh giá!</div>
				<div class="edit-1" id="edit" onclick="check(true)">Sửa</div>
			</div>
			<div class="star-widget">
                <input type="radio" value="5" ${(start == 5)?'checked':''} name="rate" id="rate-5">
                <label for="rate-5" class="fas fa-star"></label>
                <input type="radio" value="4" ${(start == 4)?'checked':''} name="rate" id="rate-4">
                <label for="rate-4" class="fas fa-star"></label>
                <input type="radio" value="3" ${(start == 3)?'checked':''} name="rate" id="rate-3">
                <label for="rate-3" class="fas fa-star"></label>
                <input type="radio" value="2" ${(start == 2)?'checked':''} name="rate" id="rate-2">
                <label for="rate-2" class="fas fa-star"></label>
                <input type="radio" value="1" ${(start == 1)?'checked':''} name="rate" id="rate-1">
                <label for="rate-1" class="fas fa-star"></label>
                <div class="form-1" >
                    <header></header>
                    <div class="textarea">
                        <textarea cols="30" name="cntRate" placeholder="Nội dung...">${noiDung}</textarea>
                    </div>
                    <div class="btn-1">
                     	<c:choose>
                     		<c:when test="${!editRate}">
                     			<button class="click" onclick="check(false)" formaction="/WebMovie/page/detail/rating/${idFilm}" type="submit">Gửi</button>
                     		</c:when>
                     		<c:otherwise>
                     			<button class="click" onclick="check(false)" formaction="/WebMovie/page/detail/editRating/${idFilm}" type="submit">Gửi</button>
                     		</c:otherwise>
                     	</c:choose>
                        
                    </div>
                </div>
            </div>
		</div>
	</div>
</body>
</html>