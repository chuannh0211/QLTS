<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
</head>
<body>
	<table class="table center-aligned-table">
		<tr>
			<th>Họ tên</th>
			<th>Email</th>
			<th>Số điện thoại</th>
		</tr>
		<tr>
			<td>${nUser.fullname }</td>
			<td>${nUser.email }</td>
			<td>${nUser.phone }</td>
			<td></td>
		</tr>

	</table>
</body>
</html>