<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table class="table center-aligned-table">
	<tr>
		<th>STT</th>
		<th>Tên nhóm</th>
		<th>Tên PM</th>
	</tr>

	<tr>
		<td></td>
		<td>${gr.name }</td>
		<td>${gr.pm }</td>
		<td></td>
	</tr>
</table>
