<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container-fluid">
		<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4" style="margin-left: auto!important;">
			<div class="pl-lg-4">
                  <div class="row">
                
                    <div class="card-body d-flex flex-column align-items-start col-lg-6" style="margin-bottom: 50px; border:0.5px solid black; border-radius: 30px">
						<strong class="d-inline-block mb-2 text-primary" style="font-size: 20px">User</strong>
						<h3 class="mb-0">							
							<a class="text-dark" href="#">Số lượng người dùng</a>
						</h3>
						<h4 class="mb-2 text-uppercase text-info" style="padding-top: 25px">Số lượng: ${slUser }</h4>
						<p class="card-text mb-auto" style="font-size: 20px; margin-top: 15px;">Số lượng người dùng tăng dần, cố gắng sửa lỗi, cải thiện trang web!!!</p>
					</div>
					<div class="card-body d-flex flex-column align-items-start col-lg-6" style="margin-bottom: 50px; border:0.5px solid black; border-radius: 30px">
						<strong class="d-inline-block mb-2 text-success" style="font-size: 20px">Store</strong>
						<h3 class="mb-0">
							<a class="text-dark" href="#">Số lượng cửa hàng đăng ký</a>
						</h3>
						<h4 class="mb-2 text-uppercase text-info" style="padding-top: 25px">Số lượng: ${slStore }</h4>
						<p class="card-text mb-auto" style="font-size: 20px; margin-top: 15px;">Chúng ta đã có nhiều đối tác hơn, số lượng cửa hàng tăng dần. 
						Cố gắng khắc phục một số lỗi không mong muốn</p>
					</div>
					<div class="card-body d-flex flex-column align-items-start col-lg-6" style="margin-bottom: 50px; border:0.5px solid black; border-radius: 30px">
						<strong class="d-inline-block mb-2 text-primary" style="font-size: 20px">Product</strong>
						<h3 class="mb-0">
							<a class="text-dark" href="#">Số lượng sản phẩm đã đăng ký:</a>
						</h3>
						<h4 class="mb-2 text-uppercase text-info" style="padding-top: 25px">Số lượng sản phẩm: ${slProduct }</h4>
						<p class="card-text mb-auto" style="font-size: 20px; margin-top: 15px;">Số lượng sản phẩm được đăng ký rất nhiều, tạo nên sự đa dạng cho trang web</p>
					</div>	
					<div class="card-body d-flex flex-column align-items-start col-lg-6" style="margin-bottom: 50px; border:0.5px solid black; border-radius: 30px">
						<strong class="d-inline-block mb-2 text-info" style="font-size: 20px">Bill</strong>
						<h3 class="mb-0">
							<a class="text-dark" href="#">Số lượng đơn hàng</a>
						</h3>
						<h4 class="mb-2 text-uppercase text-info" style="padding-top: 25px">Số lượng: ${slOrder }</h4>
						<p class="card-text mb-auto" style="font-size: 20px; margin-top: 15px;">Lượng khách hàng đặt sản phẩm cũng tăng đáng kể,
						Cố gắng lên nhé :v!!!
						</p>
					</div>
					<div class="card-body d-flex flex-column align-items-start col-lg-6" style="margin-bottom: 50px; border:0.5px solid black; border-radius: 30px">
						<strong class="d-inline-block mb-2 text-secondary" style="font-size: 20px">Product</strong>
						<h3 class="mb-0">
							<a class="text-dark" href="#">Số lượng sản phẩm đã bán</a>
						</h3>
						<h4 class="mb-2 text-uppercase text-info" style="padding-top: 25px">Số lượng đã bán: ${slSold }</h4>
						<p class="card-text mb-auto" style="font-size: 20px; margin-top: 15px;">Các cửa hàng đang kinh doanh rất tốt, số lượng sản phẩm bán ra rất cao.
						 Chúc mừng các cửa hàng đã làm việc thành công và chăm chỉ</p>
					</div>
					<div class="card-body d-flex flex-column align-items-start col-lg-6" style="margin-bottom: 50px; border:0.5px solid black; border-radius: 30px">
						<strong class="d-inline-block mb-2 text-danger" style="font-size: 20px">Contact</strong>
						<h3 class="mb-0">
							<a class="text-dark" href="#">Số lượng đánh giá khách hàng</a>
						</h3>
						<h4 class="mb-2 text-uppercase text-info" style="padding-top: 25px">Số lượng đánh giá: ${slEvaluated }</h4>
						<p class="card-text mb-auto" style="font-size: 20px; margin-top: 15px;">Khác hàng và các đối tác đã có rất nhiều góp ý, 
						có nhiều tính hiệu tốt tuy nhiên vẫn còn nhiều nhược điểm. Hãy lắng nghe và khắc phục để trang web hoạt động tốt hơn</p>
					</div>
                  </div>
		</main>
	</div>
</div>
