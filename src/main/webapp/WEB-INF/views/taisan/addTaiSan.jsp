<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Add tài sản</title>
</head>
<body>
	<div align="center">
		<h1>Thêm tài sản</h1>
		<p>Please fill in this form to create a taisan.</p>
		<hr>
		<form action="/add-taisan" method="post">
			<!--  -->
			<table>
				<tr>
					<td><label><b>Tên tài sản</b></label></td>
					<td><input type="text" placeholder="Điền tên tài sản"
						name="tentaisan" required="required"></td>
				</tr>
				<tr>
					<td><label><b>Đặc điểm</b></label></td>
					<td><input type="text" placeholder="Điền đặc điểm"
						name="dacdiem" required="required"></td>
				</tr>
				<tr>
					<td><label><b>Trạng thái</b></label></td>
					<td><input type="radio" name="trangthai" value="Tốt">Tốt
						<input type="radio" name="trangthai" value="Hỏng">Hỏng <input
						type="radio" name="trangthai" value="Thanh Lý">Thanh Lý</td>
				</tr>
				<tr>
					<td><label><b>Giá trị thực</b></label></td>
					<td><input type="text" placeholder="Điền giá trị thực"
						name="giatrithuc" required="required"></td>
				</tr>
				<tr>
					<td><button type="submit">Submit</button></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>