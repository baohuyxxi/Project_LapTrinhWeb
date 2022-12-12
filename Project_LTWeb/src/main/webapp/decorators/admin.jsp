<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="<c:url value="/assets/css/cssOfHuy.css"/>">
    <link rel="apple-touch-icon" href="../assets/img/apple-icon.png">
    <link rel="shortcut icon" type="image/x-icon" href="<c:url value="/assets/img/favicon.ico"/>">
    <link rel="stylesheet" href="<c:url value="/assets/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/css/dashboard.css"/>">

<title>Zay Admin</title>
</head>
<body>

	<%@ include file="/common/admin/headerAD.jsp"%>
	
	<dec:body/>
	<%@ include file="/common/admin/admin_left.jsp"%>
	
	
	<!-- Start Script -->
    <script src="<c:url value="/assets/js/jquery-1.11.0.min.js"/>"></script>
    <script src="<c:url value="/assets/js/jquery-migrate-1.2.1.min.js"/>"></script>
    <script src="<c:url value="/assets/js/bootstrap.bundle.min.js"/>"></script>
    <script src="<c:url value="/assets/js/templatemo.js"/>"></script>
    <script src="<c:url value="/assets/js/custom.js"/>"></script>

	<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>

	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

	<!-- End Script -->
</body>
</html>