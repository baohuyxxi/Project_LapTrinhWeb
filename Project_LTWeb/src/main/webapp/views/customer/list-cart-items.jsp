<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<table id="example" class="table table-striped table-bordered"
	style="width: 100%">
	<thead>
		<tr>
			<th>Tên SP</th>
			<th>Giá</th>
			<th>Khuyến mãi</th>
			<th>Còn</th>
			<th>Đã bán</th>
			<th>Size</th>
			<th>Ảnh</th>
			<th>SL mua</th>
			<th>Chức năng</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${cartitems }" var="cartitem">
			<tr>
				<td>${cartitem.product.name }</td>
				<td>${cartitem.product.price }</td>
				<td>${cartitem.product.promotion }</td>
				<td>${cartitem.product.quantity }</td>
				<td>${cartitem.product.sold }</td>
				<td>${cartitem.size }</td>
				<td>
					<c:if test="${cartitem.product.img!=null}">
						<img class="d-block w-100" style="width: 150px; height: 150px;" src="${product.img }">
					</c:if>
				</td>
				<td>${cartitem.count }</td>
				<td><a class="btn btn-primary" type="button"
					href="<c:url value='cartitem/edit?id=${cartitem.id }'/>">Cập nhật</a> <a
					class="btn btn-danger" type="button"
					href="<c:url value='cartitem/delete?id=${cartitem.id }'/>">Xóa</a>
			</tr>
		</c:forEach>
	</tbody>
</table>
<script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable();
	});>
</script>

<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
