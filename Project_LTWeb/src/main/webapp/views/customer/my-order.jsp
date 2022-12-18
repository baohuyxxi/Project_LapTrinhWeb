<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>






<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
  <li class="nav-item">
    <a class="nav-link active" id="pills-home-tab" data-toggle="pill" href="#xacnhan" role="tab" aria-controls="pills-home" aria-selected="true">Chờ xác nhận</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" id="pills-profile-tab" data-toggle="pill" href="#daxacnhan" role="tab" aria-controls="pills-profile" aria-selected="false">Đã xác nhận</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" id="pills-contact-tab" data-toggle="pill" href="#dangvanchuye" role="tab" aria-controls="pills-contact" aria-selected="false">Đang vận chuyển</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" id="pills-contact-tab" data-toggle="pill" href="#hoanthanh" role="tab" aria-controls="pills-contact" aria-selected="false">Hoàn thành</a>
  </li>
</ul>
<div class="tab-content" id="pills-tabContent">
  <div class="tab-pane fade show active" id="xacnhan" role="tabpanel" aria-labelledby="pills-home-tab">
  <table id="example" class="table table-striped table-bordered"
		style="width: 100%">
		<thead>
			<tr>
				<th>Mã đơn hàng</th>
				<th>Tên cửa hàng</th>
				<th>Đơn vị vận chuyên</th>
				<th>Địa chỉ GH</th>
				<th>SDT GH</th>
				<th>Trạng thái</th>
				<th>Tổng giá của DH</th>
				<th>Ngày đặt hàng</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${orders0 }" var="order0">
				<tr>
					<td>${order0.id }</td>
					<td>${order0.storename }</td>
					<td>${order0.deliveryname }</td>
					<td>${order0.address }</td>
					<td>${order0.phone }</td>
					<td><c:if test="${order0.status==0}">
						Chờ xác nhận
					</c:if>
					<c:if test="${order0.status==1}">
						Đã xác nhận
					</c:if>
					<c:if test="${order0.status==2}">
						Đang vận chuyển
					</c:if>
					<c:if test="${order0.status==3}">
						Hoàn thành
					</c:if>
					</td>
					<td>${order0.total_price }</td>
					<td>${order0.dayorder }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


</div>
  <div class="tab-pane fade" id="daxacnhan" role="tabpanel" aria-labelledby="pills-profile-tab">
  <table id="example" class="table table-striped table-bordered"
		style="width: 100%">
		<thead>
			<tr>
				<th>Mã đơn hàng</th>
				<th>Tên cửa hàng</th>
				<th>Đơn vị vận chuyên</th>
				<th>Địa chỉ GH</th>
				<th>SDT GH</th>
				<th>Trạng thái</th>
				<th>Tổng giá của DH</th>
				<th>Ngày đặt hàng</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${orders1 }" var="order1">
				<tr>
					<td>${order1.id }</td>
					<td>${order1.storename }</td>
					<td>${order1.deliveryname }</td>
					<td>${order1.address }</td>
					<td>${order1.phone }</td>
					<td><c:if test="${order1.status==0}">
						Chờ xác nhận
					</c:if>
					<c:if test="${order1.status==1}">
						Đã xác nhận
					</c:if>
					<c:if test="${order1.status==2}">
						Đang vận chuyển
					</c:if>
					<c:if test="${order1.status==3}">
						Hoàn thành
					</c:if>
					</td>
					<td>${order1.total_price }</td>
					<td>${order1.dayorder }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
  
  </div>
  <div class="tab-pane fade" id="dangvanchuye" role="tabpanel" aria-labelledby="pills-contact-tab">
  <table id="example" class="table table-striped table-bordered"
		style="width: 100%">
		<thead>
			<tr>
				<th>Mã đơn hàng</th>
				<th>Tên cửa hàng</th>
				<th>Đơn vị vận chuyên</th>
				<th>Địa chỉ GH</th>
				<th>SDT GH</th>
				<th>Trạng thái</th>
				<th>Tổng giá của DH</th>
				<th>Ngày đặt hàng</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${orders2 }" var="order2">
				<tr>
					<td>${order2.id }</td>
					<td>${order2.storename }</td>
					<td>${order2.deliveryname }</td>
					<td>${order2.address }</td>
					<td>${order2.phone }</td>
					<td><c:if test="${order2.status==0}">
						Chờ xác nhận
					</c:if>
					<c:if test="${order2.status==1}">
						Đã xác nhận
					</c:if>
					<c:if test="${order2.status==2}">
						Đang vận chuyển
					</c:if>
					<c:if test="${order2.status==3}">
						Hoàn thành
					</c:if>
					</td>
					<td>${order2.total_price }</td>
					<td>${order2.dayorder }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
  </div>
   <div class="tab-pane fade" id="hoanthanh" role="tabpanel" aria-labelledby="pills-contact-tab">
   <table id="example" class="table table-striped table-bordered"
		style="width: 100%">
		<thead>
			<tr>
				<th>Mã đơn hàng</th>
				<th>Tên cửa hàng</th>
				<th>Đơn vị vận chuyên</th>
				<th>Địa chỉ GH</th>
				<th>SDT GH</th>
				<th>Trạng thái</th>
				<th>Tổng giá của DH</th>
				<th>Ngày đặt hàng</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${orders3 }" var="order3">
				<tr>
					<td>${order3.id }</td>
					<td>${order3.storename }</td>
					<td>${order3.deliveryname }</td>
					<td>${order3.address }</td>
					<td>${order3.phone }</td>
					<td><c:if test="${order3.status==0}">
						Chờ xác nhận
					</c:if>
					<c:if test="${order3.status==1}">
						Đã xác nhận
					</c:if>
					<c:if test="${order3.status==2}">
						Đang vận chuyển
					</c:if>
					<c:if test="${order3.status==3}">
						Hoàn thành
					</c:if>
					</td>
					<td>${order3.total_price }</td>
					<td>${order3.dayorder }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
   </div>
</div>





















	






</body>

</html>



