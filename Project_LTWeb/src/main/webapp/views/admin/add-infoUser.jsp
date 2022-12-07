<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form role="form" action="add" method="post">
	<div class="input-group mb-3">
		<span class="input-group-text" id="basic-addon1">Tên người dùng</span> 
		<input
			type="text" class="form-control" placeholder="Name"
			aria-label="Username" aria-describedby="basic-addon1" name="name">
	</div>
	<div class="input-group mb-3">
		<span class="input-group-text" id="basic-addon1">Tên miền</span> 
		<input
			type="text" class="form-control" placeholder="Slug"
			aria-label="Username" aria-describedby="basic-addon1" name="slug">
	</div>
	<div class="input-group mb-3">
		<input type="text" class="form-control"
			placeholder="Recipient's username" aria-label="Email"
			aria-describedby="basic-addon2" name="email"> <span
			class="input-group-text" id="basic-addon2">@gmail.com</span>
	</div>
	<div class="input-group mb-3">
		<span class="input-group-text" id="basic-addon1">Số điện thoại</span> 
		<input
			type="text" class="form-control" placeholder="Slug"
			aria-label="Username" aria-describedby="basic-addon1" name="slug">
	</div>
	<div class="input-group mb-3">
		<span class="input-group-text" id="basic-addon1">Địa chỉ</span> 
		<input
			type="text" class="form-control" placeholder="Slug"
			aria-label="Username" aria-describedby="basic-addon1" name="slug">
	</div>
<button type="submit" class="btn btn-default">Thêm</button>
		<button type="reset" class="btn btn-primary">Hủy</button>
	</form>
	


	<!-- <form role="form" action="add" method="post">
		<div class="form-group">
			<label>Tên:</label> <input class="form-control"
				placeholder="please enter category Name" name="name" />
		</div>
		<div class="form-group">
			<label>Tên miền:</label> <input class="form-control"
				placeholder="Please enter category Name" name="slug" />
		</div>
		<div class="form-group">
			<label>Email:</label> <input class="form-control"
				placeholder="please enter category Name" name="email" />
		</div>
		<div class="form-group">
			<label>Số điện thoại:</label> <input class="form-control"
				placeholder="please enter category Name" name="phone" />
		</div>
		<div class="form-group">
			<label>Địa chỉ:</label> <input class="form-control"
				placeholder="please enter category Name" name="address" />
		</div>

		<button type="submit" class="btn btn-default">Thêm</button>
		<button type="reset" class="btn btn-primary">Hủy</button>
	</form>
 -->
</body>
</html>