<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${myStorelist==null }">
	<button type="button" class="btn btn-primary" data-toggle="modal"
								data-target="#addStore" >Tạo cửa hàng</button>
</c:if>
<c:if test="${myStorelist!=null }">
	<button type="button" class="btn btn-primary" data-toggle="modal"
								data-target="#addStore" hidden="hidden">Tạo cửa hàng</button>
</c:if>
								
								
<div class="container">
<table id="example" class="table table-striped table-bordered"
	style="width: 100%">
	<thead>
		<tr>
			<th>Tên cửa hàng</th>
			<th>Tên miền</th>
			<th>Địa chỉ</th>
			<th>Ngày tạo</th>
			<th>Ngày cập nhật</th>
			<th>Chức năng</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${myStorelist }" var="store">	
			<tr>
				<td>${store.name }</td>
				<td>${store.slug }</td>
				<td>${store.address }</td>
				<td>${store.createdAt }</td>
				<td>${store.updatedAt }</td>
				<td><a
					href="<c:url value='/vendor/store/edit?id=${store.id }'/>"
					class="center">Sửa</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>


<header>
	<style>
	</style>
</header>



<div class="card">
  <div class="ds-top"></div>
  <div class="avatar-holder">
    <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/1820405/profile/profile-512.jpg?1533058950" alt="Albert Einstein">
  </div>
  <div class="name">
    <a href="https://codepen.io/AlbertFeynman/" target="_blank">Albert Feynman</a>
    <h6 title="Followers"><i class="fas fa-users"></i> <span class="followers">90</span></h6>
  </div>
  <div class="button">
    <a href="#" class="btn" onmousedown="follow();">Follow <i class="fas fa-user-plus"></i></a>
  </div>
  <div class="ds-info">
    <div class="ds pens">
      <h6 title="Number of pens created by the user">Pens <i class="fas fa-edit"></i></h6>
      <p>29</p>
    </div>
    <div class="ds projects">
      <h6 title="Number of projects created by the user">Projects <i class="fas fa-project-diagram"></i></h6>
      <p>0</p>
    </div>
    <div class="ds posts">
      <h6 title="Number of posts">Posts <i class="fas fa-comments"></i></h6>
      <p>0</p>
    </div>
  </div>
  <div class="ds-skill">
    <h6>Skill <i class="fa fa-code" aria-hidden="true"></i></h6>
    <div class="skill html">
      <h6><i class="fab fa-html5"></i> HTML5 </h6>
      <div class="bar bar-html">
        <p>95%</p>
      </div>
    </div>
    <div class="skill css">
      <h6><i class="fab fa-css3-alt"></i> CSS3 </h6>
      <div class="bar bar-css">
        <p>90%</p>
      </div>
    </div>
    <div class="skill javascript">
      <h6><i class="fab fa-js"></i> JavaScript </h6>
      <div class="bar bar-js">
        <p>75%</p>
      </div>
    </div>
  </div>
</div>











</div>
<script type="text/javascript">$(document).ready(function() {
    $('#example').DataTable();
	});></script>
	
<div id="addStore" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					<form action="store/add" method="post">
						<div class="modal-header">
							<h4 class="modal-title">Tạo cửa hàng</h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<label>Tên cửa hàng</label> <input name="name" type="text"
									class="form-control" required>
							</div>
							<div class="form-group">
								<label>Tên miền</label> <input name="slug" type="text"
									class="form-control" required>
							</div>
							<div class="form-group">
								<label>Địa chỉ</label>
								<textarea name="address" class="form-control" required></textarea>
							</div>

						</div>
						<div class="modal-footer">
							<input type="button" class="btn btn-default" data-dismiss="modal"
								value="Trở lại"> <input type="submit"
								class="btn btn-success" value="Thêm">
						</div>
					</form>
				</div>
			</div>
		</div>
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
	