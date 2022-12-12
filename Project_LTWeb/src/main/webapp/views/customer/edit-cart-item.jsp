<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body>
	<c:url value="/user/cartitem/edit" var="edit"></c:url>
	<form role="form" action="edit" method="post" style="margin: 15px 500px;">
		
	<div class="input-group mb-3">
		<input hidden="hidden"
			type="text" class="form-control" 
			aria-label="Username" aria-describedby="basic-addon1" name="id" value="${cartitem.id }">
	</div>
	<div class="input-group mb-3">
		<span class="input-group-text" id="basic-addon1">Tên SP</span> 
		<input disabled="disabled"
			type="text" class="form-control" 
			aria-label="Username" aria-describedby="basic-addon1" value="${cartitem.product.name }">
	</div>
	<div class="input-group mb-3">
	<span class="input-group-text" id="basic-addon1">Giá</span> 
		<input disabled="disabled"
			type="text" class="form-control" 
			aria-label="Username" aria-describedby="basic-addon1" value="${cartitem.product.price }">
	</div>
	<div class="input-group mb-3">
		<span class="input-group-text" id="basic-addon1">Khuyến mãi</span> 
		<input disabled="disabled"
			type="text" class="form-control" 
			aria-label="Username" aria-describedby="basic-addon1" value="${cartitem.product.promotion }">
	</div>
	<div class="input-group mb-3">
		<span class="input-group-text" id="basic-addon1">Trong kho</span> 
		<input disabled="disabled"
			type="text" class="form-control"
			aria-label="Username" aria-describedby="basic-addon1" value="${cartitem.product.quantity }">
	</div>
	<div class="input-group mb-3">
		<span class="input-group-text" id="basic-addon1">Chọn size</span> 
			<select name="size" style="border-radius: 5px;padding: 5px;">
				<c:forEach items="${cartitem.product.sizemd }" var="sizes">
					<c:if test="${sizes.size == cartitem.size }">
						<option value=${sizes.size } selected>${sizes.size } (${sizes.quantity }) </option>
					</c:if>
					<c:if test="${sizes.size != cartitem.size }">
						<option value=${sizes.size }>${sizes.size } (${sizes.quantity }) </option>
					</c:if>
				</c:forEach>
			</select>
	</div>
	<div class="input-group mb-3">
		<span class="input-group-text" id="basic-addon1">Chọn số lượng</span> 
		<input aria-label="quantity" class="input-qty" min="1" name="count" type="number" value="${cartitem.count }">
	</div>
	
		<div style="position: relative;left: 330px;">
			<button type="submit" class="btn btn-default">Sửa</button>
			<button type="reset" class="btn btn-primary">Hủy</button>
		</div>
	</form>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable();
	});>
</script>

<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
