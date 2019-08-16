<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<form:form action="/dcts/view-details/sua-dctsX/${id_ts }" method="post"
	class="forms-sample" modelAttribute="dcts">
	<form:input type="hidden" path="id" />
	<div class="form-group">
		<label>Ngày điều chuyển: </label>
		<input type="text" value="${dcts.ngaydieuchuyen }" name="ngaydieuchuyen" class="form-control p-input disable">
	</div>
	<div class="form-group">
		<label>Người ghi: </label>
		<input type="text" value="${dcts.nguoiquanly }" name="nguoiquanly" class="form-control p-input disable">
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
