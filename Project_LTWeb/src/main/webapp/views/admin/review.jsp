<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<div class="container-fluid">
	<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4"
		style="margin-left: auto !important;">
		<h2>Danh sách các đánh giá được gửi về từ Khách hàng</h2>
		<table id="example" class="table table-striped table-bordered"
			style="width: 100%">
			<thead class="thead-dark">
				<tr>
					<th>ID</th>
					<th>Tên khách hàng</th>
					<th>Email</th>
					<th>Chủ đề</th>
					<th>Nội dung</th>			
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${evaluateList}" var="evaluate">
					<tr>
						<td>${evaluate.id }</td>
						<td>${evaluate.name }</td>
						<td>${evaluate.email }</td>
						<td>${evaluate.subject }</td>
						<td>${evaluate.content }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
</div>