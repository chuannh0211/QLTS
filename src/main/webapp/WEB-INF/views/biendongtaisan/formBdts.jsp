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
	<h4 class="card-title">Biến động tài sản</h4>
	<form class="forms-sample" action="/add-bdts/${nTs.id}" method="post">
				
				 <div class="form-group row">
					<label><b>Ngày biến động:</b></label>
					<input type="text" class="form-control" name="ngaybiendong"
						value="${nTs.getDate() }" readonly>
				</div> 
				<div class="form-group row">
					<label><b>Người ghi:</b></label> <input class="form-control"
						type="text" name="nguoighi" value ="${pageContext.request.userPrincipal.name}" readonly>
				</div>
				<div class="form-group row">
					<label><b>Nhà cung cấp:</b></label>
					<input type="text"  class="form-control" name="nhacungcap" value="${nTs.getNameNcc() }" readonly>
				</div>
			<%-- 	<div class="form-group row">
					<label><b>Tài sản chính:</b></label>
					<input type="text" class="form-control" name="taisanchinh"
						value="${nTs.getTentaisan()}" readonly >
				</div>   --%>
				 <div class="form-group row">
					<label><b>Tài sản chính:</b></label> <select name="taisanchinh" >
						<option value="${nTs.getId()}" >${nTs.getTentaisan()}</option>
					</select>
				</div> 
				<div class="form-group row">
					<label><b>Tài sản biến động:</b></label>
					<input type="text" class="form-control" name="taisanbiendong" required>
				</div> 
				<div class="form-group row">
					<label><b>Trạng thái</b></label> <select name="trangthai">
						<option value="${value.trangthaiM}">Mua</option>
						<option value="${value.trangthaiSc}">Sửa chữa</option>
						<option value="${value.trangthaiTtb}">Thêm thiết bị</option>
						<option value="${value.trangthaiBtb}">Bỏ thiết bị</option>
						<option value="${value.trangthaiTL}">Thanh lý</option>
					</select>
				</div>
				<div class="form-group row">
					<label><b>Giá trị biến động:</b></label> 
					<input type="text" class="form-control" name="giatribiendong" required>
				</div>
				<div class="form-group row">
					<label><b>Bảo hành:</b></label> 
					<input type="text" class="form-control" name="baohanh" required>
				</div>
				<div class="form-group row">
					<label><b>Số hóa đơn:</b></label> 
					<input type="text" class="form-control" name="hoadon" required>
				</div>
				<div class="form-group row">
					<label><b>Ghi chú:</b></label>
					<textarea name="ghichu"></textarea>
				</div>
				<div>
					<button type="submit" class="btn btn-add btn-sm">Chuyển</button>
				</div>
			</form>
	</div>
</div>
	
</body>
</html>