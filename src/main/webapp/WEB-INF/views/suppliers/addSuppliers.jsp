<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Add Supplier.</h1>
		<p>Please fill in this form to create a supplier.</p>
		<hr>
		<form action="add-supplier" method="post">
			<!--  -->
			<table>
				<tr>
					<td><label><b>Name Company</b></label></td>
					<td><input type="text" placeholder="Enter name company"
						name="tencongty" required="required"></td>
				</tr>
				<tr>
					<td><label><b>Company Code</b></label></td>
					<td><input type="text" placeholder="Enter code" name="tentat"
						required="required"></td>
				</tr>
				<tr>
					<td><label><b>Address</b></label></td>
					<td><input type="text" placeholder="Enter address"
						name="diachi" required="required"></td>
				</tr>
				<tr>
					<td><label><b>Phone Number</b></label></td>
					<td><input type="text" placeholder="Enter phone number"
						name="dienthoai" required="required"></td>
				</tr>
				<tr>
					<td><label><b>Email</b></label></td>
					<td><input type="text" placeholder="Enter email" name="email"
						required="required"></td>
				</tr>
				<tr>
					<td><label><b>Tax Code</b></label></td>
					<td><input type="text" placeholder="Enter tax code"
						name="masothue" ></td>
				</tr>
				<tr>
					<td><label><b>Surrogate</b></label></td>
					<td><input type="text" placeholder="Enter surrogate"
						name="nguoidaidien" required="required"></td>
				</tr>
				<tr>
					<td><label><b>IsCompany</b></label></td>
					<td><input type="radio" name="company" value="Company">Company
						<input type="radio" name="company" value="Personal">Personal
					</td>
				</tr>
				<tr>
					<td><button type="submit">Submit</button></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>