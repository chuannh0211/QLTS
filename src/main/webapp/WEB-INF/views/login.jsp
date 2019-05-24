<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Đăng nhập</title>
<link rel="stylesheet" type="text/css"
	href="/node_modules/mdi/css/materialdesignicons.css">
<link rel="stylesheet" type="text/css"
	href="/node_modules/perfect-scrollbar/dist/css/perfect-scrollbar.min.css">
<link rel="stylesheet" type="text/css"
	href="/node_modules/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="stylesheet" type="text/css" href="/css/customcss.css">

<script type="text/javascript"
	src="/webjars/jquery/3.3.1/jquery.min.js/"></script>
</head>
<body>
	<div class="container-scroller">
		<div class="container-fluid page-body-wrapper">
			<div class="row">
				<div
					class="content-wrapper full-page-wrapper d-flex align-items-center auth-pages">
					<div class="card col-lg-4 mx-auto">
						<div class="card-body px-5 py-5">
							<div class="text-center">
								<img src="/images/logo.jpg" alt="Default Spring Application"
									width="35%;">
							</div>
							<h1 class="text-center text-uppercase">Đăng nhập</h1>
							<h3>${message}</h3>
							<hr>

							<form action="/login" method="post">
								<div class="form-group">
									<label><b>Tài Khoản</b> </label> <input type="text"
										name="uname" required="required" class="form-control p_input"
										placeholder="Nhập tên tài khoản">
								</div>
								<div class="form-group">
									<label><b>Mật Khẩu</b></label> <input type="password" name="pw"
										required="required" class="form-control p_input"
										placeholder="Nhập mật khẩu">
								</div>
								<div
									class="form-group d-flex align-items-center justify-content-between">
									<label class="form-check-label"> <input type="checkbox"
										checked="checked" name="remember" class="form-check-input">Remember
										me
									</label>
								</div>
								<div class="forgot-pass">
									<%-- <a id="myId" href="${contextPath }/register-form">Đăng Ký</a> --%>
									<a class="label-signup open-modal" href="#">Đăng Ký</a>
								</div>
								<button type="submit"
									class="btn btn-primary btn-block enter-btn">Đăng nhập</button>
							</form>

						</div>
						<div id="myModal" class="modal">
							<div class="modal-content">
								<div>
									<span class="closee">&times;</span>
								</div>
								<form action="/register-form" method="post" onsubmit="return validateForm()">
									<div class="form-group">
										<label><b>Tài khoản:</b></label> <input pattern="^[a-z0-9._-]{3,15}$" 
          								    title="Tài khoản từ 3-15 kí tự"
											class="form-control p_input" type="text"
											placeholder="Nhập tài khoản" name="username"
											required="required">
									</div>
									<div class="form-group">
										<label><b>Mật khẩu:</b></label> <input pattern="^[a-z0-9]{3,15}$"
											title="Sai định dạng"
											class="form-control p_input" type="password"
											placeholder="Nhập mật khẩu" name="password"
											required="required">
									</div>
									<div class="form-group">
										<label><b>Nhập lại mật khẩu:</b></label> <input pattern="^[a-z0-9]{3,15}$"
											title="Mật khẩu nhập lại phải giống mật khẩu"
											class="form-control p_input" type="password"
											placeholder="Xác nhận mật khẩu" name="passwordConfirm"
											required="required">
									</div>
									<div class="form-group">
										<label><b>Họ tên:</b></label> <input
											class="form-control p_input" type="text" pattern="^[A-Za-z]{20,50}$" 
											title="Sai định dạng"
											placeholder="Nhập họ tên" name="fullname" required="required">
									</div>
									<div class="form-group">
										<label><b>Email:</b></label> <input
											class="form-control p_input" type="text" pattern=".{10,}" pattern="^([a-zA-z0-9]+)@([a-z]+)(\.+)[a-z]{2,5}$"  
											  title="Định dạng email không đúng !!!"
											placeholder="Nhập email" name="email" required="required">
									</div>
									<div class="form-group">
										<label><b>Số điện thoại:</b></label> <input  pattern="[0-9]{10}"
											title="Số điện thoại phải là số và có 10 kí tự"
											class="form-control p_input" type="text"
											placeholder="Nhập số điện thoại" name="phone"
											required="required">
									</div>
									<div class="text-center">
										<button type="submit"
											class="btn btn-primary btn-block enter-btn">Đăng ký</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="/js/myJs/customjs.js"></script>
</body>
</html>