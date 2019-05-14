<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><tiles:insertAttribute name="title" /></title>
 <link rel="stylesheet" type="text/css" href="/node_modules/mdi/css/materialdesignicons.css">
 <link rel="stylesheet" type="text/css" href="/node_modules/perfect-scrollbar/dist/css/perfect-scrollbar.min.css">
 <link rel="stylesheet" type="text/css" href="/node_modules/font-awesome/css/font-awesome.min.css">
 <link rel="stylesheet" type="text/css" href="resources/static/css/style.css}">
</head>
<body>

	<tiles:insertAttribute name="header" />
	<br />
	<tiles:insertAttribute name="menu" />
	<br />
	<tiles:insertAttribute name="body" />
	<br />
	<tiles:insertAttribute name="footer" />

</body>
</html>