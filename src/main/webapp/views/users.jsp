<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>
<html lang="en">
<head>
<title>${page.title }</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<base href="/WebMovie/"/>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	
</head>
<body>
	<main class="container-fluid">
		<nav class="row">
			<nav class="navbar navbar-expand-sm navbar-light bg-light col">
				<a class="navbar-brand" href="Admin/VideosManagement">Administration</a>
				<button class="navbar-toggler d-lg-none" type="button"
					data-toggle="collapse" data-target="#collapsibleNavId"
					aria-controls="collapsibleNavId" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="collapsibleNavId">
					<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
						<li class="nav-item active"><a class="nav-link" href="Admin/VideosManagement">Home
								<span class="sr-only">(current)</span>
						</a></li>
						<div class="nav-item">
							<a class="nav-link" href="Admin/VideosManagement"><i class="fa fa-info"
								aria-hidden="true"></i> Videos</a>
						</div>

						<div class="item">
							<a class="nav-link" href="Admin/UsersManagement"><i class="fa fa-id-card"
								aria-hidden="true"></i> Users</a>
						</div>
						<div class="nav-item">
							<a class="nav-link" href="ReportsManagement"><i class="fa fa-comments"
								aria-hidden="true"></i> Reports</a>
						</div>


					</ul>
					<form class="form-inline my-2 my-lg-0">
						<input class="form-control mr-sm-2" type="text"
							placeholder="Search">
						<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
					</form>
				</div>
			</nav>
		</nav>
		<div class="col mt-4">
			<jsp:include page="/common/inform.jsp"></jsp:include>
				<ul class="nav nav-tabs" id="myTab" role="tablist">
					<li class="nav-item" role="presentation"><a
						class="nav-link active" id="videoEditing-tab" data-toggle="tab"
						href="#videoEditing" role="tab" aria-controls="home"
						aria-selected="true">User Editing</a></li>
					<li class="nav-item" role="presentation"><a class="nav-link"
						id="videoList-tab" data-toggle="tab" href="#videoList" role="tab"
						aria-controls="videoList" aria-selected="false">User List</a></li>
			
				</ul>
				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade show active" id="videoEditing"
						role="tabpanel" aria-labelledby="videoEditing-tab">
						<form action="" method="post" enctype="multipart/form-data">
							<div class="card">
								<div class="card-body">
									<div class="row">
										<div class="col">
											<div class="form-group">
												<label for="username">Username</label> <input type="text"
													class="form-control" name="username" id="username" value="${user.username }"
													aria-describedby="usernamehelpId" placeholder="username">
												<small id="usernamehelpId" class="form-text text-muted">Username
													is required</small>
											</div>
											<div class="form-group">
												<label for="">Fullname</label> <input type="text"
													class="form-control" name="fullname" id="fullname" value="${user.fullname }"
													aria-describedby="fullnamehelpId" placeholder="fullname">
												<small id="fullnamehelpId" class="form-text text-muted">Fullname
													is required</small>
											</div>
										</div>
										<div class="col">
											<div class="form-group">
												<label for="">Password</label> <input type="password"
													class="form-control" name="password" id="password"
													aria-describedby="passwordhelpId" placeholder="password">
												<small id="passwordhelpId" class="form-text text-muted">Password
													is required</small>
											</div>
											<div class="form-group">
												<label for="">Email</label> <input type="text"
													class="form-control" name="email" id="email" value="${user.email }"
													aria-describedby="emailhelpId" placeholder="email"> <small
													id="emailhelpId" class="form-text text-muted">Email is
													required</small>
											</div>
										</div>
									</div>
								</div>
								<div class="card-footer text-muted">
									<button class="btn btn-primary" formaction="Admin/UsersManagement/create">Create</button>
									<button class="btn btn-warning" formaction="Admin/UsersManagement/update">Update</button>
									<button class="btn btn-danger" formaction="Admin/UsersManagement/delete">Delete</button>
									<button class="btn btn-info" formaction="Admin/UsersManagement/reset">Reset</button>
								</div>
							</div>
						</form>
					</div>
					<div class="tab-pane fade" id="videoList" role="tabpanel"
						aria-labelledby="videoList-tab">
						<table class="table table-stripe">
							<tr>
								<td>Username</td>
								<td>Fullname</td>
								<td>Email</td>
								<td>Role</td>
								<td>&nbsp;</td>
							</tr>
							<c:forEach var="item" items="${users }">
							<tr>
								<td>${item.username }</td>
								<td>${item.fullname }</td>
								<td>${item.email }</td>
								<td></td>
								<td><a href="Admin/UsersManagement/edit?username=${item.username }"><i class="fa fa-edit" aria-hidden="true"></i>Edit</a>
									<a href="Admin/UsersManagement/delete?username=${item.username }"><i class="fa fa-trasj" aria-hidden="true"></i>Delete</a>
								</td>
								
							</tr>
								</c:forEach>
						</table>
					</div>
			
				</div>
			</div>
		<footer class="row"></footer>
	</main>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
		<c:if test="${not empty page.scriptUrl }">
		<jsp:include page="${page.scriptUrl }"></jsp:include>
		</c:if>
	<script>
		$('#myTab a').on('click', function(event) {
			event.preventDefault()
			$(this).tab('show')
		})
	</script>

</body>
</html>