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
	<div class="container pt-5">
        <ul class="breadcrumb">
            <li class="breadcrumb-item"><a href="#">Trang chủ</a></li>
            <li class="breadcrumb-item"><a href="#">${path}</a></li>
            <c:if test="${!empty path2}">
            	<li class="breadcrumb-item"><a href="#">${path2}</a></li>
            </c:if>
        </ul>
    </div>
</body>
</html>