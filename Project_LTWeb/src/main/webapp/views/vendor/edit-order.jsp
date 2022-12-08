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
	<c:url value="/vendor/order/edit-order" var="edit"></c:url>
	<form role="form" action="${edit}" method="post">
		<input value="${order.id }" hidden="" name="id" />
		<div class="input-group mb-3">
			<span class="input-group-text" id="basic-addon1">Đơn vị vận chuyển</span>  <input type="text" class="form-control"
				value="${order.deliveryId }" name="deliveryId" />
		</div>
		<div class="input-group mb-3">
			<span class="input-group-text" id="basic-addon1">Địa chỉ</span> <input type="text" class="form-control"
				value="${order.address }" name="address" />
		</div>
		<div class="input-group mb-3">
			<span class="input-group-text" id="basic-addon1">Số điện thoại</span>  <input type="text" class="form-control"
				value="${order.phone }" name="phone" />
		</div>
		<div class="input-group mb-3">
			<span class="input-group-text" id="basic-addon1">Trạng thái</span>  <input type="text" class="form-control"
				value="${order.status }" name="status" />
		</div>
		<div class="input-group mb-3">
			<span class="input-group-text" id="basic-addon1">Tổng đơn hàng</span> <input type="text" class="form-control"
				value="${order.total_price }" name="total_price" />
		</div>
	
		<button type="submit" class="btn btn-success">Sửa</button>
		<button type="reset" class="btn btn-danger">Hủy</button>
	</form>
</body>