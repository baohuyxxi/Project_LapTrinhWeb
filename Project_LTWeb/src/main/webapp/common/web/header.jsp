<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/" var="link"></c:url>
<!-- Header -->
<!-- Start Top Nav -->
    <nav class="navbar navbar-expand-lg bg-dark navbar-light d-none d-lg-block" id="templatemo_nav_top">
        <div class="container text-light">
            <div class="w-100 d-flex justify-content-between">
                <div>
                    <i class="fa fa-envelope mx-2"></i>
                    <a class="navbar-sm-brand text-light text-decoration-none" href="mailto:info@company.com">info@company.com</a>
                    <i class="fa fa-phone mx-2"></i>
                    <a class="navbar-sm-brand text-light text-decoration-none" href="tel:010-020-0340">033 5441895</a>
                </div>
                <div>
                    <a class="text-light" href="https://fb.com/templatemo" target="_blank" rel="sponsored"><i class="fab fa-facebook-f fa-sm fa-fw me-2"></i></a>
                    <a class="text-light" href="https://www.instagram.com/" target="_blank"><i class="fab fa-instagram fa-sm fa-fw me-2"></i></a>
                    <a class="text-light" href="https://twitter.com/" target="_blank"><i class="fab fa-twitter fa-sm fa-fw me-2"></i></a>
                    <a class="text-light" href="https://www.linkedin.com/" target="_blank"><i class="fab fa-linkedin fa-sm fa-fw"></i></a>
                </div>
            </div>
        </div>
    </nav>
    <!-- Close Top Nav -->


    <!-- Header -->
    <nav class="navbar navbar-expand-lg navbar-light shadow" style="display: block;">
     <div
		class="container d-flex justify-content-between align-items-center" style="height: 130px">
		<div class="c-brand c-pull-left">
			<a href="${link}/home" class="c-logo"> <img
				src="https://bom.so/NAJjSb" alt=""
				style="height: 150px; margin-top: 35px;" class="c-desktop-logo">
			</a>
		</div>

            <button class="navbar-toggler border-0" type="button" data-bs-toggle="collapse" data-bs-target="#templatemo_main_nav" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="align-self-center collapse navbar-collapse flex-fill  d-lg-flex justify-content-lg-between" id="templatemo_main_nav">
                <div class="flex-fill">
                    <ul class="nav navbar-nav d-flex justify-content-between mx-lg-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="${link}./home">Trang chủ</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${link}./products">Sản phẩm</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${link }./about">Thông tin</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${link}./shops">Cửa Hàng</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${link }./contact">Liên Hệ</a>
                        </li>
                    </ul>
                </div>
                <div class="navbar align-self-center d-flex">
                    <a class="nav-link" href="${link }./login">Đăng Nhập </a>
                    <a class="nav-link" href="#">Đăng Kí (None) </a>
                </div>
            </div>

        </div>
        <div
		class="container  d-flex">
		<div class="heading col-sm-12 text-center">
		<form action="${link}products" class="search" method="post">
			<input type="text" class="searchTerm"  placeholder="Bạn muốn tìm gì?" name="question" class="form-control" required>
			<button type="submit" class="searchButton">Tìm Kiếm</button>
		</form>
	</div>
		</div>
    </nav>
    <!-- Close Header -->