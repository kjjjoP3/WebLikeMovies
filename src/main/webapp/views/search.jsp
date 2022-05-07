<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/WebMovie/page/find/index" method="get">
	<div class="container-fluid bg-primary" id="find"
		style="display: none;">
		<div class="row">
			<div class="col-sm-12 pt-3">
				<div class="container">
					<div class="input-group mb-3">
						<input type="text" name="search" class="form-control" placeholder="Tìm kiếm...">
						<div class="input-group-append">
							<button class="input-group-text" formaction="/WebMovie/page/find/index"><i class="fas fa-search"></i></button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</form>
</body>
</html>