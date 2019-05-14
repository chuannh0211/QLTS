<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
</head>
<body>
	<div class="card">
		<div class="card-body">
			<h1 class="card-title">Danh sách nhóm</h1>
			<%-- <a href="${pageContext.request.contextPath}/add-group">Add new
			group here!!!</a> --%>
			<button id="myBtn" class="btn btn-add btn-sm">Thêm nhóm mới</button>
			<table class="table center-aligned-table">
				<tr>
					<th>ID</th>
					<th>Tên nhóm</th>
					<th>Tên PM</th>
					<th></th>
				</tr>
				<c:forEach var="ls" items="${list }">
					<tr>
						<td>${ls.id }</td>
						<td>${ls.getName() }</td>
						<td>${ls.getPm() }</td>
						<td><a class="btn btn-primary btn-sm"
							href="<c:url value='edit-dsn/${ ls.getId()}'/>">Sửa</a> &nbsp; <a
							class="btn btn-danger btn-sm"
							href="<c:url value='delete-dsn/${ls.id }'/>">Xóa</a> &nbsp; <a
							class="btn btn-view btn-sm"
							href="<c:url value='view-group-details/${ls.id }'/>">Xem</a></td>
					</tr>
				</c:forEach>
			</table>
			<div id="myModal" class="modal">
				<div class="modal-content">
					<div>
						<span class="closee">&times;</span>
					</div>
					<form action="/add-dsn" method="post" class="forms-sample">
						<div class="form-group">
							<label><b>Tên nhóm:</b></label> <input
								class="form-control p-input" type="text" name="name"
								placeholder="Tên nhóm" required="required">
						</div>
						<div class="form-group">
							<label><b>Tên PM:</b></label> <input class="form-control p-input"
								type="text" name="pm" placeholder="Tên PM" required="required">
						</div>

						<button type="submit" class="btn btn-add btn-sm">Thêm</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>