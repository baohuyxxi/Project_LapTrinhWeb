<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<body>
	<c:url value="/admin/account/change" var="change"></c:url>
	<div class="container">
		<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4"
			style="margin-left: auto !important;">
			<form role="form" action="${change }" method="post">
				<h4 align="center">Đổi mật khẩu</h4>
				<input type="hidden" name="id" value="${account.id }">
				<div class="form-group">
					<label>Tên đăng nhập</label> <input name="username" type="text"
						value="${account.username }" class="form-control" disabled="disabled"> 
					<label>Mật khẩu:</label> <input name="password" type="text" value="${account.password }"
						class="form-control">

				</div>
				<div class="modal-footer">
					 
						<a href="<c:url value="/admin/account"></c:url>"><input type="button" class="btn btn-default" data-dismiss="modal"
						value="Trở lại"></a>
						<input type="submit" class="btn btn-success" value="Sửa" onclick="${message}">
				</div>
			</form>
		</main>
	</div>
</body>
</html>