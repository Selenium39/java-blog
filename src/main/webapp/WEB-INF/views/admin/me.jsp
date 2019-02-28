<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>profile</title>
<meta name="description" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="robots" content="all,follow">
<link rel="icon" href="${APP_PATH}/resource/image/logo.icon"
	type="image/x-icon" />
<!-- Bootstrap CSS-->
<link rel="stylesheet"
	href="${APP_PATH}/resource/admin/template2/vendor/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome CSS-->
<link rel="stylesheet"
	href="${APP_PATH}/resource/admin/template2/vendor/font-awesome/css/font-awesome.min.css">
<!-- Fontastic Custom icon font-->
<link rel="stylesheet"
	href="${APP_PATH}/resource/admin/template2/css/fontastic.css">
<!-- Google fonts - Poppins -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Poppins:300,400,700">
<!-- theme stylesheet-->
<link rel="stylesheet"
	href="${APP_PATH}/resource/admin/template2/css/style.default.css"
	id="theme-stylesheet">
<!-- Custom stylesheet - for your changes-->
<link rel="stylesheet"
	href="${APP_PATH}/resource/admin/template2/css/custom.css">
<!-- selenium -->
<link rel="stylesheet"
	href="${APP_PATH}/resource/admin/selenium/css/me.css">
<!-- Tweaks for older IEs-->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
</head>
<body>
	<!--一个小技巧,将jsp内的值放到隐藏域中,让引用的js能够访问到 -->
	<input id="APP_PATH" type="hidden" value="${APP_PATH}" />
	<div class="page">
		<!-- Main Navbar-->
		<header class="header">
			<nav class="navbar">
				<!-- Search Box-->
				<div class="search-box">
					<button class="dismiss">
						<i class="icon-close"></i>
					</button>
					<form id="searchForm" action="#" role="search">
						<input type="search" placeholder="What are you looking for..."
							class="form-control">
					</form>
				</div>
				<div class="container-fluid">
					<div
						class="navbar-holder d-flex align-items-center justify-content-between">
						<!-- Navbar Header-->
						<div class="navbar-header">
							<!-- Navbar Brand -->
							<a href="index.html"
								class="navbar-brand d-none d-sm-inline-block">
								<div class="brand-text d-none d-lg-inline-block">
									<span>Bootstrap </span><strong>Dashboard</strong>
								</div>
								<div class="brand-text d-none d-sm-inline-block d-lg-none">
									<strong>BD</strong>
								</div>
							</a>
							<!-- Toggle Button-->
							<a id="toggle-btn" href="#" class="menu-btn active"><span></span><span></span><span></span></a>
						</div>
						<!-- Navbar Menu -->
						<ul
							class="nav-menu list-unstyled d-flex flex-md-row align-items-md-center">
							<!-- Search-->
							<li class="nav-item d-flex align-items-center"><a
								id="search" href="#"><i class="icon-search"></i></a></li>
							<!-- Notifications-->
							<li class="nav-item dropdown"><a id="notifications"
								rel="nofollow" data-target="#" href="#" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false" class="nav-link"><i
									class="fa fa-bell-o"></i><span
									class="badge bg-red badge-corner">12</span></a>
								<ul aria-labelledby="notifications" class="dropdown-menu">
									<li><a rel="nofollow" href="#" class="dropdown-item">
											<div class="notification">
												<div class="notification-content">
													<i class="fa fa-envelope bg-green"></i>You have 6 new
													messages
												</div>
												<div class="notification-time">
													<small>4 minutes ago</small>
												</div>
											</div>
									</a></li>
									<li><a rel="nofollow" href="#" class="dropdown-item">
											<div class="notification">
												<div class="notification-content">
													<i class="fa fa-twitter bg-blue"></i>You have 2 followers
												</div>
												<div class="notification-time">
													<small>4 minutes ago</small>
												</div>
											</div>
									</a></li>
									<li><a rel="nofollow" href="#" class="dropdown-item">
											<div class="notification">
												<div class="notification-content">
													<i class="fa fa-upload bg-orange"></i>Server Rebooted
												</div>
												<div class="notification-time">
													<small>4 minutes ago</small>
												</div>
											</div>
									</a></li>
									<li><a rel="nofollow" href="#" class="dropdown-item">
											<div class="notification">
												<div class="notification-content">
													<i class="fa fa-twitter bg-blue"></i>You have 2 followers
												</div>
												<div class="notification-time">
													<small>10 minutes ago</small>
												</div>
											</div>
									</a></li>
									<li><a rel="nofollow" href="#"
										class="dropdown-item all-notifications text-center"> <strong>view
												all notifications </strong></a></li>
								</ul></li>
							<!-- Messages                        -->
							<li class="nav-item dropdown"><a id="messages"
								rel="nofollow" data-target="#" href="#" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false" class="nav-link"><i
									class="fa fa-envelope-o"></i><span
									class="badge bg-orange badge-corner">10</span></a>
								<ul aria-labelledby="notifications" class="dropdown-menu">
									<li><a rel="nofollow" href="#"
										class="dropdown-item d-flex">
											<div class="msg-profile">
												<img
													src="${APP_PATH}/resource/admin/template2/img/avatar-1.jpg"
													alt="..." class="img-fluid rounded-circle">
											</div>
											<div class="msg-body">
												<h3 class="h5">Jason Doe</h3>
												<span>Sent You Message</span>
											</div>
									</a></li>
									<li><a rel="nofollow" href="#"
										class="dropdown-item d-flex">
											<div class="msg-profile">
												<img
													src="${APP_PATH}/resource/admin/template2/img/avatar-2.jpg"
													alt="..." class="img-fluid rounded-circle">
											</div>
											<div class="msg-body">
												<h3 class="h5">Frank Williams</h3>
												<span>Sent You Message</span>
											</div>
									</a></li>
									<li><a rel="nofollow" href="#"
										class="dropdown-item d-flex">
											<div class="msg-profile">
												<img
													src="${APP_PATH}/resource/admin/template2/img/avatar-3.jpg"
													alt="..." class="img-fluid rounded-circle">
											</div>
											<div class="msg-body">
												<h3 class="h5">Ashley Wood</h3>
												<span>Sent You Message</span>
											</div>
									</a></li>
									<li><a rel="nofollow" href="#"
										class="dropdown-item all-notifications text-center"> <strong>Read
												all messages </strong></a></li>
								</ul></li>
							<!-- Languages dropdown    -->
							<li class="nav-item dropdown"><a id="languages"
								rel="nofollow" data-target="#" href="#" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false"
								class="nav-link language dropdown-toggle"><img
									src="${APP_PATH}/resource/admin/template2/img/flags/16/GB.png"
									alt="English"><span class="d-none d-sm-inline-block">English</span></a>
								<ul aria-labelledby="languages" class="dropdown-menu">
									<li><a rel="nofollow" href="#" class="dropdown-item">
											<img
											src="${APP_PATH}/resource/admin/template2/img/flags/16/DE.png"
											alt="English" class="mr-2">German
									</a></li>
									<li><a rel="nofollow" href="#" class="dropdown-item">
											<img
											src="${APP_PATH}/resource/admin/template2/img/flags/16/FR.png"
											alt="English" class="mr-2">French
									</a></li>
								</ul></li>
							<!-- Logout    -->
							<li class="nav-item"><a href="login.html"
								class="nav-link logout"> <span class="d-none d-sm-inline">Logout</span><i
									class="fa fa-sign-out"></i></a></li>
						</ul>
					</div>
				</div>
			</nav>
		</header>
		<div class="page-content d-flex align-items-stretch">
			<!-- Side Navbar -->
			<nav class="side-navbar">
				<!-- Sidebar Header-->
				<div class="sidebar-header d-flex align-items-center">
					<div class="avatar">
						<img src="${APP_PATH}/resource/admin/template2/img/avatar-10.png"
							alt="..." class="img-fluid rounded-circle">
					</div>
					<div class="title">
						<h1 class="h4">Selenium</h1>
						<p>Noob Programmer</p>
					</div>
				</div>
				<!-- Sidebar Navidation Menus-->
				<span class="heading">Main</span>
				<ul class="list-unstyled">
					<li><a href="${APP_PATH}/admin/home"> <i class="icon-home"></i>Home
					</a></li>
					<!--显示所有用户 -->
					<li><a href="${APP_PATH}/admin/users"> <i
							class="fa fa-users"></i>User
					</a></li>
					<li><a href="${APP_PATH}/admin/articles"> <i
							class="fa fa-book"></i>Article
					</a></li>
					<li><a href="${APP_PATH}/admin/comments"> <i
							class="fa fa-comment"></i>Comment
					</a></li>
					<li><a href="${APP_PATH}/admin/messages"> <i
							class="fa fa-heart"></i>Message
					</a></li>
					<li class="active"><a href="${APP_PATH}/admin/me"> <i
							class="fa fa-user"></i>Profile
					</a></li>
					<li><a href="${APP_PATH}/admin/contact"> <i
							class="fa fa-phone" aria-hidden="true"></i> Contact
					</a></li>
					<li><a href="#exampledropdownDropdown" aria-expanded="false"
						data-toggle="collapse"> <i class="icon-interface-windows"></i>Example
							dropdown
					</a>
						<ul id="exampledropdownDropdown" class="collapse list-unstyled ">
							<li><a href="#">Page</a></li>
							<li><a href="#">Page</a></li>
							<li><a href="#">Page</a></li>
						</ul></li>
				</ul>
				<span class="heading">Extras</span>
				<ul class="list-unstyled">
					<li><a href="#"> <i class="icon-flask"></i>Demo
					</a></li>
					<li><a href="#"> <i class="icon-screen"></i>Demo
					</a></li>
					<li><a href="#"> <i class="icon-mail"></i>Demo
					</a></li>
					<li><a href="#"> <i class="icon-picture"></i>Demo
					</a></li>
				</ul>
			</nav>
			<div class="content-inner">
				<!-- Page Header-->
				<header class="page-header">
					<div class="container-fluid">
						<h2 class="no-margin-bottom">Dashboard</h2>
					</div>
				</header>
				<!-- Dashboard Section-->
				<section class="dashboard-counts no-padding-bottom">
					<div class="container-fluid">
						<div class="bg-white has-shadow">
							<table class="table" id="showTable">
								<tbody>
									<tr>
										<td>id</td>
										<td id="id"></td>
									</tr>
									<tr>
										<td>name</td>
										<td id="name"></td>
									</tr>
									<tr>
										<td>avatar</td>
										<td><img id="avatar"></td>
									</tr>
									<tr>
										<td>password</td>
										<td id="password"></td>
									</tr>
									<tr>
										<td>nickname</td>
										<td id="nickname"></td>
									</tr>
									<tr>
										<td>gender</td>
										<td id="gender"></td>
									</tr>
									<tr>
										<td>age</td>
										<td id="age"></td>
									</tr>
									<tr>
										<td>phone</td>
										<td id="phone"></td>
									</tr>
									<tr>
										<td>email</td>
										<td id="email"></td>
									</tr>
									<tr>
										<td>title</td>
										<td id="title"></td>
									</tr>
									<tr>
										<td>viceTitle</td>
										<td id="viceTitle"></td>
									</tr>
									<tr>
										<td>introduction</td>
										<td><textarea id="introduction"></textarea></td>
									</tr>
									<tr>
										<td><button class="btn btn-info" id="update">修改</button></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</section>
				<!-- Page Footer-->
				<footer class="main-footer">
					<div class="container-fluid">
						<div class="row">
							<div class="col-sm-6 text-right">
								<p>
									<small>@上海电机学院 Selenium</small>
								</p>
								<!-- Please do not remove the backlink to us unless you support further theme's development at https://bootstrapious.com/donate. It is part of the license conditions. Thank you for understanding :)-->
							</div>
						</div>
					</div>
				</footer>
			</div>
		</div>
	</div>

	<div class="modal fade" id="myUpdateModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document" style="margin-top: 380px;">
			<div class="modal-content">
				<div class="modal-body">
					<form id="updateForm">
						<div class="form-group">
							<label for="name1">name:</label> <input id="name1"
								class="m form-control col-md-8" name="name"></input>
						</div>
						<div class="form-group">
							<label for="avatar1">avatar:</label> <img id="avatar1" />
						</div>
						<div class="form-group">
							<label for="photo" class="control-label">上传照片:</label> <input
								type="file" id="photo" name="file" class="m">
						</div>
						<div class="form-group">
							<label for="password1">password:</label> <input id="password1"
								type="password" name="password" class="m form-control col-md-8" />
						</div>
						<i id="eye" show="false"
							style="position: absolute; margin-top: -43px; margin-left: 280px;"
							class="fa fa-eye m"></i>
						<div class="form-group">
							<label for="nickname1">nickname:</label> <input id="nickname1"
								type="text" name="nickname" class="m form-control col-md-8" />
						</div>
						<div class="form-group">
							<label for="gender1">gender:</label> <select name="gender">
								<option id="status0" value="0">Female</option>
								<option id="status1" value="1">Male</option>
							</select>
						</div>
						<div class="form-group">
							<label for="age1">age:</label> <input id="age1" type="text"
								name="age" class="m form-control col-md-8" />
						</div>
						<div class="form-group">
							<label for="phone1">phone:</label> <input id="phone1" type="text"
								name="phone" class="m form-control col-md-8" />
						</div>
						<div class="form-group">
							<label for="email1">email:</label> <input id="email1"
								type="email" name="email" class="m form-control col-md-8" />
						</div>
						<div class="form-group">
							<label for="title1">title:</label> <input id="title1" type="text"
								name="title" class="m form-control col-md-8" />
						</div>
						<div class="form-group">
							<label for="viceTitle1">viceTitle:</label> <input id="viceTitle1"
								type="text" name="viceTitle" class="m form-control col-md-8" />
						</div>
						<div class="form-group">
							<label for="introduction1">introduction:</label>
							<textarea class="m form-control col-md-8" name="introduction"
								id="introduction1" cols="40" rows="10"></textarea>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="updateButton">修改</button>
				</div>
			</div>
		</div>
	</div>
	<!-- JavaScript files-->
	<script
		src="${APP_PATH}/resource/admin/template2/vendor/jquery/jquery.min.js"></script>
	<script
		src="${APP_PATH}/resource/admin/template2/vendor/popper.js/umd/popper.min.js">
		
	</script>
	<script
		src="${APP_PATH}/resource/admin/template2/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="${APP_PATH}/resource/admin/template2/vendor/jquery.cookie/jquery.cookie.js">
		
	</script>
	<script
		src="${APP_PATH}/resource/admin/template2/vendor/chart.js/Chart.min.js"></script>
	<script
		src="${APP_PATH}/resource/admin/template2/vendor/jquery-validation/jquery.validate.min.js"></script>
	<script src="${APP_PATH}/resource/admin/template2/js/charts-home.js"></script>
	<!-- Main File-->
	<script src="${APP_PATH}/resource/admin/template2/js/front.js"></script>
	<!-- Selenium -->
	<script src="${APP_PATH}/resource/admin/selenium/js/me.js"></script>
</body>
</html>