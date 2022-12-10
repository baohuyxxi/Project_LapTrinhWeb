<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
	<div class="py-3">
		<div class="col-md-15" style="padding-top: 12px">
			<div class="p-3 p-md-5 text-white rounded bg-dark">
				<div class="col-md-7">
					<h1 class="display-4">Cảm ơn bạn đã hợp tác với chúng tôi</h1>
					<p class="lead my-3">Bạn đã làm việc rất tốt trong thời gian qua
					. Hãy tiếp tục cố gắng nha!</p>
					<p class="lead mb-0">
						Hãy cùng điểm qua các thành tựu mà bạn đạt được trong tháng!
					</p>
				</div>
			</div>
		</div>

		<div class="row mb-2">
			<div class="col-md-6" style="padding-top: 12px">
				<div class="card flex-md-row mb-4 box-shadow h-md-250">
					<div class="card-body d-flex flex-column align-items-start">
						<strong class="d-inline-block mb-2 text-primary">Best seller</strong>
						<h3 class="mb-0">
							<a class="text-dark" href="#">Thông tin sản phẩm</a>
						</h3>
						<div class="mb-1 text-muted">Nov 12</div>
						<div class="mb-2 text-uppercase">${product.name }</div>
						<p class="card-text mb-auto">${product.description}</p>
						<p class="card-text mb-auto">Số lượng đã bán: ${product.sold}</p>
					</div>
					<img class="card-img-right flex-auto d-none d-md-block"
						src="<c:url value="/assets/img/banner_img_01.jpg"/>"
						alt="Card image cap" style="width: 45%">
				</div>
			</div>
			<div class="col-md-6" style="padding-top: 12px">
				<div class="card flex-md-row mb-4 box-shadow h-md-250">
					<div class="card-body d-flex flex-column align-items-start">
						<strong class="d-inline-block mb-2 text-success">Tổng doanh thu</strong>
						<h3 class="mb-0">
							<a class="text-dark" href="#">Post title</a>
						</h3>
						<div class="mb-1 text-muted">Nov 11</div>
						<p class="card-text mb-auto">This is a wider card with
							supporting text below as a natural lead-in to additional content.</p>
					</div>
					<img class="card-img-right flex-auto d-none d-md-block"
						src="<c:url value="/assets/img/banner_img_01.jpg"/>"
						alt="Card image cap" style="width: 45%">
				</div>
			</div>
		</div>
	</div>
</div>









