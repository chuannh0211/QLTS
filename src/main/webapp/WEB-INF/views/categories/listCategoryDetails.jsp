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
			<h1 class="card-title">Chi tiết danh mục</h1>
			<button id="myBtn" class="btn btn-add btn-sm">Kết xuất</button>
			<table class="table center-aligned-table">
				<tr>
					<th>Id</th>
					<th>Tên tài sản</th>
					<th>Đặc điểm</th>
					<th>Trạng thái</th>
					<th>Giá trị thực</th>
					<th></th>
				</tr>
				<c:forEach var="ltsTs" items="${ltsTsById}">
					<tr>
						<td>${ltsTs.id }</td>
						<td>${ltsTs.tentaisan }</td>
						<td>${ltsTs.dacdiem }</td>
						<td>${ltsTs.trangthai }</td>
						<td>${ltsTs.giatrithuc }</td>
						<td></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>