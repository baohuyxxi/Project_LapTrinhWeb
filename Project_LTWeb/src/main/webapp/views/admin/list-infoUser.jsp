<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<table id="example" class="table table-striped table-bordered"
	style="width: 100%">
	<thead>
		<tr>
			<th>ID</th>
			<th>Tên</th>
			<th>Tên miền</th>
			<th>Email</th>
			<th>Số điện thoại</th>
			<th>Địa chỉ</th>
			<th>Avatar</th>
			<th>Ngày tạo</th>
			<th>Ngày cập nhật</th>
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
				<c:url value="/upload/user/${user.avatar}" var="imgAvt"></c:url>
				<td>
					<img height="150" width="200" src="${imgAvt }" />
				</td>
				<td>${user.createdAt }</td>
				<td>${user.updatedAt }</td>
				<td><a
					href="<c:url value='/infoUser/edit?id=${user.id }'/>"
					class="center">Sửa</a> | <a
					href="<c:url value='/admin/infoUser/delete?id=${user.id }'/>"
					class="center">Xóa</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<script type="text/javascript">$(document).ready(function() {
    $('#example').DataTable();
	});></script>