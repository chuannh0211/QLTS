<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="card">
	<div class="card-body">
		<table class="table center-aligned-table">
			<tr>
				<!-- <th>Tên công ty</th> -->
				<th>Mã công ty</th>
				<!-- <th>Địa chỉ</th> -->
				<!-- <th>Số điện thoại</th> -->
				<!-- <th>Email</th> -->
				<th>Mã số thuế</th>
				<th>Người đại diện</th>
				<th>Công ty/Cá nhân</th>
			</tr>
			<tr>
				<%-- <td>${newNcc.tencongty }</td> --%>
				<td>${newNcc.tentat }</td>
				<%-- <td>${newNcc.diachi }</td>
				<td>${newNcc.dienthoai }</td>
				<td>${newNcc.email }</td> --%>
				<td>${newNcc.masothue }</td>
				<td>${newNcc.nguoidaidien }</td>
				<td>${newNcc.company }</td>
				<td></td>
			</tr>
		</table>
	</div>
</div>