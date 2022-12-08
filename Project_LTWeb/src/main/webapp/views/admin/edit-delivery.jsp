<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:url value="/admin/delivery/edit" var="edit"></c:url>
	<div class="container">
	<form role="form" action="${edit }" method="post">
		<h4 align="center">Sửa Nhân Viên Giao Hàng </h4>
		<input type="hidden" name="id" value="${delivery.id }" >
		<div class="form-group">
			<label>Tên</label> <input name="name" type="text"
				value="${delivery.name }" class="form-control"> <label>Số
				điện thoại</label> <input name="phone" type="text"
				value="${delivery.phone }" class="form-control" > <label>Giá</label>
			<input name="price" type="text" value="${delivery.price }"
				class="form-control" > <label>Trạng Thái</label> <input
				name="status" value="${delivery.status }" class="form-control"
				>
		</div>
		<div class="modal-footer">
			<input type="button" class="btn btn-default" data-dismiss="modal"
				value="Trở lại"> <input type="submit"
				class="btn btn-success" value="Sửa">
		</div>
	</form>
	</div>
</body>
</html>