<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
</head>
<body>
	<div class="card">
		<div class="card-body">
			<h1 class="card-title">Thay đổi thông tin tài sản</h1>
			<form:form action="/edit-ncc" method="POST" modelAttribute="ncc"
				class="forms-sample">
				<div class="form-group">
					<form:hidden path="id" />
				</div>
				<div class="form-group">
					<label><b>Tên công ty</b></label>
					<form:input path="tencongty" class="form-control p-input" />
				</div>
				<div class="form-group">
					<label><b>Mã công ty</b></label>
					<form:input path="tentat" class="form-control p-input" />
				</div>
				<div class="form-group">
					<label><b>Địa chỉ</b></label>
					<form:input path="diachi" class="form-control p-input" />
				</div>
				<div class="form-group">
					<label><b>Điện thoại</b></label>
					<form:input path="dienthoai" class="form-control p-input" />
				</div>
				<div class="form-group">
					<label><b>Email</b></label>
					<form:input path="email" class="form-control p-input" />
				</div>
				<div class="form-group">
					<label><b>Mã số thuế</b></label>
					<form:input path="masothue" class="form-control p-input" />
				</div>
				<div class="form-group">
					<label><b>Người đại diện</b></label>
					<form:input path="nguoidaidien" class="form-control p-input" />
				</div>
				<div class="form-group">
					<label><b>IsCompany</b></label>
					<form:radiobutton path="company" value="Công ty" label="Công ty" />
					<form:radiobutton path="company" value="Cá nhân" label="Cá nhân" />
				</div>
				<div>
					<button type="submit" class="btn btn-add btn-sm">Sửa</button>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>