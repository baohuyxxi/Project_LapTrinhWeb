<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<body>
<div>
<table id="example" class="table table-striped table-bordered"
	style="width: 100%">
	<thead>
		<tr>
			<th>Tên SP</th>
			<th>Giá</th>
			<th>Khuyến mãi (%)</th>
			<th>Còn</th>
			<th>Đã bán</th>
			<th>Size</th>
			<th>Ảnh</th>
			<th>SL mua</th>
			<th>Chức năng</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${cartitems }" var="cartitem">
			<tr>
				<td>${cartitem.product.name }</td>
				<td>${cartitem.product.price }</td>
				<td>${cartitem.product.promotion }</td>
				<td>${cartitem.product.quantity }</td>
				<td>${cartitem.product.sold }</td>
				<td>${cartitem.size }</td>
				<td>
					<c:if test="${cartitem.product.img!=null}">
						<img class="d-block w-100" style="width: 150px; height: 150px;" src="${product.img }">
					</c:if>
				</td>
				<td>${cartitem.count }</td>
				<td><a class="btn btn-primary" type="button"
					href="<c:url value='cartitem/edit?id=${cartitem.id }'/>">Cập nhật</a> <a
					class="btn btn-danger" type="button"
					href="<c:url value='cartitem/delete?id=${cartitem.id }'/>">Xóa</a>
			</tr>
		</c:forEach>		
	</tbody>
</table>
</div>

<div>
	<form action="cartitem/updateprice" method="post">
		<div class="input-group mb-3">
		  <div class="input-group-prepend">
		    <label class="input-group-text" for="inputGroupSelect01">Chọn đơn vị vận chuyển</label>
		  </div>
		  <select class="custom-select"  name="deliveryid">
		  	<c:forEach items="${deliverys }" var="delivery">
		  		<c:if test="${delivery.id==deliveryfromcartid.id}">
			    	<option value="${delivery.id }" selected="selected">${delivery.name }: ${delivery.price } (VNĐ)</option>
			    </c:if>
			    <c:if test="${delivery.id!=deliveryfromcartid.id}">
			    	<option value="${delivery.id }">${delivery.name }: ${delivery.price } (VNĐ)</option>
			    </c:if>
		    </c:forEach>
		  </select>
		  
		  <div>
				<button type="submit" class="btn btn-primary">Cập nhật giá</button>
		</div>
		<div class="input-group mb-3">
			<span class="input-group-text" id="basic-addon1">Địa chỉ</span> 
			<input
				type="text" class="form-control" placeholder="Address"
				aria-label="Username" aria-describedby="basic-addon1" name="address" value="${infoUser.address }">
		</div>
		<div class="input-group mb-3">
			<span class="input-group-text" id="basic-addon1">Số điện thoại</span> 
			<input
				type="text" class="form-control" placeholder="Phone"
				aria-label="Username" aria-describedby="basic-addon1" name="phone" value="${infoUser.phone }">
		</div>
		<div class="input-group mb-3">
			<span class="input-group-text" id="basic-addon1">Tổng khuyến mãi</span> 
			<input
				type="text" class="form-control"
				aria-label="Username" aria-describedby="basic-addon1" name="total_promotion" value="- ${total_promotion }">
				<span
			class="input-group-text" id="basic-addon2">VNĐ</span>
		</div>
		<div class="input-group mb-3">
			<span class="input-group-text" id="basic-ad	don1">Tổng tiền</span> 
			<input
				type="text" class="form-control"
				aria-label="Username" aria-describedby="basic-addon1" name="total_price" value="${total_price }">
				<span
			class="input-group-text" id="basic-addon2">VNĐ</span>
		</div>
	</div>
	</form>
</div>

<div>
	<form action="./order" method="post">
		<div class="input-group mb-3" hidden="">
		  <div class="input-group-prepend">
		    <label class="input-group-text" for="inputGroupSelect01">Chọn đơn vị vận chuyển</label>
		  </div>
		  <select class="custom-select"  name="deliveryid" >
		  	<c:forEach items="${deliverys }" var="delivery">
		  		<c:if test="${delivery.id==deliveryfromcartid.id}">
			    	<option value="${delivery.id }" selected="selected">${delivery.name }: ${delivery.price } (VNĐ)</option>
			    </c:if>
			    <c:if test="${delivery.id!=deliveryfromcartid.id}">
			    	<option value="${delivery.id }">${delivery.name }: ${delivery.price } (VNĐ)</option>
			    </c:if>
		    </c:forEach>
		  </select>
		  
		  <div>
				<button type="submit" class="btn btn-primary" >Cập nhật giá</button>
		</div>
		<div class="input-group mb-3">
			<span class="input-group-text" id="basic-addon1" >Địa chỉ</span> 
			<input
				type="text" class="form-control" placeholder="Address"
				aria-label="Username" aria-describedby="basic-addon1" name="address" value="${infoUser.address }">
		</div>
		<div class="input-group mb-3">
			<span class="input-group-text" id="basic-addon1">Số điện thoại</span> 
			<input
				type="text" class="form-control" placeholder="Phone"
				aria-label="Username" aria-describedby="basic-addon1" name="phone" value="${infoUser.phone }">
		</div>
		<div class="input-group mb-3">
			<span class="input-group-text" id="basic-addon1">Tổng khuyến mãi</span> 
			<input
				type="text" class="form-control"
				aria-label="Username" aria-describedby="basic-addon1" name="total_promotion" value="- ${total_promotion }">
				<span
			class="input-group-text" id="basic-addon2">VNĐ</span>
		</div>
		<div class="input-group mb-3">
			<span class="input-group-text" id="basic-ad	don1">Tổng tiền</span> 
			<input
				type="text" class="form-control"
				aria-label="Username" aria-describedby="basic-addon1" name="total_price" value="${total_price }">
				<span
			class="input-group-text" id="basic-addon2">VNĐ</span>
		</div>
	</div>
		
		
		
		<div>
			<button type="submit" class="btn btn-primary">Đặt hàng</button>
		</div>
	
	</form>

</div>


</body>
<script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable();
	});>
</script>

<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
