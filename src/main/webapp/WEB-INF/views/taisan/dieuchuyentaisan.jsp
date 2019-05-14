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
			<form class="forms-sample" action="/dcts" method="post">
				<div class="form-group">
					<label><b>Ngày:</b></label> <input class="form-control" type="text"
						name="dacdiem" required="required">
				</div>
				<div class="form-group">
					<label><b>Quản lý:</b></label> <input class="form-control"
						type="text" name="dacdiem" required="required">
				</div>
				<%-- <div class="form-group">
					<label><b>Danh Mục:</b></label> <select name="danhmuc">
						<c:forEach var="ltsDm" items="${lsDm }">
							<option value="${ltsDm.getId()}">${ltsDm.getName()}</option>
						</c:forEach>
					</select>
				</div> --%>
				 <div class="form-group">
					<label><b>Danh Mục:</b></label> <select name=tentaisan>
						<c:forEach var="ltsN" items="${lsN }">
							<option value="${ltsN.getId()}">${ltsN.getName()}</option>
						</c:forEach>
					</select>
				</div> 
				<div class="form-group">
					<label><b>Tài sản:</b></label> <select name="tentaisan">
						<c:forEach var="ltsTs" items="${lsTs }">
							<option value="${ltsTs.getId()}">${ltsTs.getTentaisan()}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<label><b>Ghi chú:</b></label>
					<textarea name="dacdiem"></textarea>
				</div>
				<div style="">
					<button type="submit" class="btn btn-add btn-sm">Chuyển</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>