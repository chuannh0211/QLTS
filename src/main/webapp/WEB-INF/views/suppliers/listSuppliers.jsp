<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
</head>
<body>
	<div class="card">
		<div class="card-body">
			<h1 class="card-title">Danh sách nhà cung cấp</h1>
			<%-- <a href="${pageContext.request.contextPath }/add-supplier">Add New
			Supplier</a> --%>
			<button id="myBtn" class="btn btn-add btn-sm">Thêm nhà cung
				cấp</button>
			<input type="text" class="form-control form-control-sm search-taisan"
				id="mySearch" onkeyup="myFunction()" placeholder="Tìm kiếm">
			<table class="table center-aligned-table" id="myTable">
				<tr>
					<th>STT</th>
					<th>Tên công ty</th>
					<th>Mã công ty</th>
					<th>Địa chỉ</th>
					<th>Số điện thoại</th>
					<th>Email</th>
					<th>Mã số thuế</th>
					<th>Người đại diện</th>
					<th>Công ty/Cá nhân</th>
					<th></th>
				</tr>
				<c:set var="count" value="1" />
				<c:forEach var="ls" items="${list }">
					<tr>
						<td><c:out value="${count }"></c:out></td>
						<td>${ls.tencongty }</td>
						<td>${ls.tentat }</td>
						<td>${ls.diachi }</td>
						<td>${ls.dienthoai }</td>
						<td>${ls.email }</td>
						<td>${ls.masothue }</td>
						<td>${ls.nguoidaidien }</td>
						<td>${ls.company }</td>
						<td><a class="btn btn-view btn-sm open-modal-suppDetails"
							id-ncc=${ls.id } href="#">Xem</a> <a
							class="btn btn-primary btn-sm open-modal-editSupp"
							id-ncc=${ls.id } href="#">Sửa</a> &nbsp; <a
							class="btn btn-danger btn-sm"
							href="<c:url value='delete-ncc/${ls.id}' />">Xóa</a> &nbsp;</td>
					</tr>
					<c:set var="count" value="${count + 1}"></c:set>
				</c:forEach>
			</table>
			<div id="myModal" class="modal">
				<div class="modal-content">
					<div>
						<span class="closee">&times;</span>
					</div>
					<form action="/add-ncc" method="POST" class="forms-sample">
						<div class="form-group">
							<label><b>Tên công ty</b></label> <input type="text"
								class="form-control p-input" placeholder="Tên công ty"
								name="tencongty" required="required">
						</div>
						<div class="form-group">
							<label><b>Mã công ty</b></label> <input type="text"
								class="form-control p-input" placeholder="Mã công ty"
								name="tentat" required="required">
						</div>
						<div class="form-group">
							<label><b>Địa chỉ</b></label> <input type="text"
								class="form-control p-input" placeholder="Địa chỉ" name="diachi"
								required="required">
						</div>
						<div class="form-group">
							<label><b>Số điện thoại</b></label> <input type="text"
								class="form-control p-input" placeholder="Số điện thoại"
								name="dienthoai" required="required">
						</div>
						<div class="form-group">
							<label><b>Email</b></label> <input type="text"
								class="form-control p-input" placeholder="Email" name="email"
								required="required">
						</div>
						<div class="form-group">
							<label><b>Mã số thuế</b></label> <input type="text"
								class="form-control p-input" placeholder="Mã số thuế"
								name="masothue">
						</div>
						<div class="form-group">
							<label><b>Người đại diện</b></label> <input type="text"
								class="form-control p-input" placeholder="Người đại diên"
								name="nguoidaidien" required="required">
						</div>
						<div class="form-group">
							<label><b>IsCompany</b></label> <input type="radio"
								name="company" value="Công ty">Công ty <input
								type="radio" name="company" value="Cá nhân">Cá nhân
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-add btn-sm">Thêm</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- start popup -->
	<div class="modal" id="modal-suppDetails">
		<div class="modal-content">
			<h2 class="modal-title">Chi tiết nhà cung cấp</h2>
			<span class="closee">&times;</span>
			<div id="content-suppliers"></div>
		</div>
	</div>
	<!-- finish -->
	<!-- start popup -->
	<div class="modal" id="modal-editSupplier">
		<div class="modal-content">
			<h2 class="modal-title">Thay đổi thông tin tài sản</h2>
			<span class="closee">&times;</span>
			<div id="content-editSupplier"></div>
		</div>
	</div>
	<!-- finish -->
</body>
</html>