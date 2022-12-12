<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body>
	<c:url value="/admin/infoUser/edit" var="edit"></c:url>
	<div class="container">
		<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4"
			style="margin-left: auto !important;">
			<form role="form" action="${edit }" method="post">
				<input name="user" value="${user.id }" hidden="" name="eid">
				<td>${user.name}</td> <input value="${user.id }" hidden=""
					name="id">

				<div class="form-group">
					<label>Tên:</label> <input type="text" class="form-control"
						value="${user.name }" name="name" />
				</div>
				<div class="form-group">
					<label>Tên miền:</label> <input type="text" class="form-control"
						value="${user.slug }" name="slug" />
				</div>
				<div class="form-group">
					<label>Email:</label> <input type="text" class="form-control"
						value="${user.email }" name="email" />
				</div>
				<div class="form-group">
					<label>Số điện thoại:</label> <input type="text"
						class="form-control" value="${user.phone }" name="phone" />
				</div>
				<div class="form-group">
					<label>Địa chỉ:</label> <input type="text" class="form-control"
						value="${user.address }" name="address" />
				</div>
				<div class="form-group">
					<label>Avatar:</label> <input type="text" class="form-control"
						value="${user.avatar }" name="avatar" />
				</div>
				<div class="form-group">
					<label>Ngày tạo:</label> <label>${user.createdAt}</label>
				</div>
				<div class="form-group">
					<label>Trạng thái tài khoản</label> <input type="text" class="form-control"
						value="${user.status }" name="status" />
				</div>
				<button type="submit" class="btn btn-default">Edit</button>
				<button type="reset" class="btn btn-primary">Reset</button>
			</form>
		</main>
	</div>

</body>
