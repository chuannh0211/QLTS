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
 <link rel="stylesheet" type="text/css" href="/css/style.css">
 <link rel="stylesheet" type="text/css" href="/css/customcss.css">
 
 <script type="text/javascript" src="/webjars/jquery/3.3.1/jquery.min.js/"></script>
 <script type="text/javascript" src="/webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body class="navbar-primary">
	<div class="container-scroller">
		<tiles:insertAttribute name="header" />
	<div class="container-fluid page-body-wrapper">
		<tiles:insertAttribute name="menu" />
   		<div class="content-wrapper">
			<tiles:insertAttribute name="body" />
		</div>
	</div>
		<tiles:insertAttribute name="footer" />
	</div>
	
    
    <script type="text/javascript" src="/node_modules/popper.js/dist/umd/popper.min.js"></script> 
    <script type="text/javascript" src="/node_modules/perfect-scrollbar/dist/js/perfect-scrollbar.jquery.min.js"></script>

    <script type="text/javascript" src="/js/off-canvas.js"></script>
    <script type="text/javascript" src="/js/hoverable-collapse.js"></script>
    <script type="text/javascript" src="/js/misc.js"></script> 
    
    
    <!--	Custom js  -->
    <script type="text/javascript" src="/js/myJs/customjs.js"></script> 
    <script type="text/javascript" src="/js/myJs/searchJs.js"></script> 

</body>
</html>