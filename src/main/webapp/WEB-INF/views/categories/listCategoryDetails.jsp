<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="card">
	<div class="card-body">
		<a  href="<c:url value='/category/view-category-details/ketxuat/${idDanhMuc}'/>" class="btn btn-success">Kết xuất</a>
		<table class="table center-aligned-table">
			<tr>
				<th>STT</th>
				<th>Tên tài sản</th>
				<th>Đặc điểm</th>
				<th>Trạng thái</th>
				<th>Giá trị thực</th>
				<th></th>
			</tr>
			<c:set var="count" value="1" />
			<c:forEach var="ltsTs" items="${ltsTsById}">
				<tr>
					<td><c:out value="${count }"></c:out></td>
					<td>${ltsTs.tentaisan }</td>
					<td>${ltsTs.dacdiem }</td>
					<td>${ltsTs.trangthai }</td>
					<td>${ltsTs.giatrithuc }</td>
					<td></td>
				</tr>
			<c:set var="count" value="${count + 1}"></c:set>
			</c:forEach>
		</table>
	</div>
</div>
