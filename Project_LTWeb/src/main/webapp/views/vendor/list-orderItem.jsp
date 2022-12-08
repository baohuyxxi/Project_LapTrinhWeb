<%@page import="Models.OrderItemModel"%>
<%@page import="java.math.BigDecimal"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table id="example" class="table table-striped table-bordered"
	style="width: 100%">
	<thead class="thead-dark">
		<tr>
			<th>ID</th>
			<th>Tên sản phẩm</th>
			<th>Số lượng</th>
			<th>Thành Tiền</th>
			<th>Ngày mua</th>
			<th>Ngày cập nhật</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${orderItemLst}" var="orderItem">	
			<tr>
				<td>${orderItem.id }</td>
				<td>${orderItem.productName }</td>
				<td>${orderItem.count }</td>
				<td>${orderItem.price }</td>
				<td>${orderItem.createdAt }</td>
				<td>${orderItem.updatedAt }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<script type="text/javascript">$(document).ready(function() {
    $('#example').DataTable();
	});></script>

