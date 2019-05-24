<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="card">
	<div class="card-body">
		<hr>
		<form:form action="/edit-dsn" method="POST" modelAttribute="gr"
			class="forms-sample">
			<div>
				<form:hidden path="id" />
			</div>
			<div class="form-group">
				<label><b>Tên nhóm</b></label>
				<%-- <form:input path="name" class="form-control p-input" /> --%>
				<input type="text" value="${gr.name }" name="name" class="form-control p-input"
					pattern="^[A-Za-z0-9].{5,25}$" title="Tên nhóm ít nhất chưa 5 kí tự !!!">

			</div>
			<div class="form-group">
				<label><b>Tên PM</b></label>
				<%-- <form:input path="pm" class="form-control p-input" /> --%>
				<input type="text" value="${gr.pm }" name="pm" class="form-control p-input"
					pattern="^[A-Za-z].{5,25}$" title="Tên PM ít nhất chưa 5 kí tự !!!">
			</div>
			<button type="submit" class="btn btn-add btn-sm">Sửa</button>
		</form:form>
	</div>
</div>