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
	<div class="card">
		<div class="card-body">
			<h1 class="card-title">Chi tiết điều chuyển</h1>
			<table class="table center-aligned-table">
				<tr>
					<th>Ngày điều chuyển</th>
					<th>Tên tài sản</th>
					<th>Quản lý</th>
					<th>Nhóm</th>
					<th>Ghi chú</th>
				</tr>
				<tr>
					<td>${dcts.ngaydieuchuyen }</td>
					<td>${dcts.getNameAsset()}</td>
					<td>${dcts.nguoiquanly }</td>
					<td>${dcts.nhom }</td>
					<td>${dcts.ghichu }</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>