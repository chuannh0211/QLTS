<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="card">
	<div class="card-body">
		<form:form action="/user/edit-users" method="POST" modelAttribute="user"
			class="forms-sample">
			<div class="form-group">
				<%-- <form:hidden path="id" /> --%>
				<input type="hidden" value="${user.id }" name="id">
			</div>

			<div class="form-group">
				<label><b>Tài khoản:</b></label>
				<%-- <form:input path="username" class="form-control p-input" /> --%>
				<input type="text" value="${user.username }" name="username"
					class="form-control p-input" required pattern="^[a-z0-9._-]{3,15}$"
					title="Sai định dạng !!!">
			</div>

			<div class="form-group">
				<!-- <label><b>Mật khẩu:</b></label> -->
				<%-- <form:input path="password" class="form-control p-input" /> --%>
				<input type="hidden" value="${user.password }" name="password"
					class="form-control p-input" required pattern=".{5,}"
					title="Sai định dạng !!!">
			</div>

			<div class="form-group">
				<!-- <label><b>Xác nhận mật khẩu</b></label> -->
				<%-- <form:input path="passwordConfirm" class="form-control p-input" /> --%>
				<input type="hidden" value="${user.passwordConfirm }"
					name="passwordConfirm" class="form-control p-input" required
					pattern=".{5,}"
					title="Sai định dạng !!!">
			</div>

			<div class="form-group">
				<label><b>Họ tên</b></label>
				<%-- <form:input path="fullname" class="form-control p-input" /> --%>
				<input type="text" value="${user.fullname }" name="fullname"
					class="form-control p-input" required pattern="^[A-Za-z].{5,50}"
					title="Sai định dạng !!!">
			</div>
			<!-- pattern="^(.+)@(.+)$" -->
			<div class="form-group">
				<label><b>Email</b></label>
				<%-- <form:input path="email" class="form-control p-input" /> --%>
				<input type="text" value="${user.email }" name="email"
					class="form-control p-input" required pattern="^([a-zA-z0-9]+)@([a-z]+)(\.+)[a-z]{2,5}$" 
					title="Phải nhập đúng định dạng email !!!">
			</div>

			<div class="form-group">
				<label><b>Số điện thoại</b></label>
				<%-- <form:input path="phone" class="form-control p-input" /> --%>
				<input type="text" value="${user.phone }" name="phone"
					class="form-control p-input" required pattern="(09|01[2|6|8|9])+([0-9]{8})\b"
					title="Sai định dạng số điện thoại !!!">
			</div>

			<div class="form-group">
				<button type="submit" class="btn btn-add btn-sm">Sửa</button>
			</div>
		</form:form>
	</div>
</div>