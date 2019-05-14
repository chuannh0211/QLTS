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
                <img src="/images/faces/face6.jpg"/>
            </div>
            <form class="form-inline mt-2 mt-md-0 d-none d-lg-block ml-lg-auto">
                <input class="form-control search" type="text" placeholder="Tìm kiếm">
            </form>
            <ul class="navbar-nav">
                <li class="nav-item dropdown">
                    <a class="nav-link count-indicator" id="notificationDropdown" href="#" data-toggle="dropdown">
                        <i class="mdi mdi-bell-outline"></i>
                        <span class="count bg-warning">7</span>
                    </a>
                    <div class="dropdown-menu navbar-dropdown notification-drop-down" aria-labelledby="notificationDropdown">
                        <a class="dropdown-item" href="#">
                            <i class="mdi mdi-cake text-success"></i>
                            <span class="notification-text">Today is John's birthday</span>
                        </a>
                        <a class="dropdown-item" href="#">
                            <i class="mdi mdi-cellphone-iphone text-danger"></i>
                            <span class="notification-text">Call John Doe</span>
                        </a>
                        <a class="dropdown-item" href="#">
                            <i class="mdi mdi-account-multiple text-primary"></i>
                            <span class="notification-text">Meeting Alisa</span>
                        </a>
                        <a class="dropdown-item" href="#">
                            <i class="mdi mdi-alert text-danger"></i>
                            <span class="notification-text">Server space almost full</span>
                        </a>
                        <a class="dropdown-item" href="#">
                            <i class="mdi mdi-bell-outline text-warning"></i>
                            <span class="notification-text">Payment Due</span>
                        </a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link count-indicator" id="MailDropdown" href="#" data-toggle="dropdown">
                        <i class="mdi mdi-comment-outline"></i>
                        <span class="count bg-danger">4</span>
                    </a>
                    <div class="dropdown-menu navbar-dropdown mail-notification" aria-labelledby="MailDropdown">
                         <a class="dropdown-item" href="#"> 
                            <div class="sender-img">
                                <img src="/images/faces/face6.jpg" alt="">
                                <span class="badge badge-success">&nbsp;</span>
                            </div>
                            <div class="sender">
                                <p class="Sende-name">John Doe</p>
                                <p class="Sender-message">Hey, We have a meeting planned at the end of the day.</p>
                            </div>
                        </a>
                        <a class="dropdown-item" href="#"> 
                            <div class="sender-img">
                                <img src="/images/faces/face2.jpg" alt="">
                                <span class="badge badge-success">&nbsp;</span>
                            </div>
                            <div class="sender">
                                <p class="Sende-name">Leanne Jones</p>
                                <p class="Sender-message">Can we schedule a call this afternoon?</p>
                            </div>
                        </a> 
                       <a class="dropdown-item" href="#">
                            <div class="sender-img">
                                <img src="/images/faces/face3.jpg" alt="">
                                <span class="badge badge-primary">&nbsp;</span>
                            </div>
                            <div class="sender">
                                <p class="Sende-name">Stella</p>
                                <p class="Sender-message">Great presentation the other day. Keep up the good work!</p>
                            </div>
                        </a> 
                       <a class="dropdown-item" href="#"> 
                            <div class="sender-img">
                                <img src="/images/faces/face4.jpg" alt="">
                                <span class="badge badge-warning">&nbsp;</span>
                            </div>
                            <div class="sender">
                                <p class="Sende-name">James Brown</p>
                                <p class="Sender-message">Need the updates of the project at the end of the week.</p>
                            </div>
                        </a> 
                        <a href="#" class="dropdown-item view-all">View all</a>
                    </div>
                </li>
            </ul>
            <button class="navbar-toggler navbar-toggler-right d-lg-none align-self-center" type="button" data-toggle="offcanvas">
                <span class="mdi mdi-menu"></span>
            </button>
        </div>
    </nav>

