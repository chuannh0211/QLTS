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
			<input type="text" class="form-control form-control-sm search-taisan"
				id="mySearch" onkeyup="myFunction()" placeholder="Tìm kiếm">
			<table class="table center-aligned-table " id="myTable">
				<tr>
					<th>STT</th>
					<th>Tên danh mục</th>
					<th></th>
				</tr>
				<c:set var="count" value="1" />
				<c:forEach var="ls" items="${listDm}">
					<tr>
						<td><c:out value="${count }"></c:out></td>
						<td>${ls.getName()}</td>
						<td></td>
						<td>
							<a class="btn btn-view btn-sm open-modal-categoryDetails" id_categpry="${ls.id }"
							href="#">Xem</a>
							<a class="btn btn-primary btn-sm open-modal-editCategory" id_categpry="${ls.id }"
							href="#">Sửa</a> &nbsp; <a
							class="btn btn-danger btn-sm"
							href="<c:url value='delete-dsdm/${ls.getId() }'/>">Xóa</a> &nbsp;
							
						</td>
					</tr>
					<c:set var="count" value="${count + 1}"></c:set>
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
			<!-- view -->
			<div class="modal" id="modal-viewCategory">
				<div class="modal-content">
					<h2 class="modal-title">Chi tiết danh mục</h2>
					<span class="closee">&times;</span>
					<div id="content-categoryDetails"></div>
				</div>
			</div>
			<!-- finish -->
			<!-- edit -->
			<div class="modal" id="modal-editCategory">
				<div class="modal-content">
					<h2 class="modal-title">Sửa danh mục</h2>
					<span class="closee">&times;</span>
					<div id="content-editCategory"></div>
				</div>
			</div>
			<!-- finish -->
		</div>
	</div>
</body>
</html>