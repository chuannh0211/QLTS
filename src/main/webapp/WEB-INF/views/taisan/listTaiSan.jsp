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
			<h1 class="card-title">Danh sách tài sản</h1>
			<button id="myBtn" class="btn btn-add btn-sm">Thêm tài sản</button>
			<a class="btn btn-add btn-sm"
				href="${pageContext.request.contextPath }/dcts">Điều chuyển tài
				sản</a>
			<table class="table center-aligned-table">
				<tr>
					<th>ID</th>
					<th>Tên</th>
					<th>Đặc điểm</th>
					<th>Trạng thái</th>
					<th>Giá trị thực</th>
					<th>Danh mục</th>
					<th>Nhà cung cấp</th>
				</tr>
				<c:forEach var="ls" items="${lsTs }">
					<tr>
						<td>${ls.getId() }</td>
						<td>${ls.tentaisan }</td>
						<td>${ls.dacdiem }</td>
						<td>${ls.trangthai }</td>
						<td>${ls.giatrithuc }</td>
						<td>${ls.getNameDm() }</td>
						<td>${ls.getNameNcc() }</td>
						<td><a class="btn btn-primary btn-sm"
							href="<c:url value='edit-ts/${ls.id}'/>">Sửa</a> &nbsp; <a
							class="btn btn-danger btn-sm"
							href="<c:url value='delete-ts/${ls.id}'/>">Xóa</a> &nbsp; <a
							class="btn btn-view btn-sm"
							href="<c:url value='view-taisan-details/${id}'/>">Xem</a></td>
					</tr>
				</c:forEach>
			</table>

			<div id="myModal" class="modal">
				<div class="modal-content">
					<div>
						<span class="closee">&times;</span>
					</div>
					<!-- 	<h4 class="modal-title">Thêm tài sản</h4> -->
					<form action="/add-ts" method="post" class="forms-sample">
						<div class="form-group">
							<label><b>Tên tài sản</b></label> <input
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
							<label><b>Trạng thái</b></label> <br /> <input
								style="padding: 0 10px;" type="radio" name="trangthai"
								value="Tốt">Tốt <input type="radio" name="trangthai"
								value="Hỏng">Hỏng <input type="radio" name="trangthai"
								value="Thanh Lý">Thanh Lý
						</div>
						<!-- <div>
								<label><b>Trạng thái</b></label> <select name="trangthai">
									<option value="Tốt">Tốt</option>
									<option value="Hỏng" selected="selected">Hỏng</option>
									<option value="Thanh lý">Thanh lý</option>
								</select>
							</div> -->
						<!-- <div>
							<label><b>Danh mục</b></label> <input
								class="form-control p-input" type="text"
								placeholder="Điền danh mục" name="danhmuc" required="required">
						</div> -->
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
						<!-- <div>
							<label><b>Nhà cung cấp</b></label> <input
								class="form-control p-input" type="text"
								placeholder="Điền nhà cung cấp" name="nhacungcap"
								required="required">
						</div> -->
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
