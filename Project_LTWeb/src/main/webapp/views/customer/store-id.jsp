<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<body>
	<div class="container">

		<c:url value="zay/store" var="store"></c:url>
		
		<div id="app" class="flex-wrapper">
			<main>
				<div class="body-main">
					<div class="card shadow">
						<div class="card-body">
							<div style="max-width: 1140px; margin: 0 auto;">
								<div class="cover-style">
									<div class="container">
										<div class="c-page-title c-pull-left">
								
										</div>
									</div>
								</div>
							</div>
							<div class="container c-size-md">
								<c:forEach items="${stor}" var="stor">
									<div class="col-md-12">
										<div class="text-div" style="margin-top:0px;">
											<div class="c-mb-3">
												<div class="container-avt">

													<img
														style="background-color: #FFEE82; border: 20px solid #fff;"
														class="img-responsive c-rounded-full" width="256"
														height="256" src="${stor.avatar }" alt="">
													<button class="btn btn-success btn-circle btn-sm"
														data-bs-toggle="modal" data-bs-target="#avtModal">
														<i class="fas fa-camera"></i>
													</button>
												</div>
												<h2 class="c-text-xl">
													<font face="Helvetica" size="6" color="#00cc00">${stor.name }</font>
												</h2>
												<h2 class="c-mt-2 c-text-2xl c-font-bold">
													<font face="Helvetica" size="4" color="Black">Địa
														chỉ: ${stor.address}</font>
												</h2>

												<h2 class="c-font-red c-text-xl">
													<font face="Helvetica" size="4" color="Black"> Tổng
														sản phẩm đã bán: ${stor.sold }<i
														class="bi bi-suit-diamond-fill diamond-blue"></i>
													</font>
												</h2>
												<h2 class="c-font-red c-text-xl">
													<font face="Helvetica" size="4" color="Black"> Cập nhật: ${stor.updatedAt }<i
														class="bi bi-suit-diamond-fill diamond-blue"></i>
													</font>
												</h2>
												<h2 class="c-font-red c-text-xl">
													<font face="Helvetica" size="4" color="Black"> Đã Tham Gia Từ: ${stor.createdAt }<i
														class="bi bi-suit-diamond-fill diamond-blue"></i>
													</font>
												</h2>
											</div>
										</div>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</main>
		</div>



		<div class="heading col-sm-12 text-center"
			style="margin-bottom: 20px; margin-top: 40px;">
			<h2>Danh Mục Sản Phẩm</h2>
			<div
				style="width: 100px; height: 1px; margin: 20px auto; border-bottom: 4px solid #e90606;"></div>
		</div>
		<div class="container">
			<div class="row">
				<c:forEach items="${pro}" var="pro">
					<div class="col-sm-6 col-lg-4 col-xl-3 mb-0 p-1 BoxProduct shadow">
						<div class="card h-50 text-center">
							<a href="${pro.img }"> <img class="card-img-top"
								src="${pro.img }" alt="Card Image" width="608" height="380">
							</a>
							<div class="col-sm-12 text-center"
								style="margin-bottom: 20px; margin-top: 20px;">
								<div>
									<h5>
										<font color="Blue" class="text-center mt-3 mb-3">${pro.categoryName }</font>
									</h5>
									<h4>
										<font color="red" class="c-text-lg c-font-bold">${pro.name }</font>
									</h4>
									<font color="#00cc00" class="c-text-lg c-font-bold">${pro.price }đ<i
										class="bi bi-suit-diamond-fill diamond-blue"></i>
									</font>
									<p class="card-text">
										<i class="far fa-check-circle"></i> Đã bán ${pro.sold }
									</p>
									<p class="card-text">
										<i class="far fa-check-circle"></i> Số lượng ${pro.quantity }
									</p>
									<p class="card-text c-text-blue-500 c-font-bold">Người bán:
										${pro.storeName }</p>
									<p class="card-text c-text-red-400-500 c-font-bold">Cập
										nhật: ${pro.updatedAt }</p>
								</div>
								<a href="product?id=${pro.id }"
									class="btn button-blue d-block shadow"
									style="background-color: blue; color: white">Xem Ngay</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>

</body>
