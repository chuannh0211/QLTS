<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<meta charset="utf-8">
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
			</tr>
			<c:choose>
				<c:when test="${listDm.size() > 0 }">
					<c:set var="count" value="1" />
					<c:forEach var="listDm" items="${listDm}">
						<tr>
							<td><c:out value="${count }"></c:out></td>
							<td>${listDm.getName()}</td>
							<td></td>
							<td><a
								class="btn btn-view btn-sm open-modal-categoryDetails"
								id_categpry="${listDm.id }" href="javascript:void(0);">Xem</a> <a
								class="btn btn-primary btn-sm open-modal-editCategory"
								id_categpry="${listDm.id }" href="javascript:void(0);">Sửa</a>
								&nbsp; <a class="btn btn-danger btn-sm"
								href="<c:url value='delete-dsdm/${listDm.getId() }'/>">Xóa</a>
								&nbsp;</td>
						</tr>
						<c:set var="count" value="${count + 1}"></c:set>
					</c:forEach>
				</c:when>
			</c:choose>
		</table>
		<!-- phân trang -->
		<div class="row">
			<div class="col-sm-12 col-md-5">
				<div class="dataTables_info">Showing ${number + 1} to ${size }
					of ${totalElement}</div>
			</div>
			<div class="col-sm-12 col-md-7">
				<div class="dataTables_paginate paging_simple_numbers">
					<ul class="pagination">
						<c:forEach begin="0" end="${totalPages -1 }" var="page">
							<li class="paginate_button page-item"><a class="page-link"
								href="javascript:void(0);"
								onclick="pagination(${page}, ${size})">${page + 1 }</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
		<!-- Modal -->
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
