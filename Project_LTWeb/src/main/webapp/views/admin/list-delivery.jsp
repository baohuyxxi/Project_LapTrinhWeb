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
		<h2>Danh sách người vận chuyển</h2>
		<div class="col-sm-6">
			<a href="#addDelivery" class="btn btn-success" data-toggle="modal"><i
				class="material-icons">&#xE147;</i> <span>Thêm Người Vận
					Chuyển</span></a>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Tên</th>
					<th>Số điện thoại</th>
					<th>Giá</th>
					<th>status</th>
					<th>Cập nhật gần nhất</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${deliveryList}" var="delivery">
					<tr>
						<td>${delivery.id }</td>
						<td>${delivery.name }</td>
						<td>${delivery.phone }</td>
						<td>${delivery.price }</td>
						<td>${delivery.status }</td>
						<td>${delivery.updatedAt }</td>
						<td><a class="btn btn-primary" type="button"
							data-toggle="modal" data-target="#edit${delivery.id}"
							>Sửa</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>


		<div id="addDelivery" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					<form action="add" method="post">
						<div class="modal-header">
							<h4 class="modal-title">Thêm Nhân Viên Giao Hàng</h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<label>Tên</label> <input name="name" type="text"
									class="form-control" required>
							</div>
							<div class="form-group">
								<label>Số điện thoại</label> <input name="phone" type="text"
									class="form-control" required>
							</div>
							<div class="form-group">
								<label>Giá</label> <input name="price" type="text"
									class="form-control" required>
							</div>
							<div class="form-group">
								<label>Trạng Thái</label>
								<textarea name="status" class="form-control" required></textarea>
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
	
	
		<div id=  "edit1" class="modal">
		<c:forEach items="${deliveryList}" var="delivery">
			<div class="modal-dialog">
				<div class="modal-content">
					<form action="edit" method="post">
						<h4 align="center" >Thêm Nhân Viên Giao Hàng ${delivery.id }</h4>
							
						<div class="modal-body">
							<input type="hidden" name="id" value="${delivery.id }" required>
							<div class="form-group">
								<label>Tên</label> 
								<input name="name" type="text" value="${delivery.name }" 
								class="form-control" required>

								<label>Số điện thoại</label> 
								<input name="phone" type="text"
									value="${delivery.phone }" 
									class="form-control" required>

								<label>Giá</label> 
								<input name="price" type="text" value="${delivery.price }" 
								class="form-control" required>

								<label>Trạng Thái</label> 
								<input name="status" value="${delivery.status }" 
								class="form-control" required>
							</div>
							<div class="modal-footer">
								<input type="button" class="btn btn-default" data-dismiss="modal" value="Trở lại"> 
								<input type="submit" class="btn btn-success" value="Sửa">
							</div>
					</form>
				</div>
			</div>
		</c:forEach>
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