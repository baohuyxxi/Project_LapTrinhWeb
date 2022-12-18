<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<body>
	<div class="">
		<main role="main" class="px-2"
			style="margin-left: 340px">
			<table id="example" class="table table-striped table-bordered"
				style="width: 100%">

				<thead>
					<tr>
						<th>ID</th>
						<th style="width: 150px">Họ và tên</th>
						<th>Tên miền</th>
						<th>Email</th>
						<th style="width: 125px">Số điện thoại</th>
						<th style="width: 150px">Địa chỉ</th>
						<th style="width: 150px">Avatar</th>
						<th>Ngày tạo</th>
						<th>Ngày cập nhật</th>
						<th>Trạng thái tài khoản</th>
						<th>Chức năng</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${userList}" var="user">
						<tr>
							<td>${user.id }</td>
							<td>${user.name }</td>
							<td>${user.slug }</td>
							<td>${user.email }</td>
							<td>${user.phone }</td>
							<td>${user.address }</td>
							<td><img height="150" width="200" src="${user.avatar }" /></td>
							<td>${user.createdAt }</td>
							<td>${user.updatedAt }</td>
							<td>
								<c:if test="${user.status == true }">
									Đang hoạt động
								</c:if>
								<c:if test="${user.status == false }">
									Ngừng hoạt động
								</c:if>
							</td>
							<td>
								<c:if test="${user.status == false }"><a href="<c:url value='./infouser/change?id=${user.id }&status=true'/>"
								class="center" style="text-decoration: none">Cập nhật trạng thái</a></c:if>
								<c:if test="${user.status == true }"><a href="<c:url value='./infouser/change?id=${user.id }&status=false'/>"
								class="center" style="text-decoration: none">Cập nhật trạng thái</a></c:if>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</main>
	</div>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable();
	});>
</script>