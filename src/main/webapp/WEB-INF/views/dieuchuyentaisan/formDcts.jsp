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
			<h1 class="card-title">Điều chuyển tài sản</h1>
			<form class="forms-sample" action="/add-dcts/${tsDcts.id}" method="post">
				 <div class="form-group">
					<label><b>Ngày điều chuyển:</b></label>
					<input type="text" class="form-control" name="ngaydieuchuyen"
						value="${tsDcts.getDate() }" readonly>
				</div> 
				<%-- <div class="form-group">
					<label><b>Tài sản:</b></label>
					<input type="text" class="form-control" name="tentaisan"
						value="${tsDcts.getTentaisan()}" readonly >
				</div> --%>  
				 <div class="form-group">
					<label><b>Tài sản:</b></label> <select name="tentaisan" >
						<option value="${tsDcts.getId()}" >${tsDcts.getTentaisan()}</option>
					</select>
				</div> 
				<div class="form-group">
					<label><b>Người ghi:</b></label> <input class="form-control"
						type="text" name="nguoiquanly" required="required"
						value ="${pageContext.request.userPrincipal.name}" readonly	
						>
				</div>
				<div class="form-group">
					<label><b>Nhóm:</b></label> <select name="nhom">
						<option value="0"></option>
						<c:forEach var="ltsN" items="${lsN }">
							<option value="${ltsN.getId()}">${ltsN.getName()}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<label><b>Ghi chú:</b></label>
					<textarea name="ghichu"></textarea>
				</div>
				<%-- <div class="form-group">
					<label><b>Danh Mục:</b></label> <select name="danhmuc">
						<c:forEach var="ltsDm" items="${lsDm }">
							<option value="${ltsDm.getId()}">${ltsDm.getName()}</option>
						</c:forEach>
					</select>
				</div> --%>
				<%-- <div class="form-group">
					<label><b>Tài sản:</b></label> <select name="tentaisan">
						<c:forEach var="ltsTs" items="${lsTs }">
							<option value="${ltsTs.getId()}">${ltsTs.getTentaisan()}</option>
						</c:forEach>
					</select>
				</div> --%>
				<div>
					<a class="btn btn-add btn-sm back" href="/asset/view-details/${tsDcts.id}">Hủy</a>
					<button type="submit" class="btn btn-add btn-sm">Chuyển</button>
				</div>
			</form>
		</div>
	</div>

</body>
</html>
