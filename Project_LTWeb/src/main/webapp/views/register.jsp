<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form role="form" action="add" method="post" enctype="multipart/form-data" style="margin: 15px 500px;">
		
	<div class="input-group mb-3">
		<span class="input-group-text" id="basic-addon1">Tên người dùng</span> 
		<input
			type="text" class="form-control" placeholder="Name"
			aria-label="Username" aria-describedby="basic-addon1" name="name">
	</div>
	<div class="input-group mb-3">
		<span class="input-group-text" id="basic-addon1">Link ảnh đại diện</span> 
		<input
			type="text" class="form-control" placeholder="Avatar"
			aria-label="Username" aria-describedby="basic-addon1" name="avatar">
	</div>
	<div class="input-group mb-3">
		<span class="input-group-text" id="basic-addon1">Tên miền</span> 
		<input
			type="text" class="form-control" placeholder="Slug"
			aria-label="Username" aria-describedby="basic-addon1" name="slug">
	</div>
	<div class="input-group mb-3">
	<span class="input-group-text" id="basic-addon1">Email</span> 
		<input type="text" class="form-control"
			placeholder="Email" 
			aria-describedby="basic-addon2" name="email"> <span
			class="input-group-text" id="basic-addon2">@gmail.com</span>
	</div>
	<div class="input-group mb-3">
		<span class="input-group-text" id="basic-addon1">Số điện thoại</span> 
		<input
			type="text" class="form-control" placeholder="Phone"
			aria-label="Username" aria-describedby="basic-addon1" name="phone">
	</div>
	<div class="input-group mb-3">
		<span class="input-group-text" id="basic-addon1">Địa chỉ</span> 
		<input
			type="text" class="form-control" placeholder="Address"
			aria-label="Username" aria-describedby="basic-addon1" name="address">
	</div>
	<div class="input-group mb-3">
		<span class="input-group-text" id="basic-addon1">Mật khẩu</span> 
		<input
			type="password" class="form-control" placeholder="Password"
			aria-label="Username" aria-describedby="basic-addon1" name="password">
	</div>
	
	<div>
	<select name="role" style="border-radius: 5px;padding: 5px;">
		<option value="1">Khách hàng</option>
		<option value="2">Người bán hàng</option>
	</select>
	</div>
		<div style="position: relative;left: 330px;">
			<button type="submit" class="btn btn-default">Tạo tài khoản</button>
			<button type="reset" class="btn btn-primary">Hủy</button>
		</div>
	</form>
</body>
</html>