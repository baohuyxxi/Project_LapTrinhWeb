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
	<c:url value="/vendor/store/edit" var="edit"></c:url>
	<form role="form" action="${edit}" method="post">
		<input value="${store.id }" hidden="" name="id">
		<div class="input-group mb-3">
			<span class="input-group-text" id="basic-addon1">Tên cửa hàng</span>  <input type="text" class="form-control"
				value="${store.name }" name="name" />
		</div>
		<div class="input-group mb-3">
			<span class="input-group-text" id="basic-addon1">Tên miền</span> <input type="text" class="form-control"
				value="${store.slug }" name="slug" />
		</div>
		<div class="input-group mb-3">
			<span class="input-group-text" id="basic-addon1">Địa chỉ</span> <input type="text" class="form-control"
				value="${store.address }" name="address" />
		</div>
	
		<button type="submit" class="btn btn-default">Sửa</button>
		<button type="reset" class="btn btn-primary">Hủy</button>
	</form>
</body>
</html>