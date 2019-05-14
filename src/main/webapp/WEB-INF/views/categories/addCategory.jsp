<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Add Category</title>
</head>
<body>
	<div align="center">
		<h1>Add Category</h1>
		<p>Please fill in this form to create a category.</p>
		<hr>
		<form action="add-category" method="post">
			<label for="name"><b>Name category</b></label> <input type="text"
				placeholder="Enter name category" name="name" required>

			<button type="submit">Submit</button>
		</form>
	</div>
</body>
</html>
