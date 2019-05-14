<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Add New Group</title>
</head>
<body>
	<div align="center">
		<h1>Add New Group</h1>
		<p>Please fill in this form to create a group.</p>
		<hr>
		<form action="add-group" method="post">
			<label><b>Name Group</b></label> <input type="text"
				placeholder="Enter name group" name="name" required="required">
			<label><b>Name PM</b></label> <input type="text"
				placeholder="Enter name pm" name="pm" required="required">

			<button type="submit">Submit</button>
		</form>
	</div>
</body>
</html>