<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
	<form role="form" action="add" method="post">
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

</body>
</body>
</html>