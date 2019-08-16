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
			<input type="text" class="form-control form-control-sm search-taisan"
				id="mySearch" onkeyup="myFunction()" placeholder="Tìm kiếm">
			<table class="table center-aligned-table" id="myTable">
				<tr>
					<th>STT</th>
					<th>Tên nhóm</th>
					<th>Tên PM</th>
					<th></th>
				</tr>
				<c:set var="count" value="1" />
				<c:forEach var="ls" items="${list }">
					<tr>
						<td><c:out value="${count }"></c:out></td>
						<td>${ls.getName() }</td>
						<td>${ls.getPm() }</td>
						<td><a class="btn btn-view btn-sm opan-modal-viewDetails"
							id-nhom="${ls.id }" href="javascript:void(0);">Xem</a> 
							<a class="btn btn-primary btn-sm opan-modal-editGroup" id-nhom="${ls.id }" href="javascript:void(0);">Sửa</a> &nbsp; 
							<a class="btn btn-danger btn-sm"  href="<c:url value='delete-group/${ls.id }'/>">Xóa</a> &nbsp;
							</td>
					</tr>
					<c:set var="count" value="${count + 1}"></c:set>
				</c:forEach>
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
									onclick="paginationGroup(${page}, ${size})">${page + 1 }</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
			<div id="myModal" class="modal">
				<div class="modal-content">
					<div>
						<span class="closee">&times;</span>
					</div>
					<form action="/group/add-group" method="post" class="forms-sample">
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
			<!-- finish -->
			<!-- view -->
			<div id="myModal-groupInfo" class="modal">
				<div class="modal-content">
					<h2 class="modal-title">Thông tin nhóm</h2>
					<span class="closee">&times;</span>
					<div id="content-groupDetails"></div>
				</div>
			</div>
			<!-- finish -->
			<!-- edit -->
			<div id="myModal-editGroup" class="modal">
				<div class="modal-content">
					<h2 class="modal-title">Sửa thông tin nhóm</h2>
					<span class="closee">&times;</span>
					<div id="content-editGroup"></div>
				</div>
			</div>
			<!-- finish -->
		</div>
	</div>
</body>
</html>