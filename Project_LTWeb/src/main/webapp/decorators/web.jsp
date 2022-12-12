<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="../assets/img/apple-icon.png">
    <link rel="shortcut icon" type="image/x-icon" href="<c:url value="/assets/img/favicon.ico"/>">
    <link rel="stylesheet" href="<c:url value="/assets/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/css/templatemo.css"/>">

    <!-- Load fonts style after rendering the layout styles -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
    <link rel="stylesheet" href="<c:url value="/assets/css/fontawesome.min.css"/>">
	<!-- <script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script> -->
	
<title>Zay Shop</title>
</head>
<body>
	<!-- Modal -->
	<div class="modal fade bg-white" id="templatemo_search" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="w-100 pt-1 mb-5 text-right">
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<form action="" method="get"
				class="modal-content modal-body border-0 p-0">
				<div class="input-group mb-2">
					<input type="text" class="form-control" id="inputModalSearch"
						name="q" placeholder="Search ...">
					<button type="submit"
						class="input-group-text bg-success text-light">
						<i class="fa fa-fw fa-search text-white"></i>
					</button>
				</div>
			</form>
		</div>
	</div>
	<%@ include file="/common/web/header.jsp"%>
	
	<dec:body/>
	
	<%@ include file="/common/web/footer.jsp"%>
    
    <!-- Start Script -->
    <script src="<c:url value="/assets/js/jquery-1.11.0.min.js"/>"></script>
    <script src="<c:url value="/assets/js/jquery-migrate-1.2.1.min.js"/>"></script>
    <script src="<c:url value="/assets/js/bootstrap.bundle.min.js"/>"></script>
    <script src="<c:url value="/assets/js/templatemo.js"/>"></script>
    <script src="<c:url value="/assets/js/custom.js"/>"></script>

    <!-- End Script -->
    <style>
	html,body{cursor:url("https://1.bp.blogspot.com/-qbWo9mPKO2Y/YL9utYdQBdI/AAAAAAAAFs4/mtjGu6u2uGwtJsT4gZG4lbhLV1a5lG6OQCLcBGAsYHQ/s0/mouse-f1.png"), auto;}
	a:hover{cursor:url("https://1.bp.blogspot.com/-nYv2dLl3oXY/YL9utYBCh8I/AAAAAAAAFtA/wII4lVw5w4k-4isGMY41heTqk8U4TJujgCLcBGAsYHQ/s0/mouse-f2.png"), auto;}
.rounded-circle {
	width: 300px;
	height: 300px;
	 text-align:center;
}
.div1 {
	 text-align:center;
}

</style>
  
</body>
</html>