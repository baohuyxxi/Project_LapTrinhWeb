<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<table id="example" class="table table-striped table-bordered"
	style="width: 100%">
	<thead>
		<tr>
			<th>ID</th>
			<th>User ID</th>
			<th>Tên cửa hàng</th>
			<th>Tên miền</th>
			<th>Địa chỉ</th>
			<th>Ngày tạo</th>
			<th>Ngày cập nhật</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${storeList}" var="store">	
			<tr>
				<td>${store.id }</td>
				<td>${store.userId }</td>
				<td>${store.name }</td>
				<td>${store.slug }</td>
				<td>${store.address }</td>
				<td>${store.createdAt }</td>
				<td>${store.updatedAt }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<script type="text/javascript">$(document).ready(function() {
    $('#example').DataTable();
	});></script>