<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div class="card">
	<div class="card-body">
		<hr>
		<form:form action="/category/edit-category" method="POST" modelAttribute="dm"
			class="forms-sample">
			<form:hidden path="id" />
			<div class="form-group">
				<label for="name"><b>Tên danh mục</b></label>
				<%-- <form:input path="name" class="form-control p-input" /> --%>
				<input type="text" value="${newDm.name }" name="name"
					class="form-control p-input" pattern="[A-Za-z0-9].{3,30}"
					title="Tên danh mục không ít hơn 3 kí tự " required>
			</div>
			<button type="submit" class="btn btn-add btn-sm">Sửa</button>
		</form:form>
	</div>
</div>
