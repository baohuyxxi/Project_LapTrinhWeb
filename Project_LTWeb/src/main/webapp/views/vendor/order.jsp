<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table id="example" class="table table-striped table-bordered"
	style="width: 100%">
	<thead class="thead-dark">
		<tr>
			<th>ID</th>
			<th>Tên khách hàng</th>
			<th>Đơn vị giao hàng</th>
			<th>Địa chỉ</th>
			<th>Số điện thoại</th>
			<th>Trạng thái</th>
			<th>Tổng hóa đơn</th>
			<th>Ngày xuất</th>
			<th>Ngày cập nhật</th>
			<th>Chức năng </th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${orderList}" var="order">	
			<tr>
				<td>${order.id }</td>
				<td>${order.userName }</td>
				<td>${order.deliveryName }</td>
				<td>${order.address }</td>
				<td>${order.phone }</td>
				<%-- <td>${order.status }</td> --%>
				<td>
					<c:if test="${order.status == 1 }">
						Đã hoàn thành
					</c:if>
					<c:if test="${order.status == 0 }">
						Đang vận chuyển
					</c:if>
				</td>
				<td>${order.total_price }</td>
				<td>${order.createdAt }</td>
				<td>${order.updatedAt }</td>
				<td><a
					href="<c:url value='/vendor/order/edit-order?id=${order.id }'/>"
					class="center">Sửa</a> | <a
					href="<c:url value='/vendor/order/detail-order?orderId=${order.id }'/>"
					class="center">Chi tiết hóa đơn</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<script type="text/javascript">$(document).ready(function() {
    $('#example').DataTable();
	});></script>