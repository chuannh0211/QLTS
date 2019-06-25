<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<nav class="navbar col-lg-12 col-12 fixed-top d-flex flex-row">
        <div class="text-center navbar-brand-wrapper">
            <a class="navbar-brand brand-logo" href="${contextPath }/">MANAGER
                <i class="mdi mdi-cube-send"></i>
            </a>
            <a class="navbar-brand brand-logo-mini" href="${contextPath }/"><i class="mdi mdi-cube-send"></i></a>
        </div>
        <div class="navbar-menu-wrapper d-flex align-items-center">
            <button class="navbar-toggler navbar-toggler align-self-center mr-2" type="button" data-toggle="minimize">
                <span class="mdi mdi-menu"></span>
            </button>
            <div class="nav-profile">
                <span>Xin chào, ${pageContext.request.userPrincipal.name}</span>
                <img src="/images/faces/default.jpg"/>
            </div>
            
            <button class="navbar-toggler navbar-toggler-right d-lg-none align-self-center" type="button" data-toggle="offcanvas">
                <span class="mdi mdi-menu"></span>
            </button>
        </div>
    </nav>

