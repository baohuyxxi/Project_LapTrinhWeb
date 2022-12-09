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
		<c:url value="/vendor/product/edit" var="edit"></c:url>
		<form role="form" action="${edit}" method="post">
			<input value="${product.id }" hidden="" name="id">
			<div class="modal-header">
				<h4 class="modal-title">Sửa Sản phẩm</h4>
			</div>
			<div class="modal-body">
				<div class="form-group">
					<label>Tên</label> <input name="name" type="text"
						class="form-control" required value="${product.name }">
				</div>
				<div class="form-group">
					<label>Loại SP</label> <select name="category_id">
						<c:forEach items="${categoryList }" var="category">
							<c:if test="${category.id==product.category_id }">
								<option value="${category.id }" selected>${category.name }</option>
							</c:if>
							<c:if test="${category.id!=product.category_id }">
								<option value="${category.id }">${category.name }</option>
							</c:if>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<label>Tên miền</label> <input name="slug" type="text"
						class="form-control" required value="${product.slug }">
				</div>
				<div class="form-group">
					<label>Mô tả</label>
					<textarea name="description" class="form-control" required>${product.description }</textarea>
				</div>
				<div class="form-group">
					<label>Giá</label> <input name="price" type="text"
						class="form-control" required value="${product.price }">
				</div>
				<div class="form-group">
					<label>Khuyến mãi</label> <input name="promotion" type="text"
						class="form-control" required value="${product.promotion }">
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