<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Đăng ký tài khoản</title>
</head>
<body>
	<div>
		<h1>Registration</h1>
		<hr>

		<form action="register-form" method="post">
			<label><b>Username:</b></label> <input type="text"
				placeholder="Username" name="username" required="required">
			<label><b>Password</b></label> <input type="password"
				placeholder="Password" name="password" required="required">
			<label><b>Password Confirm</b></label> <input type="password"
				placeholder="Password Confirm" name="passwordConfirm"
				required="required">

			<button type="submit">Submit</button>
		</form>
	</div>
</body>
</html>