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
										id="username" placeholder="Mời nhập tài khoản">
								</div>
								<div class="form-group">
									<label><b>Mật Khẩu</b></label> <input type="password" name="pw"
										required="required" class="form-control p_input" id="password"
										placeholder="Mời nhập mật khẩu">
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
									<a id="myId" class="label-signup" href="#">Đăng Ký</a>
								</div>
								<button type="submit"
									class="btn btn-primary btn-block enter-btn">Đăng nhập</button>
							</form>

						</div>
						<div id="myModal" class="modal">
							<div class="modal-content">
								<div>
									<span class="closee">&times;</span>
									<!-- <h2 class="text-center text-uppercase signup">Đăng Ký</h2> -->
								</div>
								<form action="register-form" method="post">
									<div class="form-group">
										<label><b>Tài khoản:</b></label> <input
											class="form-control p_input" type="text"
											placeholder="Username" name="username" required="required">
									</div>
									<div class="form-group">
										<label><b>Mật khẩu:</b></label> <input
											class="form-control p_input" type="password"
											placeholder="Password" name="password" required="required">
									</div>
									<div class="form-group">
										<label><b>Nhập lại mật khẩu:</b></label> <input
											class="form-control p_input" type="password"
											placeholder="Password Confirm" name="passwordConfirm"
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

	<script>
		var modal = document.getElementById('myModal');
		var btn = document.getElementById("myId");
		var span = document.getElementsByClassName("closee")[0];
		btn.onclick = function() {
			modal.style.display = "block";
		}
		span.onclick = function() {
			modal.style.display = "none";
		}
		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}
	</script>
</body>
</html>