<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<div class="card">
		<div class="card-body">
			<h1 class="card-title">Thay đổi thông tin nhóm</h1>
			<hr>
			<form:form action="/edit-dsn" method="POST" modelAttribute="gr"
				class="forms-sample">
				<div>
					<form:hidden path="id" />
				</div>
				<div class="form-group">
					<label><b>Name category</b></label>
					<form:input path="name" class="form-control p-input"/>
				</div>
				<div class="form-group">
					<label><b>Name PM</b></label>
					<form:input path="pm" class="form-control p-input"/>
				</div>


				<button type="submit" class="btn btn-add btn-sm">Sửa</button>
			</form:form>
		</div>
	</div>
</body>
</html>