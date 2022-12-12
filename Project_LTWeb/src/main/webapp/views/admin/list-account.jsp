<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container">
		<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4"
		style="margin-left: auto !important;">
		<h2>Danh sách tài khoản</h2>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Tên người dùng</th>
					<th>Tên đăng nhập</th>
					<th>Mật khẩu</th>
					<th>Quyền</th>
					<th>Chức năng</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${accountList}" var="account">
					<tr>
						<td>${account.id }</td>
						<td>${account.name }</td>
						<td>${account.username }</td>
						<td>${account.password }</td>
						<%-- <td><input name="password" type="text" value="${account.password }"
						class="form-control"></td> --%>
						<td>${account.role }</td>
						<td><a class="btn btn-primary" type="button"
							href="<c:url value='account/change?id=${account.id }'/>">Sửa</a> 
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</main>
	</div>

</body>
</html>

<script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable();
	});>
</script>