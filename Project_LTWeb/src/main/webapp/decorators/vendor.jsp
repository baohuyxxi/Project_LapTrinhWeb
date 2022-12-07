<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="../assets/img/apple-icon.png">
    <link rel="shortcut icon" type="image/x-icon" href="../assets/img/favicon.ico">
    <link rel="stylesheet" href="<c:url value="/assets/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/css/templatemo.css"/>">

    <!-- Load fonts style after rendering the layout styles -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
    <link rel="stylesheet" href="<c:url value="/assets/css/fontawesome.min.css"/>">
<title>Zay Shop</title>
</head>
<body>
	<%@ include file="/common/vendor/header.jsp"%>
	
	<dec:body/>
	
	<%@ include file="/common/vendor/footer.jsp"%>
	<!-- Start Script -->
    <script src="<c:url value="/assets/js/jquery-1.11.0.min.js"/>"></script>
    <script src="<c:url value="/assets/js/jquery-migrate-1.2.1.min.js"/>"></script>
    <script src="<c:url value="/assets/js/bootstrap.bundle.min.js"/>"></script>
    <script src="<c:url value="/assets/js/templatemo.js"/>"></script>
    <script src="<c:url value="/assets/js/custom.js"/>"></script>

    <!-- End Script -->
</body>
</html>