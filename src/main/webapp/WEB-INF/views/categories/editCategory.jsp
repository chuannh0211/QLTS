<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div class="card">
	<div class="card-body">
		<h1 class="card-title">Thay đổi thông tin danh mục</h1>
		<hr>
		<form:form action="/edit-dsdm" method="POST" modelAttribute="dm"
			class="forms-sample">
			<form:hidden path="id" />
			<div class="form-group">
				<label for="name"><b>Name category</b></label>
				<form:input path="name" class="form-control p-input" />
			</div>


			<button type="submit" class="btn btn-add btn-sm">Sửa</button>
		</form:form>
	</div>
</div>