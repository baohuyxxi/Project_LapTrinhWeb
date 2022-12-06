<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

	<div class="container">
		<h2>Delivery</h2>

		<!-- Button to Open the Modal -->
		<button type="button" class="btn btn-primary" data-toggle="modal"
			data-target="#myModal">View info</button>

		<!-- The Modal -->
		<div class="modal fade" id="myModal">
			<div class="modal-dialog">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title">Modal Heading</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<h2>Horizontal List Groups</h2>

					<ul class="list-group list-group-horizontal">
						<li class="list-group-item">ID</li>
						<li class="list-group-item">Tên</li>
						<li class="list-group-item">Số điện thoại</li>
						<li class="list-group-item">Giá</li>
						<li class="list-group-item">status</li>
					</ul>
				</div>

			</div>
		</div>
	</div>

	</div>
</body>
</html>