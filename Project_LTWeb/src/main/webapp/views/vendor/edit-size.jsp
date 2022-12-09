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
	<div class="container">
		<c:url value="/vendor/size/edit" var="edit"></c:url>
		<form role="form" action="${edit}" method="post">
			<input value="${sizes.product_id }" hidden="" name="product_id">
			<div class="modal-header">
				<h4 class="modal-title">Sửa Size</h4>
			</div>
			<div class="modal-body">
				<div class="form-group">
					<label>Size</label> <input name="size" type="text"
						class="form-control" required value="${sizes.size }">
				</div>
				<div class="form-group">
					<label>Tên sản phẩm</label> <input name="product_name" type="text"
						class="form-control" disabled="disabled" value="${product.name }">
				</div>
				<div class="form-group">
					<label>Số lượng</label> <input name="quantity" type="text"
						class="form-control" required value="${sizes.quantity }">
				</div>
			</div>
			<div class="modal-footer">
				<input type="button" class="btn btn-default" data-dismiss="modal"
					value="Tải lại" onclick="history.go(0)"> <input type="submit"
					class="btn btn-success" value="Sửa">
			</div>
		</form>
	</div>
</body>
</html>