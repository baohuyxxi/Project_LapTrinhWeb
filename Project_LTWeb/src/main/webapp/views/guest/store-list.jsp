<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<body>

<table id="example" class="table table-striped table-bordered"
	style="width: 100%">
	<div class="row">
		<div class="heading col-sm-12 text-center"
			style="margin-bottom: 20px; margin-top: 40px;">
			<h2>Danh Mục Shop</h2>
			<div
				style="width: 100px; height: 1px; margin: 20px auto; border-bottom: 4px solid #e90606;"></div>
		</div>
		<c:forEach items="${stor}" var="stor">
			<div class="col-10 col-md-4 p-5 mt-3" >
			<div class="div1" ><a href="store?id=${stor.id }"  ><img src="${stor.avatar }"
					class="rounded-circle img-fluid border"></a></div>
			<h5 class="text-center mt-3 mb-3" >${stor.name }</h5>
			<h5 class="text-center mt-3 mb-3">Sản phẩm đã bán: ${stor.sold }</h5>
			<h6 class="text-center mt-3 mb-3">Cập nhật: ${stor.updatedAt }</h6>
			</div>
		</c:forEach>
	</div>
</table>

</body>

<script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable();
	});>
</script>