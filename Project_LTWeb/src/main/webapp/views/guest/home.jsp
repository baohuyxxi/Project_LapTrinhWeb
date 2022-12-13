<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body>
	<!-- Start Banner Hero -->
    <div id="template-mo-zay-hero-carousel" class="carousel slide" data-bs-ride="carousel">
        <ol class="carousel-indicators">
            <li data-bs-target="#template-mo-zay-hero-carousel" data-bs-slide-to="0" class="active"></li>
            <li data-bs-target="#template-mo-zay-hero-carousel" data-bs-slide-to="1"></li>
            <li data-bs-target="#template-mo-zay-hero-carousel" data-bs-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <div class="container">
                    <div class="row p-5">
                        <div class="mx-auto col-md-8 col-lg-6 order-lg-last">
                            <img class="img-fluid" src="<c:url value="/assets/img/banner_img_01.jpg"/>" alt=""/>
                        </div>
                        <div class="col-lg-6 mb-0 d-flex align-items-center">
                            <div class="text-align-left align-self-center">
                                <h1 class="h1 text-success"><b>Zay</b> eCommerce</h1>
                                <h3 class="h2">Chào mừng bạn đến với trang người bán</h3>
                                <p>
                                    Zay Vendor là một trang web dành cho người bán để họ có thể theo dõi công việc của mình 
                                    Rất vui được hợp tác với bạn <a rel="sponsored" class="text-success" href="https://templatemo.com" target="_blank"></a> . 
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <div class="container">
                    <div class="row p-5">
                        <div class="mx-auto col-md-8 col-lg-6 order-lg-last">
                            <img class="img-fluid" src="<c:url value="/assets/img/banner_img_02.jpg"/>" alt=""/>
                        </div>
                        <div class="col-lg-6 mb-0 d-flex align-items-center">
                            <div class="text-align-left">
                                <h1 class="h1">Giao diện đơn giản</h1>
                                <h3 class="h2">Dễ sử dụng, thao tác trên mọi thiết bị</h3>
                                <p>
                                    Bạn sử dụng trang web để đăng thông tin sản phẩm 
                                    Bạn có thể liên lạc <strong>Admin</strong> để biết thêm thông tin chi tiết.
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <div class="container">
                    <div class="row p-5">
                        <div class="mx-auto col-md-8 col-lg-6 order-lg-last">
                            <img class="img-fluid" src="<c:url value="/assets/img/banner_img_03.jpg"/>" alt=""/>
                        </div>
                        <div class="col-lg-6 mb-0 d-flex align-items-center">
                            <div class="text-align-left">
                                <h1 class="h1">Theo dõi đơn hàng</h1>
                                <h3 class="h2">Quản lý cửa hàng </h3>
                                <p>
                                    Bạn có thể theo dõi cửa hàng, đơn hàng, sản phẩm của mình.
                                    Bạn có thể làm việc ở bất cứ đâu, bán hàng thoải mái.
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <a class="carousel-control-prev text-decoration-none w-auto ps-3" href="#template-mo-zay-hero-carousel" role="button" data-bs-slide="prev">
            <i class="fas fa-chevron-left"></i>
        </a>
        <a class="carousel-control-next text-decoration-none w-auto pe-3" href="#template-mo-zay-hero-carousel" role="button" data-bs-slide="next">
            <i class="fas fa-chevron-right"></i>
        </a>
    </div>
    <!-- End Banner Hero -->


	<!-- Start Categories of The Month -->
	<section class="container py-5">
		<div class="row text-center pt-3">
			<div class="col-lg-6 m-auto">
				<h1 class="h1">Categories of The Month</h1>
				<p>Excepteur sint occaecat cupidatat non proident, sunt in culpa
					qui officia deserunt mollit anim id est laborum.</p>
			</div>
		</div>
		<div class="row">
			<c:forEach items="${pro}" var="pro">
				<div class="col-12 col-md-4 p-5 mt-3">
					<a href="product?id=${pro.id }"><img src="${pro.img }"
						class="rounded-circle img-fluid border"></a>
					<h5 class="text-center mt-3 mb-3">${pro.name }</h5>
					<h5 class="text-center mt-3 mb-3">Đã bán ${pro.sold }</h5>
					<p class="text-center">
						<a class="btn btn-success" href="store?id=${pro.storeId }">Go
							Shop</a>
					</p>
				</div>
			</c:forEach>
		</div>
	</section>

		<%-- <div class="modal fade <!-- show -->" id="global-modal"  
			aria-labelledby="global-modalLabel" tabindex="-1" aria-modal="true"
			role="dialog" style="display: block; padding-left: 0px;">
			<div class="modal-dialog modal-dialog-centered">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title text-danger c-text-2xl c-font-bold"
							style="font-size: 40px" id="global-modalLabel">Giới Thiệu</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<p>
							<em style="font-family: arial, sans-serif; text-align: center;"><font
								face="Helvetica" size="5" color="#ff0000">Đây là Project
									cuối kì môn lập trình Web của nhóm chúng mình nên có bug gì thì
									mọi người bỏ qua nhé</font></em><br>
						</p>
						<p>
							<font face="Times New Roman" size="10" color="#00e600"><b>Shop
									ZAY </b></font>:
						</p>
						<p>
							<b><font face="Helvetica" size="5" color="#0080ff">Phần
									chém gió</font></b>  </font><img
								height="70" width="70" alt="Mạng yếu quá :v"
								src="https://media3.giphy.com/media/wWuRt5BRWrpssHOjqd/giphy.gif"></b>
						</p>
						<p>
							<font face="Helvetica" size="4" color="#000000">- ZAYshop
								là nền tảng thương mại điện tử hàng đầu tại Nhà tôi. Ra mắt năm
								2022, nền tảng thương mại ZAYshop được xây dựng nhằm cung cấp
								cho người dùng những trải nghiệm dễ dàng, an toàn và nhanh chóng
								khi mua sắm trực tuyến. </font>
						</p>
						<p>
							<font face="Helvetica" size="4" color="#000000">-Chúng tôi
								có niềm tin mạnh mẽ rằng trải nghiệm mua sắm trực tuyến phải đơn
								giản, dễ dàng và mang đến cảm xúc vui thích. Niềm tin này truyền
								cảm hứng và thúc đẩy chúng tôi mỗi ngày tại ZAYshop.</font></b>
						</p>

						<p>
							- Nếu có vấn đề gì thì hãy liên hệ với <b><a
								href="https://www.facebook.com/maibaohuy.nocrush/"
								target="_blank">mình!</a>&nbsp;</b>
						</p>
						<p>
							- Nếu chưa có tài khoản hãy bấm vào đây để <b><a
								href="https://www.facebook.com/maibaohuy.nocrush/"
								target="_blank">Đăng kí!!</a>&nbsp;</b>
						<p></p>
						<p>
							<b><font face="Helvetica" size="5" color="#0080ff">Mục
									tiêu của chúng tôi</font> <img align="right" width=15%
								class="img-fluid" src="https://bom.so/4aTnHF" alt=""> </b>
						</p>
						<p>
							<font face="Helvetica" size="4" color="#000000">-Thứ 1:<font face="Helvetica" size="5" color="#00ff00">Qua môn</font></b>  </font><img
								height="32" width="32" alt=":v"
								src="https://static.xx.fbcdn.net/images/emoji.php/v9/e7e/1.5/32/PACMAN.png"></b>
						</p>
						<p>
							<font face="Helvetica" size="4" color="#000000">-Thứ 2: Điểm cao</font></b>
						</p>
						<p>
							<font face="Helvetica" size="4" color="#000000">-Thứ 3: Cả 2 điều trên</font></b>
						</p>

						<!-- <div class="ratio ratio-16x9">
							<iframe src="https://www.youtube.com/embed/OjAhUhnM6qY"
								title="YouTube video" allowfullscreen=""></iframe>
						</div> -->
					</div>
					<div class="modal-footer">
						<button class="btn btn-danger" data-bs-target="#global-modal2"
							data-bs-toggle="modal" data-bs-dismiss="modal">Đóng</button>
					</div>
				</div>
			</div>
		</div> --%>
		<script type="text/javascript">
			$(document).ready(function() {
				$('#global-modal').modal('show');
			});
		</script>
</body>
</html>

