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
			<h1 class="card-title">Danh sách danh mục</h1>
			<%-- <a href="${pageContext.request.contextPath}/add-category">Add
			Category</a> --%>
			<button id="myBtn" class="btn btn-add btn-sm">Thêm danh mục</button>
			<table class="table center-aligned-table ">
				<tr>
					<th>ID</th>
					<th>Tên danh mục</th>
					<th></th>
				</tr>
				<c:forEach var="ls" items="${listDm}">
					<tr>
						<td>${ls.getId()}</td>
						<td>${ls.getName()}</td>
						<td></td>
						<td><a class="btn btn-primary btn-sm"
							href="<c:url value='edit-dsdm/${ls.getId() }'/>">Sửa</a> &nbsp; <a
							class="btn btn-danger btn-sm"
							href="<c:url value='delete-dsdm/${ls.getId() }'/>">Xóa</a> &nbsp;
							<a class="btn btn-view btn-sm"
							href="<c:url value='view-category-details/${ls.getId() }'/>">Xem</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<div id="myModal" class="modal">
				<div class="modal-content">
					<div>
						<span class="closee">&times;</span>
					</div>
					<form action="/add-dsdm" method="post" class="forms-sample">
						<div class="form-group">
							<label for="name"><b>Tên danh mục</b></label> <input
								class="form-control p-input" type="text"
								placeholder="Tên danh mục" name="name" required>
						</div>
						<div>
							<button type="submit" class="btn btn-add btn-sm">Thêm</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>