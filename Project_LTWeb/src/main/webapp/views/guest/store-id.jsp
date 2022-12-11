<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<table id="example" class="table table-striped table-bordered"
	style="width: 100%">

	
	
	<c:url value="zay/store" var="store"></c:url>
	<div class="row">
	<div class="heading col-sm-12 text-center" style=" margin-bottom: 20px; margin-top:40px;">
                    <h2> ${stor.name }</h2>
                    <h2>Danh Mục Sản Phẩm </h2>
                    <div style="width: 100px; height: 1px; margin: 20px auto; border-bottom: 4px solid #e90606;"></div>
                </div>
		<c:forEach items="${pro}" var="pro">
			<div class="col-10 col-md-4 p-5 mt-3">
				<a href="product?id=${pro.id }"><img src="${pro.img }"
					class="rounded-circle img-fluid border"></a>
				<h5 class="text-center mt-3 mb-3">${pro.name }</h5>
				<h6 class="text-center mt-3 mb-3">${pro.categoryName }</h6>
				<h6 class="text-center mt-3 mb-3">Giá ${pro.price }đ</h6>
				<h6 class="text-center mt-3 mb-3">Đã bán ${pro.sold }</h6>
				
			</div>
		</c:forEach>
	</div>

</table>
<script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable();
	});>
</script>