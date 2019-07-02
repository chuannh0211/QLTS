<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<nav class="sidebar sidebar-offcanvas" id="sidebar">
	<ul class="nav">
		<li class="nav-item"><a class="nav-link" data-toggle="collapse"
			href="#dashboardSubmenu" aria-expanded="false"
			aria-controls="collapseExample"> <i
				class="mdi mdi-compass-outline"></i> <span class="menu-title">TRANG CHỦ</span>
				<i class="mdi mdi-chevron-down"></i>
		</a>
			<div class="collapse" id="dashboardSubmenu">
				<ul class="nav flex-column sub-menu">
					<li class="nav-item">
						<a class="nav-link" href="/">Trang chủ</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="/asset/listAsset">Tài sản </a>
					</li>
					<!-- <li class="nav-item">
						<a class="nav-link" href="/dsdm">Danh sách danh mục </a>
					</li> -->
					<li class="nav-item">
						<a class="nav-link" href="/category/listCategories">Danh mục</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="/supplier/listSuppliers">Nhà cung cấp </a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="/group/listGroups">Nhóm </a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="/user/listAccounts">Tài khoản </a>
					</li>
				</ul>	
			</div>
		<li class="nav-item" sec:authorize="isAuthenticated()"><a
			class="nav-link" href="/logout"> <i class="mdi mdi-logout"></i> <span
				class="menu-title">ĐĂNG XUẤT</span>
		</a></li>
	</ul>
</nav>