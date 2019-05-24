<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8>
</head>
<body>
	<div class="card">
		<div class="card-body">
			<h1 class="card-title">Sửa thông tin tài khoản</h1>
			<form:form action="/edit-dstk" method="POST" modelAttribute="user"
				class="forms-sample">
				<div class="form-group">
					<form:hidden path="id" />
				</div>

				<div class="form-group">
					<label><b>Tài khoản:</b></label>
					<form:input path="username" class="form-control p-input" />
				</div>


				<div class="form-group">
					<label><b>Mật khẩu:</b></label>
					<form:input path="password" class="form-control p-input" />
				</div>

				<div class="form-group">
					<label><b>Xác nhận mật khẩu</b></label>
					<form:input path="passwordConfirm" class="form-control p-input" />
				</div>
				
				<div class="form-group">
					<label><b>Họ tên</b></label>
					<form:input path="fullname" class="form-control p-input" />
				</div>
				
				<div class="form-group">
					<label><b>Email</b></label>
					<form:input path="email" class="form-control p-input" />
				</div>
				
				<div class="form-group">
					<label><b>Số điện thoại</b></label>
					<form:input path="phone" class="form-control p-input" />
				</div>

				<div class="form-group">
					<button type="submit" class="btn btn-add btn-sm">Sửa</button>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>