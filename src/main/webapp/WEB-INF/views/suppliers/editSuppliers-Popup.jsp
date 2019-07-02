<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
</head>
<body>
	<div class="card">
		<div class="card-body">
			<form:form action="/supplier/edit-supplier" method="POST" modelAttribute="ncc"
				class="forms-sample">
				<div class="form-group">
					<form:hidden path="id" />
				</div>
				<div class="form-group">
					<label><b>Tên công ty</b></label>
					<%-- <form:input path="tencongty" class="form-control p-input" /> --%>
					<input name="tencongty" class="form-control p-input"
						value="${newNcc.tencongty }" pattern="^[A-Za-z0-9._-].{3,30}$"
						title="Sai định dạng !!!" required>
				</div>
				<div class="form-group">
					<label><b>Mã công ty</b></label>
					<%-- <form:input path="tentat" class="form-control p-input" /> --%>
					<input name="tentat" class="form-control p-input"
						value="${newNcc.tentat }" pattern="^[A-Za-z0-9._-].{1,15}$"
						title="Sai định dạng !!!" required>
				</div>
				<div class="form-group">
					<label><b>Địa chỉ</b></label>
					<%-- <form:input path="diachi" class="form-control p-input" /> --%>
					<input name="diachi" class="form-control p-input"
						value="${newNcc.diachi }" pattern="[A-Za-z0-9].{5-10}"
						title="Sai định dạng !!!" required>
				</div>
				<div class="form-group">
					<label><b>Điện thoại</b></label>
					<%-- <form:input path="dienthoai" class="form-control p-input" /> --%>
					<input name="dienthoai" class="form-control p-input"
						value="${newNcc.dienthoai }" pattern="[0-9].{10}"
						title="Sai định dạng !!!" required>
				</div>
				<div class="form-group">
					<label><b>Email</b></label>
					<%-- <form:input path="email" class="form-control p-input" /> --%>
					<input name="email" class="form-control p-input"
						value="${newNcc.email }"
						pattern="^([A-Za-z0-9]+)@([a-z]{10}+)(\.+)([a-z]{2-5})$"
						title="Sai định dạng !!!" required>
				</div>
				<div class="form-group">
					<label><b>Mã số thuế</b></label>
					<%-- <form:input path="masothue" class="form-control p-input" /> --%>
					<input name="masothue" class="form-control p-input"
						value="${newNcc.masothue }" pattern="[A-Za-z0-9].{5,10}"
						title="Sai định dạng !!!" required>
				</div>
				<div class="form-group">
					<label><b>Người đại diện</b></label>
					<%-- <form:input path="nguoidaidien" class="form-control p-input" /> --%>
					<input name="nguoidaidien" class="form-control p-input"
						value="${newNcc.nguoidaidien }" pattern="^[A-Za-z].{5,32}$"
						title="Sai định dạng !!!" required>
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