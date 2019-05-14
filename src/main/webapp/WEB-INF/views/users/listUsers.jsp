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
		<table class="table center-aligned-table">
			<tr>
				<th>ID</th>
				<th>Tên tài khoản</th>
				<th>Mật khẩu</th>
				<!-- <th>Quyền</th> -->
				<!-- 	<th>Xác nhận mật khẩu</th> -->
			</tr>
			<c:forEach var="ls" items="${ltsTk }">
				<tr>
					<td>${ls.getId() }</td>
					<td>${ls.username }</td>
					<td>${ls.getPassword()}</td>
					<%-- <td>${ls.getRoles()}</td> --%>
					<%-- <td>${ls.passwordConfirm }</td> --%>
					<td><a class="btn btn-primary btn-sm"
						href="<c:url value='edit-dstk/${ls.id}'/>">Sửa</a> &nbsp; <a
						class="btn btn-danger btn-sm"
						href="<c:url value='delete-dstk/${ls.id}'/>">Xóa</a> &nbsp; <a
						class="btn btn-view btn-sm"
						href="<c:url value='view-taikhoan-details/${id}'/>">Xem</a></td>
				</tr>
			</c:forEach>
		</table>

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
						<button type="submit" class="btn btn-add btn-sm">Thêm</button>
					</div>



				</form>
			</div>
		</div>

	</div>
</div>

