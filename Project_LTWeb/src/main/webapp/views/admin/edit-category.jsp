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
	<c:url value="/admin/category/edit" var="edit"></c:url>
		<div class="container">
			<form role="form" action="${edit }" method="post">
				<h4 align="center">Sửa Mặt Hàng</h4>
				<input type="hidden" name="id" value="${category.id }">
				<div class="form-group">
					<label>Tên</label> <input name="name" type="text"
						value="${category.name }" class="form-control"> 
					<label>Tên Miền</label> 
						<input name="slug" type="text"
						value="${category.slug }" class="form-control"> 
						
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