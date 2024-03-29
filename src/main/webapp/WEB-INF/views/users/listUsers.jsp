<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<div class="card">
	<div class="card-body">
		<h1 class="card-title">Danh sách tài khoản</h1>
		<%-- <a  href="${pageContext.request.contextPath }/">ADD NEW
			TÀI SẢN</a> --%>
		<button id="myBtn" class="btn btn-add btn-sm">Thêm tài khoản</button>
		<input type="text" class="form-control form-control-sm search-taisan"
				id="mySearch" onkeyup="myFunction()" placeholder="Tìm kiếm">
		<table class="table center-aligned-table" id="myTable">
			<tr>
				<th>STT</th>
				<th>Tên tài khoản</th>
				<th>Họ tên</th>
				<th>Email</th>
				<th>Số điện thoại</th>
				<!-- 	<th>Xác nhận mật khẩu</th> -->
			</tr>
			<c:set var="count" value="1" />
			<c:forEach var="ls" items="${ltsTk }">
				<tr>
					<td><c:out value="${count }"></c:out></td>
					<td>${ls.username }</td>
					<td>${ls.fullname }</td>
					<td>${ls.email }</td>
					<td>${ls.phone }</td>
					<%-- <td>${ls.passwordConfirm }</td> --%>
					<td>
						<%-- <a class="btn btn-primary btn-sm"
						href="<c:url value='edit-dstk/${ls.id}'/>">Sửa</a> &nbsp; --%>
						<a class="btn btn-view btn-sm open-modal-user-detail" id-user="${ls.id}" href="javascript:void(0);">Xem</a>
						<a id-user="${ls.id}" class="btn btn-primary btn-sm open-modal-editUser" href="javascript:void(0);">Sửa</a>
						<a class="btn btn-danger btn-sm" onclick="return confirm('Chắc Chắn Muốn Xóa')" href="<c:url value='/user/delete-users/${ls.id}'/>">Xóa</a> &nbsp; 
						
					</td>
				</tr>
			<c:set var="count" value="${count + 1}"></c:set>
			</c:forEach>
		</table>
		<!-- phân trang -->
		<div class="row">
			<div class="col-sm-12 col-md-5">
				<div class="dataTables_info">Showing ${number + 1} to ${size }
					of ${totalElement}</div>
			</div>
			<div class="col-sm-12 col-md-7">
				<div class="dataTables_paginate paging_simple_numbers">
					<ul class="pagination">
						<c:forEach begin="0" end="${totalPages -1 }" var="page">
							<li class="paginate_button page-item"><a class="page-link"
								href="javascript:void(0);"
								onclick="paginationAcc(${page}, ${size})">${page + 1 }</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
		<!-- Modal thêm tài khoản mới -->
		<div id="myModal" class="modal">
			<div class="modal-content">
				<div>
					<span class="closee">&times;</span>
				</div>
				<!-- 	<h4 class="modal-title">Thêm tài sản</h4> -->
				<form action="/register-form" method="post" class="forms-sample">
					<div class="form-group">
						<label><b>Tài khoản:</b></label> <input
							class="form-control p_input" type="text" placeholder="Tài khoản"
							name="username" required="required">
					</div>

					<div class="form-group">
						<label><b>Mật khẩu:</b></label> <input
							class="form-control p_input" type="password"
							placeholder="Mật khẩu" name="password" required="required">
					</div>

					<div class="form-group">
						<label><b>Nhập lại mật khẩu:</b></label> <input
							class="form-control p_input" type="password"
							placeholder="Xác nhận mật khẩi" name="passwordConfirm"
							required="required">
					</div>
					<div class="form-group">
						<label><b>Họ tên:</b></label> <input class="form-control p_input"
							type="text" placeholder="Nhập họ tên" name="fullname"
							required="required">
					</div>
					<div class="form-group">
						<label><b>Email:</b></label> <input class="form-control p_input"
							type="text" placeholder="Nhập email" name="email"
							required="required">
					</div>
					<div class="form-group">
						<label><b>Số điện thoại:</b></label> <input
							class="form-control p_input" type="text"
							placeholder="Nhập số điện thoại" name="phone" required="required">
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-add btn-sm">Thêm</button>
					</div>
				</form>
			</div>
		</div>
		<!-- finish -->
		<!-- Modal xem thông tin người dùng -->
		<div id="myModal-InfoUser" class="modal">
			<div class="modal-content">
				<h2 class="card-title">Thông tin người dùng</h2>
				<span class="closee">&times;</span>
				<div id="content_infoUser"></div>

			</div>
		</div>
		<!-- finish-->

		<!-- Modal sửa thông tin người dùng -->
		<div id="myModal-editUser" class="modal">
			<div class="modal-content">
				<h2 class="card-title">Sửa thông tin người dùng</h2>
				<span class="closee">&times;</span>
				<div id="content_editUser"></div>
			</div>
		</div>

		<!-- finish -->
	</div>
</div>

