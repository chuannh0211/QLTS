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
			<h1 class="card-title">Chi tiết tài sản</h1>
			<table class="table center-aligned-table">
				<tr>
					<th>STT</th>
					<th>Tên tài sản</th>
					<th>Đặc điểm</th>
					<th>Trạng thái</th>
					<th>Giá trị thực</th>
					<th>Danh mục</th>
					<!-- <th>Nhà cung cấp</th> -->
				</tr>
				<tr>
					<td>${ts.id }</td>
					<td>${ts.tentaisan }</td>
					<td>${ts.dacdiem }</td>
					<td>${ts.trangthai }</td>
					<td>${ts.giatrithuc }</td>
					<td>${ts.getNameDm()}</td>
				<%--<td>${ts.getNameNcc() }</td>--%>
					<td></td>
				</tr>
			</table>
			<h2 class="card-sub-title">Chi tiết điều chuyển</h2>
			<a class="btn btn-add btn-sm"
				href="/form-dcts/${ts.id}">Điều
				chuyển tài sản</a>
			<table class="table center-aligned-table">
				<tr>
					<th>STT</th>
					<th>Ngày điều chuyển</th>
					<th>Tên tài sản</th>
					<th>Người ghi</th>
					<th>Nhóm</th>
					<th>Ghi chú</th>
				</tr>
		
			    <c:forEach var="ltsDcts" items="${ltsDcts }"> 
					<tr>
						<td>${ltsDcts.id }</td>
						<td>${ltsDcts.ngaydieuchuyen }</td>
						<td>${ltsDcts.getNameAsset()}</td>
						<td>${ltsDcts.nguoiquanly }</td>
						<td>${ltsDcts.getGruopAsset() }</td>
						<td>${ltsDcts.ghichu }</td>
						<td><a class="btn btn-primary btn-sm open-modal" id-dcts="${ltsDcts.id}" href="#">Sửa</a> &nbsp;
							  <a class="btn btn-primary btn-sm" href="<c:url value='sua-dcts/${ltsDcts.id}'/>">Sửa</a> &nbsp; 
							<a class="btn btn-danger btn-sm" href="<c:url value='xoa-dcts?id=${ltsDcts.id}&idts=${ts.id}'/>">Xóa</a>&nbsp; 
							</td>
					</tr>
			  	 </c:forEach>    
			</table>
			<h2 class="card-sub-title">Biến động tài sản</h2>
			 <a class="btn btn-add btn-sm"
				href="/form-bdts/${ts.id}">Biến động tài sản</a> 
			<table class="table center-aligned-table">
				<tr>
					<th>STT</th>
					<th>Ngày biến động</th>
					<th>Người ghi</th>
					<th>Tài sản chính</th>
					<th>Tài sản biến động</th>
					<th>Trạng thái</th>
					<th>Giá trị biến động</th>
					<th>Bảo hành</th>
					<th>Nhà cung cấp</th>
					<th>Hóa đơn</th>
					<th>Ghi chú</th>
				</tr>
			 <c:forEach var="ltsBdts" items="${ltsBdts }"> 
				<tr>
					<td>
							<c:set var="count" value="1"/>
							<c:forEach var="countt" items="${count }" >
							<c:out value="${countt}" />	
							</c:forEach>
							
					</td> 
					<td>${ltsBdts.getNgaybiendong() }</td>
					<td>${ltsBdts.getNguoighi() }</td>
					<td>${ltsBdts.getTentaisan() }</td>
					<td>${ltsBdts.getTaisanbiendong() }</td>
					<td>${ltsBdts.getTrangthai() }</td>
					<td>${ltsBdts.getGiatribiendong()}</td>
					<td>${ltsBdts.getThoigianbaohanh() }</td>
					<td>${ts.getNameNcc() }</td>
					<td>${ltsBdts.getSohoadon()}</td>
					<td>${ltsBdts.getGhichu()}</td>
					<td><%-- <a class="btn btn-primary btn-sm open-modal" id-dcts="${ltsBdts.id}" href="#">Sửa</a> &nbsp; --%>
							<a class="btn btn-primary btn-sm" href="<c:url value='form-sua-bdts/${ltsBdts.id}'/>">Sửa</a> &nbsp;
							<a class="btn btn-danger btn-sm" href="<c:url value='xoa-bdts?id=${ltsBdts.id}&idts=${ts.id}'/>">Xóa</a>&nbsp;
							</td>
				</tr>
			</c:forEach>
			</table>
		</div>
	</div>
	<!-- form popup sửa -->
	<div id="myModal" class="modal">
		<div class="modal-content">
			<h4 class="card-title">Sửa thông tin điều chuyển</h4> 
			<span class="closee">&times;</span>
			<div id="content_modal">
				
			</div>	
		</div>
	</div>
	<script type="text/javascript">
	jQuery(document).ready(function(){
		jQuery(".open-modal").click(function() {
			var id_dcts = jQuery(this).attr("id-dcts");
			// console.log(id_dcts);
			jQuery.ajax({
				url : 'sua-dctsX/' + id_dcts,// 1
				success : function(data) {
					jQuery("#content_modal").html(data);
				}
			});
		});
	});
	</script>
</body>
</html>