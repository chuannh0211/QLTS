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
			<h4 class="modal-title">Sửa thông tin điều chuyển</h4>
			<form:form action="/view-details/sua-dctsX/${id_ts }"
				class="forms-sample" modelAttribute="dcts" method="POST">
				<form:hidden path="id" />
				<div class="form-group">
					<label>Ngày điều chuyển: </label>
					<form:input path="ngaydieuchuyen"
						class="form-control p-input disable" />
				</div>
				<div class="form-group">
					<label>Người ghi: </label>
					<form:input path="nguoiquanly" class="form-control p-input" />
				</div>
				<div class="form-group">
					<label>Nhóm: </label> <select name="nhom">
						<option></option>
						<c:forEach var="listNhom" items="${listNhom }">
							<option <c:if test="${newN==listNhom.getId()}">selected</c:if>
								value="${listNhom.getId()}">${listNhom.getName() }</option>
						</c:forEach>
					</select>
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
</body>
</html>