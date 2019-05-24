<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="card">
	<div class="card-body">
		<form:form action="/edit-ts/${id_ts}" method="POST"
			modelAttribute="ts" class="form-sample">
			<div class="form-group">
				<form:hidden path="id" />
			</div>
			<div class="form-group">
				<label><b>Tên tài sản</b></label> <input type="text"
					value="${ts.tentaisan }" class="form-control p-input"
					name="tentaisan" required pattern=".{8,}" title="Tên tài sản ít nhất 8 kí tự !!!">
			</div>
			<div class="form-group">
				<label><b>Đặc điểm</b></label> <input type="text"
					value="${ts.dacdiem }" class="form-control p-input" name="dacdiem" required>
			</div>
			<div class="form-group">
				<label><b>Trạng thái</b></label>
				<form:radiobutton path="trangthai" value="Tốt" label="Tốt" />
				<form:radiobutton path="trangthai" value="Hỏng" label="Hỏng" />
				<form:radiobutton path="trangthai" value="Thanh lý" label="Thanh lý" />
			</div>
			<%-- 	<div class="form-group">
					<label><b>Trạng thái</b></label>
					<form:select path="trangthai" >
        				<form:option value="${status1}" label="Tốt"/>
						<form:option value="${status2}" label="Hỏng"/>
						<form:option value="${status3}" label="Thanh lý"/>
        			</form:select>
				</div>   --%>

			<div class="form-group">
				<label><b>Danh mục</b></label> <select name="danhmuc">
					<c:forEach var="ltsDm" items="${lsDm }">
						<option <c:if test="${newDm == ltsDm.getId()}">selected </c:if>
							value="${ltsDm.getId()}">${ltsDm.getName()}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label><b>Nhà cung cấp</b></label> <select name="nhacungcap">
					<c:forEach var="ltsNcc" items="${lsNcc }">
						<option <c:if test="${newNcc == ltsNcc.getId()}">selected </c:if>
							value="${ltsNcc.getId()}">${ltsNcc.getTencongty()}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label><b>Giá trị thực</b></label> <input type="text"
					value="${ts.giatrithuc }" class="form-control p-input"
					name="giatrithuc" required pattern="[0-9]" title="Không được nhập chữ !!!">
			</div>



			<%-- <tr>
					<td><label><b>Danh mục</b></label></td>
					<td><form:input path="danhmuc" /></td>
				</tr>
				<tr>
					<td><label><b>Nhà cung cấp</b></label></td>
					<td><form:input path="nhacungcap" /></td>
				</tr> --%>

			<button type="submit" class="btn btn-add btn-sm">Sửa</button>

		</form:form>
	</div>
</div>