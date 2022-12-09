<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
		<h2>Danh sách các mặt hàng</h2>
		<a class="fa fa-plus-square-o" href="#addcategory" data-toggle="modal">
			<span>Thêm Loại Sản Phẩm</span>
		</a>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Tên</th>
					<th>Tên Miền</th>
					<th>Cập nhật</th>
					<th>Ngày Tạo</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${categoryList}" var="category">
					<tr>
						<td>${category.id }</td>
						<td>${category.name }</td>
						<td>${category.slug }</td>
						<td>${category.updatedAt }</td>
						<td>${category.createdAt }</td>
						<td><a class="btn btn-primary" type="button"
							href="<c:url value='edit?id=${category.id }'/>">Sửa</a> <a
							class="btn btn-danger" type="button"
							href="<c:url value='delete?did=${category.id }'/>">Xóa</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>



		<div id="addcategory" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					<form action="add" method="post">
						<div class="modal-header">
							<h4 class="modal-title">Thêm Mặt Hàng</h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<label>Tên</label> <input name="name" type="text"
									class="form-control" required>
							</div>
							<div class="form-group">
								<label>Tên Miền</label> <input name="slug" type="text"
									class="form-control" required>
							</div>


						</div>
						<div class="modal-footer">
							<input type="button" class="btn btn-default" data-dismiss="modal"
								value="Trở lại"> <input type="submit"
								class="btn btn-success" value="Thêm">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>

<script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable();
	});>
</script>