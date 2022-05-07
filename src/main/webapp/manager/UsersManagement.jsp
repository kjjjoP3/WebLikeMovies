<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css"
	integrity="sha512-8bHTC73gkZ7rZ7vpqUQThUDhqcNFyYi2xgDgPDHc+GXVGHXq+xPjynxIopALmOPqzo9JZj0k6OqqewdGO3EsrQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.js"
	integrity="sha512-dqw6X88iGgZlTsONxZK9ePmJEFrmHwpuMrsUChjAw1mRUhUITE5QU9pkcSox+ynfLhL15Sv2al5A0LVyDCmtUw=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
            integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
            crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
            integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
            crossorigin="anonymous"></script>
             <style>
            .text {
color: black;
position: absolute;
top: 80px;
margin-left: 10px;
}
        </style>
<base href="/WebMovie/" />
<title>Hello, world!</title>
</head>
<body>
	<main class="container">
	
	<h1 class="text">User Manager</h1>
            <img src="https://img.freepik.com/free-photo/hand-painted-watercolor-background-with-sky-clouds-shape_24972-1095.jpg?size=626&ext=jpg"
                width="1300px" height="150px" alt="">
	
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
		<div class="row">
			<div class="col">
				<form action="UserServlet" method="post">
					<div class="form-group">
						<label for="userId">User ID:</label> <input type="text"
							name="userId" id="userId" class="form-control" value="${user.userId }"/>
					</div>
					<div class="form-group">
						<label for="password">Password:</label> <input type="password"
							class="form-control" name="password" id="password" value="${user.password }" />
					</div>
					<div class="form-group">
						<label for="fullname">Fullname:</label> <input type="text"
							class="form-control" name="fullname" id="fullname" value="${user.fullname }"
							/>
					</div>
					<div class="form-group">
						<label for="email">Email:</label> <input type="text"
							class="form-control" id="email" name="email" value="${user.email }"
							/>
					</div>
					<div class="form-check form-check-inline">
					
					
						<label for="">Role:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <label class="ml-2">Admin&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
							type="radio" class="form-check-input" id="admin" name="admin" value="true" ${user.admin? 'checked':'' } /></label>
							 <label class="ml-2">User&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
							type="radio" class="form-check-input" id="user" name="admin" value="false" ${! user.admin? 'checked':'' }
							 /></label>
					</div>
					<div class="form-group">
						<button class="btn btn-primary" formaction="UserServlet/create">Create</button>
						<button class="btn btn-success" formaction="UserServlet/update">Update</button>
						<button class="btn btn-danger" formaction="UserServlet/delete">Delete</button>
						<button class="btn btn-warning" formaction="UserServlet/reset">Reset</button>
						<button class="btn btn-info" formaction="UserServlet/logout">Logout</button>
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
						<td>User Id</td>
						<td>Fullname</td>
						<td>Email</td>
						<td>Role</td>
						<td>&nbsp;</td>
					</tr>
					<c:forEach var="item" items="${users }">
						<tr>
							<td> <a href="UserServlet/edit?userId=${item.userId }">${item.userId}</a> </td>
							<td>${item.fullname}</td>
							<td>${item.email}</td>
							<td>${item.admin? 'Admin':'User'}</td>
							<td><a href="UserServlet/edit?userId=${item.userId }">Edit</a>
							<a href="UserServlet/delete?userId=${item.userId }">Delete</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</main>
	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
		crossorigin="anonymous"></script>

</body>
</html>