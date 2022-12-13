<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<body>
	<div class="c-layout-page">
		<div class="c-overflow-hide c-bg-white">
			<div class="container">
				<div class="col-sm-12 text-center"
					style="margin-bottom: 20px; margin-top: 20px;">
					<a href="${link}home" class="c-logo"> <img
						src="https://bom.so/NAJjSb" alt=""
						style="height: 300px; margin-top: -8px;" class="c-desktop-logo">
					</a>
					<div
						style="width: 140px; height: 1px; margin: 20px auto; border-bottom: 4px solid #00bff3;"></div>
				</div>
				<div class="container m-t-20 content_post">
					<div class="col-sm-12 text-center" style="margin-bottom: 50px;">
						<font face="Times New Roman" size="30">Hình ảnh chi tiết
							của sản phẩm</font><br />

					</div>
					<!-- Hình Ảnh Sản phẩm -->
					<div id="template-mo-zay-hero-carousel" class="carousel slide"
						data-bs-ride="carousel">
						<div class="carousel-inner">
							<div class="carousel-item active">
								<div class="center">
									<div class="mx-auto col-md-8 col-lg-6 order-lg-last">
										<img class="img-fluid" src="${pro.img }" alt="Card Image"
											width="608" height="380">
									</div>
									<div class="col-lg-6 mb-0 d-flex align-items-center">
										<div class="text-align-left"></div>
									</div>
								</div>
							</div>
							<c:forEach items="${imag}" var="imag">
								<div class="carousel-item">
									<div class="center">
										<div class="mx-auto col-md-8 col-lg-6 order-lg-last">
											<img class="img-fluid" src="${imag.img }" alt="Card Image"
												width="608" height="380">
										</div>
										<div class="col-lg-6 mb-0 d-flex align-items-center">
											<div class="text-align-left "></div>
										</div>
									</div>
								</div>
							</c:forEach>


						</div>
						<a class="carousel-control-prev text-decoration-none w-auto ps-3"
							href="#template-mo-zay-hero-carousel" role="button"
							data-bs-slide="prev"> <i class="fas fa-chevron-left"></i>
						</a> <a class="carousel-control-next text-decoration-none w-auto pe-3"
							href="#template-mo-zay-hero-carousel" role="button"
							data-bs-slide="next"> <i class="fas fa-chevron-right"></i>
						</a>
					</div>

				</div>
			</div>
			<!-- Hình Ảnh Sản phẩm -->
		</div>
	</div>

	<div class="col-sm-12 text-center"
		style="margin-bottom: 20px; margin-top: 20px;">
		<a class="custom-btnDemo btn-12" href="#addProToCart" data-toggle="modal">
			<span>Thêm Luôn Bạn êi !!!</span><span>Thêm Vào Giỏ Hàng</span>
		</a>
		<div
			style="width: 140px; height: 1px; margin: 20px auto; border-bottom: 4px solid #00bff3;"></div>
	</div>

	<div class="container">
		<div class="col-sm specifications-box">
			<div class="table-responsive">
				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col" colspan="2" class="text-center"><span
								class="nav-link text-dark">THÔNG TIN SẢN PHẨM</span></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th>Tên Shop</th>
							<td><a href="store?id=${pro.storeId }">${pro.storeName }</a></td>
						</tr>
						<tr>
							<th>Tên Sản Phẩm</th>
							<td>${pro.name }</td>
						</tr>
						<tr>
							<th>Loại Sản Phẩm</th>
							<td>${pro.categoryName }</td>
						</tr>
						<tr>
							<th>Giá Sản Phẩm</th>
							<td>${pro.price }</td>
						</tr>
						<tr>
							<th>Mô Tả</th>
							<td>${pro.description }</td>
						</tr>
						<tr>
							<th>Khuyến mãi</th>
							<td>${pro.promotion }%</td>
						</tr>
						<tr>
							<th>Số Lượng</th>
							<td>${pro.quantity }</td>
						</tr>
						<tr>
							<th>Đã bán</th>
							<td>${pro.sold }</td>
						</tr>
						<tr>
							<th>Cập nhật</th>
							<td>${pro.updatedAt }</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<div id="addProToCart" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="Huydz" method="post">
					<div class="modal-header">
						<h4 class="modal-title">Chọn Sản Phẩm</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>

					<div class="modal-body">
						<div class="row">
							<c:forEach items="${imag}" var="imag">
								<div
									class="col-sm-6 col-lg-4 col-xl-3 mb-0 p-1 BoxProduct shadow">
									<div class="card h-50 text-center">
										<a></a><img class="card-img-top" src="${imag.img }"
											alt="Card Image" width="100" height="100"> </a>
									</div>
								</div>
							</c:forEach>
							<div class="select">
							  <select>
							   <option selected disabled>Chọn Size</option>
							<c:forEach items="${sizes}" var="sizes">
								<option value="${sizes.size}">${sizes.size}</option>
								 <option value="${sizes.size}">${sizes.size}</option>		
							</c:forEach>
							</select>
							</div>
							<div class="modal-footer">
								<a class="custom-btn btn-1" href="/Project_LTWeb/login" >
									<span>Thêm Luôn Bạn êi !!!</span>
								</a>
							</div>
						</div>
					</div>

				</form>
			</div>

		</div>
	</div>

<style>
.custom-btnDemo {
	width: 500px;
	height: 50px;
	color: #fff;
	border-radius: 5px;
	padding: 10px 25px;
	font-family: 'Lato', sans-serif;
	font-weight: 500;
	background: transparent;
	cursor: pointer;
	transition: all 0.3s ease;
	position: relative;
	display: inline-block;
	box-shadow: inset 2px 2px 2px 0px rgba(255, 255, 255, .5), 7px 7px 20px
		0px rgba(0, 0, 0, .1), 4px 4px 5px 0px rgba(0, 0, 0, .1);
	outline: none;
}

.btn-12 {
	position: relative;
	right: 20px;
	bottom: 20px;
	border: none;
	box-shadow: none;
	width: 500px;
	height: 50px;
	line-height: 42px;
	-webkit-perspective: 230px;
	perspective: 230px;
}

.btn-12 span {
	background: rgb(0, 172, 238);
	background: linear-gradient(0deg, rgba(0, 172, 238, 1) 0%,
		rgba(2, 126, 251, 1) 100%);
	display: block;
	position: absolute;
	width: 500px;
	height: 50px;
	box-shadow: inset 2px 2px 2px 0px rgba(255, 255, 255, .5), 7px 7px 20px
		0px rgba(0, 0, 0, .1), 4px 4px 5px 0px rgba(0, 0, 0, .1);
	border-radius: 5px;
	margin: 0;
	text-align: center;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	-webkit-transition: all .3s;
	transition: all .3s;
}

.btn-12 span:nth-child(1) {
	box-shadow: -7px -7px 20px 0px #fff9, -4px -4px 5px 0px #fff9, 7px 7px
		20px 0px #0002, 4px 4px 5px 0px #0001;
	-webkit-transform: rotateX(90deg);
	-moz-transform: rotateX(90deg);
	transform: rotateX(90deg);
	-webkit-transform-origin: 50% 50% -20px;
	-moz-transform-origin: 50% 50% -20px;
	transform-origin: 50% 50% -20px;
}

.btn-12 span:nth-child(2) {
	-webkit-transform: rotateX(0deg);
	-moz-transform: rotateX(0deg);
	transform: rotateX(0deg);
	-webkit-transform-origin: 50% 50% -20px;
	-moz-transform-origin: 50% 50% -20px;
	transform-origin: 50% 50% -20px;
}

.btn-12:hover span:nth-child(1) {
	box-shadow: inset 2px 2px 2px 0px rgba(255, 255, 255, .5), 7px 7px 20px
		0px rgba(0, 0, 0, .1), 4px 4px 5px 0px rgba(0, 0, 0, .1);
	-webkit-transform: rotateX(0deg);
	-moz-transform: rotateX(0deg);
	transform: rotateX(0deg);
}

.btn-12:hover span:nth-child(2) {
	box-shadow: inset 2px 2px 2px 0px rgba(255, 255, 255, .5), 7px 7px 20px
		0px rgba(0, 0, 0, .1), 4px 4px 5px 0px rgba(0, 0, 0, .1);
	color: transparent;
	-webkit-transform: rotateX(-90deg);
	-moz-transform: rotateX(-90deg);
	transform: rotateX(-90deg);
}


.custom-btn {

  width: 300px;

  height: 40px;

  color: #fff;

  border-radius: 5px;

  padding: 10px 25px;

  font-family: 'Lato', sans-serif;

  font-weight: 500;

  background: transparent;

  cursor: pointer;

  transition: all 0.3s ease;

  position: relative;

  display: inline-block;

   box-shadow:inset 2px 2px 2px 0px rgba(255,255,255,.5),

   7px 7px 20px 0px rgba(0,0,0,.1),

   4px 4px 5px 0px rgba(0,0,0,.1);

  outline: none;

}
.btn-1 {

  background: rgb(6,14,131);

  background: linear-gradient(0deg, rgba(6,14,131,1) 0%, rgba(12,25,180,1) 100%);

  border: none;

}

.btn-1:hover {

   background: rgb(0,3,255);

background: linear-gradient(0deg, rgba(0,3,255,1) 0%, rgba(2,126,251,1) 100%);

}


</style>
</body>

</html>
