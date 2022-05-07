<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <form action="/WebMovie/page/item/index" method="post">
	<ul class="pagination justify-content-center pt-3" id="page" >
        <li class="page-item ${disBack?'disabled':''}" ><button id="prev" class="page-link" formaction="/WebMovie/page/item/back/${nameUri}" ><i class="fas fa-angle-double-left"></i></button></li>
        <li class="page-item disabled" ><a id="page1" class="page-link" href="#">${page}</a></li>
        <li class="page-item ${disNext?'disabled':''}" ><button id="next" class="page-link" formaction="/WebMovie/page/item/next/${nameUri}"><i class="fas fa-angle-double-right"></i></button></li>
    </ul>
   </form>
</body>
</html>