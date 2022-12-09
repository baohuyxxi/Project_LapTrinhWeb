<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:url value="zay/product" var="product"></c:url>

	<form role="form" action="${product }" method="post">
		<div class="container" align="center">
			<div class="col-12 col-md-4 p-5 mt-3">
				<h1 class="h1 text-success" align="center">
					<b>${pro.name }</b>
				</h1>
				<img src="${pro.img }" class="rounded-circle img-fluid border">
				<h1 class="h1">${pro.description }</h1>
				<h1 class="h1">${pro.price }</h1>
				<h1 class="h1">${pro.promotion }</h1>
				<h1 class="h1">${pro.quantity }</h1>
				<h1 class="h1">${pro.sold }</h1>
				<h1 class="h1">${pro.category_id }</h1>
				<h1 class="h1">${pro.storeId }</h1>
				<h1 class="h1">${pro.createdAt }</h1>
				<h1 class="h1">${pro.updatedAt }</h1>
			</div>
		</div>
	</form>

</body>

<script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable();
	});>
</script>