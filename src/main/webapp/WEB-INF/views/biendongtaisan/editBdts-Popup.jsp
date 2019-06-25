<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="card">
	<div class="card-body">
		<form:form action="/view-details/form-sua-bdts/${id_ts }"
			class="forms-sample" modelAttribute="bdts" method="POST">
			<form:hidden path="id" />
			<input type="hidden" name="mataisan" value="${id_ts }">
			<input type="hidden" name="id_bdts" value="${id}">
			<div class="form-group">
				<label>Ngày biến động: </label> <input type="text"
					name="ngaybiendong" value="${nBdts.ngaybiendong }"
					class="form-control p-input disable">
			</div>
			<div class="form-group">
				<label>Người ghi: </label>
				<%-- <form:input path="nguoighi" class="form-control p-input" /> --%>
				<input type="text" name="nguoighi" value="${nBdts.nguoighi }"
					required pattern="[A-Za-z].{8,32}"
					title="Tên người ghi phải có 8 kí tự trở lên !!!"
					class="form-control p-input">
			</div>
			<div class="form-group">
				<label>Nhà cung cấp: </label>
				<%-- <form:input path="nhacungcap" class="form-control p-input disable" /> --%>
				<input type="text" name=nhacungcap value="${nBdts.nhacungcap }"
					required class="form-control p-input disable">
			</div>
			<div class="form-group">
				<label>Tài sản biến động: </label>
				<%-- <form:input path="taisanbiendong" class="form-control p-input " /> --%>
				<input type="text" name="taisanbiendong"
					value="${nBdts.taisanbiendong }" pattern="[A-Za-z0-9].{2,100}"
					title="Không được ít hơn 3 kí tự !!!" required
					class="form-control p-input ">
			</div>
			<div class="form-group">
				<label><b>Trạng thái</b></label>
				<form:radiobutton path="trangthai" value="Mua" label="Mua" />
				<form:radiobutton path="trangthai" value="Sửa chữa" label="Sửa chữa" />
				<form:radiobutton path="trangthai" value="Thêm thiết bị"
					label="Thêm thiết bị" />
				<form:radiobutton path="trangthai" value="Bỏ thiết bị"
					label="Bỏ thiết bị" />
				<form:radiobutton path="trangthai" value="Thanh lý" label="Thanh lý" />
			</div>
			<div class="form-group">
				<label>Giá trị biến động: </label>
				<%-- <form:input path="giatribiendong" class="form-control p-input " /> --%>
				<input type="text" name="giatribiendong" class="form-control p-input"
					value="${nBdts.giatribiendong }" required pattern="[0-9]"
					title="Không được nhập kí tự chữ !!!">
			</div>
			<div class="form-group">
				<label>Bảo hành: </label>
				<%-- <form:input path="thoigianbaohanh" class="form-control p-input " /> --%>
				<input class="form-control p-input type="text" name="thoigianbaohanh"
					value="${nBdts.thoigianbaohanh }" required
					pattern="[0-9](+)[A-Za-z](+).{6,}"
					title="Không được ít hơn 6 kí tự !!!">
			</div>
			<div class="form-group">
				<label>Số hóa đơn: </label>
				<%-- <form:input path="sohoadon" class="form-control p-input " /> --%>
				<input class="form-control p-input type="text" name="sohoadon" value="${nBdts.sohoadon }"
					required pattern="[A-Za-z0-9].{9,20}" title="Không được ít hơn 10 kí tự !!!">
			</div>
			<div class="form-group">
				<label>Ghi chú: </label>
				<form:textarea path="ghichu" />
			</div>
			<div>
				<button type="submit" class="btn btn-add btn-sm">Sửa</button>
			</div>
		</form:form>
	</div>
</div>