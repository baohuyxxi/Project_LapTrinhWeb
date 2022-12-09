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
		<h2>Danh sách sản phẩm</h2>
		<a class="fa fa-plus-square-o"
			 href="#addDelivery"  data-toggle="modal">
			<span>Thêm sản phẩm</span></a>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Tên SP</th>
					<th>Tên miền</th>
					<th>Mô tả</th>
					<th>Giá</th>
					<th>Khuyến mãi</th>
					<th>Số lượng</th>
					<th>SL đã bán</th>
					<th>Mã Loại</th>
					<th>Mã cửa hàng</th>
					<th>Ngày thêm</th>
					<th>Ngày cập nhật</th>
					

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${productList}" var="product">
					<tr>
						<td>${product.id }</td>
						<td>${product.name }</td>
						<td>${product.slug }</td>
						<td>${product.description }</td>
						<td>${product.price }</td>
						<td>${product.promotion }</td>
						<td>${product.quantity }</td>
						<td>${product.sold }</td>
						<td>${product.category_id }</td>
						<td>${product.storeId }</td>
						<td>${product.createdAt }</td>
						<td>${product.updatedAt }</td>
						<td><a class="btn btn-primary" type="button"
							href="<c:url value='edit?id=${product.id }'/>">Sửa</a>
							<a class="btn btn-danger" type="button"
							href="<c:url value='delete?did=${product.id }'/>" >Xóa</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>


		<div id="addDelivery" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					<form action="add" method="post">
						<div class="modal-header">
							<h4 class="modal-title">Thêm Sản phẩm</h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<label>Tên</label> <input name="name" type="text"
									class="form-control" required>
							</div>
							<div class="form-group">
								<label>Loại SP</label> <select name="category_id">
								<c:forEach items="categoryList" var="category">
								<option value="${category.id }">${category.name }</option>
								</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label>Tên miền</label> <input name="slug" type="text"
									class="form-control" required>
							</div>
							<div class="form-group">
								<label>Mô tả</label>
								<textarea name="description" class="form-control" required></textarea>
							</div>
							<div class="form-group">
								<label>Giá</label> <input name="price" type="text"
									class="form-control" required>
							</div>
							<div class="form-group">
								<label>Khuyến mãi</label> <input name="promotion" type="text"
									class="form-control" required>
							</div>
							<div class="form-group">
								<label>Số lượng</label> <input name="quantity" type="text"
									class="form-control" required>
							</div>
							<div class="form-group">
								<label>Đã bán</label> <input name="slod" type="text"
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

<script>
	btn.onclick = function() {
		modal.style.display = "block";
	}
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable();
	});>
</script>