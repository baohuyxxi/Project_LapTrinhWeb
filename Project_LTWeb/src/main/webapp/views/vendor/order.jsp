<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table id="example" class="table table-striped table-bordered"
	style="width: 100%">
	<thead>
		<tr>
			<th>Name</th>
			<th>Hình</th>
			<th>Tên danh mục</th>
			<th>Trạng thái</th>
			<th>Chức năng</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${cateList}" var="cate" varStatus="STT">	
			<tr>
				<td>${STT.index+1 }</td>
				<c:url value="/upload?fname=${cate.image }" var="imgUrl"></c:url>
				<td><img height="150" width="200" src="${imgUrl}" /></td>
				<td>${cate.catename }</td>
				<td></td>
				<td><a
					href="<c:url value='/admin/category/edit?id=${cate.cateid }'/>"
					class="center">Sửa</a> | <a
					href="<c:url value='/admin/category/delete?id=${cate.cateid }'/>"
					class="center">Xóa</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<script type="text/javascript">$(document).ready(function() {
    $('#example').DataTable();
	});></script>