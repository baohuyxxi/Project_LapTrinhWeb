<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="col-md-2 d-none d-md-block bg-light sidebar">
	<div class="sidebar-sticky">
		<ul class="nav flex-column">
			<li class="nav-item"><a class="nav-link ${home }" href="${link}/trang-chu" style="padding-bottom: 15%;
    font-size: 20px;"> <span
					data-feather="home"></span> Dashboard <span class="sr-only"></span>
			</a></li>
			<li class="nav-item"><a class="nav-link ${account }" href="${link}/account" style="padding-bottom: 15%;
    font-size: 20px;"> <span
					data-feather="file"></span> Account
			</a></li>
			<li class="nav-item"><a class="nav-link ${store }" href="${link}/store" style="padding-bottom: 15%;
    font-size: 20px;"> <span
					data-feather="shopping-cart"></span> Stores
			</a></li>
			<li class="nav-item"><a class="nav-link ${user }" href="${link}/infouser" style="padding-bottom: 15%;
    font-size: 20px;"> <span
					data-feather="users"></span> Customers
			</a></li>
			<li class="nav-item"><a class="nav-link ${category }" href="${link}/category" style="padding-bottom: 15%;
    font-size: 20px;"> <span
					data-feather="bar-chart-2"></span> Categories
			</a></li>
			<li class="nav-item"><a class="nav-link ${evaluate }" href="${link}/evaluated" style="padding-bottom: 15%;
    font-size: 20px;"> <span
					data-feather="layers"></span> Evaluate
			</a></li>
			<li class="nav-item"><a class="nav-link ${delivery }" href="${link}/delivery" style="padding-bottom: 15%;
    font-size: 20px;"> <span
					data-feather="layers"></span> Delivery
			</a></li>
		</ul>
	</div>
</nav>