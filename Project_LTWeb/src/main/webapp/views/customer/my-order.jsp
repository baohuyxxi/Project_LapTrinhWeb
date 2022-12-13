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
<div>
<table id="example" class="table table-striped table-bordered"
	style="width: 100%">
	<thead>
		<tr>
			<th>Mã đơn hàng</th>
			<th>Tên cửa hàng</th>
			<th>Đơn vị vận chuyên</th>
			<th>Địa chỉ GH</th>
			<th>SDT GH</th>
			<th>Trạng thái</th>
			<th>Tổng giá của DH</th>
			<th>Ngày đặt hàng</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${orders }" var="order">
			<tr>
				<td>${order.id }</td>
				<td>${order.storename }</td>
				<td>${order.deliveryname }</td>
				<td>${order.address }</td>
				<td>${order.phone }</td>
				<td>
					<c:if test="${order.status==0}">
						<label>Chờ xác nhận</label>
					</c:if>
					<c:if test="${order.status==1}">
						<label>Đang vận chuyển</label>
					</c:if>
					<c:if test="${order.status==2}">
						<label>Đã nhận hàng</label>
					</c:if>
				</td>
				<td>${order.total_price }</td>
				<td>${order.dayorder }</td>
				<td>
					<c:if test="${cartitem.product.img!=null}">
						<img class="d-block w-100" style="width: 150px; height: 150px;" src="${product.img }">
					</c:if>
				</td>
				<td>${cartitem.count }</td>

			</tr>
		</c:forEach>		
	</tbody>
</table>
<div>
<a class="btn btn-primary" type="button"
					href="<c:url value='./cartitem'/>">Quay lại giỏ hàng</a>
</div>
</div>

</body>
</html>