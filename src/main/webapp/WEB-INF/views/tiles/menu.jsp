<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<nav class="sidebar sidebar-offcanvas" id="sidebar">
	<ul class="nav">
		<li class="nav-item"><a class="nav-link" data-toggle="collapse"
			href="#dashboardSubmenu" aria-expanded="false"
			aria-controls="collapseExample"> <i
				class="mdi mdi-compass-outline"></i> <span class="menu-title">Dashboard</span>
				<i class="mdi mdi-chevron-down"></i>
		</a>
			<div class="collapse" id="dashboardSubmenu">
				<ul class="nav flex-column sub-menu">
					<li class="nav-item"><a class="nav-link" href="/">Dashboard
					</a></li>
					<li class="nav-item"><a class="nav-link" href="/dsts">Danh
							sách tài sản </a></li>
					<li class="nav-item"><a class="nav-link" href="/dsdm">Danh
							sách danh mục </a></li>
					<li class="nav-item"><a class="nav-link" href="/dsncc">Danh
							sách nhà cung cấp </a></li>
					<li class="nav-item"><a class="nav-link" href="/dsn">Danh
							sách nhóm </a></li>
					<li class="nav-item"><a class="nav-link" href="/dstk">Danh
							sách tài khoản </a></li>
				</ul>
			</div>
		<li class="nav-item" sec:authorize="isAuthenticated()"><a
			class="nav-link" href="/logout"> <i class="mdi mdi-logout"></i> <span
				class="menu-title">Logout</span>
		</a></li>
	</ul>
</nav>