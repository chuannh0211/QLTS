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
			<h1 class="card-title">Danh sách tài sản</h1>
			<button class="btn btn-add btn-sm open-modal">Thêm tài sản</button>
			<input type="text" class="form-control form-control-sm search-taisan"
				id="mySearch" onkeyup="myFunction()" placeholder="Tìm kiếm">
			<table class="table center-aligned-table" id="myTable">
				<tr>
					<th>STT</th>
					<th>Tên</th>
					<th>Đặc điểm</th>
					<th>Trạng thái</th>
					<th>Giá trị thực</th>
					<th>Danh mục</th>
					<th>Nhà cung cấp</th>
				</tr>
				<c:set var="count" value="1" />
				<c:forEach var="lsTs" items="${lsTs }">
					<tr>
						<td><c:out value="${count }"></c:out></td>
						<td>${lsTs.tentaisan }</td>
						<td>${lsTs.dacdiem }</td>
						<td>${lsTs.trangthai }</td>
						<td>${lsTs.giatrithuc }</td>
						<td>${lsTs.getNameDm() }</td>
						<td>${lsTs.getNameNcc() }</td>
						<td><a class="btn btn-view btn-sm"
							href="<c:url value='view-details/${lsTs.getId() }'/>">Xem</a> <%-- <a class="btn btn-primary btn-sm"
							href="<c:url value='edit-ts/${lsTs.id}'/>">Sửa</a> --%> <a
							class="btn btn-primary btn-sm open-modal-editAsset"
							id-tss="${lsTs.id }" href="javascript:void(0);">Sửa</a> &nbsp; <a
							class="btn btn-danger btn-sm"
							href="<c:url value='delete-ts/${lsTs.id}'/>">Xóa</a> &nbsp;</td>
					</tr>
					<c:set var="count" value="${count + 1}"></c:set>
				</c:forEach>
			</table>

			<div id="myModal" class="modal">
				<div class="modal-content">
					<div>
						<span class="closee">&times;</span>
					</div>
					<h4 class="modal-title sub-center">Thêm tài sản</h4>
					<form action="/add-ts" method="post" class="forms-sample">
						<div class="form-group">
							<label><b>Tên tài sản</b></label> <input pattern=".{8,}"
								title="Tên tài sản ít nhất phải có 8 kí tự!!!"
								class="form-control p-input" type="text"
								placeholder="Điền tên tài sản" name="tentaisan"
								required="required">
						</div>
						<div class="form-group">
							<label><b>Đặc điểm</b></label> <input
								class="form-control p-input" type="text"
								placeholder="Điền đặc điểm" name="dacdiem" required="required">
						</div>
						<div class="form-group">
							<label><b>Trạng thái</b></label> <br /> <input type="radio"
								name="trangthai" value="Tốt" checked="checked">Tốt <input
								type="radio" name="trangthai" value="Hỏng">Hỏng <input
								type="radio" name="trangthai" value="Thanh Lý">Thanh Lý
						</div>
						<%--   <div class="form-group">
							<label><b>Trạng thái</b></label>
							<select name="trangthai">
								<option value="${status1}">Tốt</option>
								<option value="${status2}">Hỏng</option>
								<option value="${status3}">Thanh lý</option>
							</select>
						</div>  --%>

						<div>
							<label><b>Giá trị thực:</b></label> <input
								class="form-control p-input" type="text" pattern="[0-9]"
								title="Không được nhập chữ!!!" placeholder="Giá trị thực"
								name="giatrithuc" required="required">
						</div>
						<div class="form-group">
							<label><b>Danh mục</b></label> <select name="danhmuc">
								<c:forEach var="ltsDm" items="${lsDm }">
									<option value="${ltsDm.getId()}">${ltsDm.getName()}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label><b>Nhà cung cấp</b></label> <select name="nhacungcap">
								<c:forEach var="ltsNcc" items="${lsNcc }">
									<option value="${ltsNcc.getId()}">${ltsNcc.getTencongty()}</option>
								</c:forEach>
							</select>
						</div>
						<div>
							<button type="submit" class="btn btn-add btn-sm">Thêm</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div id="myModal-editTs" class="modal">
		<div class="modal-content">
			<h4 class="card-title">Sửa thông tin tài sản</h4>
			<span class="closee">&times;</span>
			<div id="content_editAsset"></div>
		</div>
	</div>

</body>
</html>
