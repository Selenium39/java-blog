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
<title>tag</title>
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
<!-- Tweaks for older IEs-->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
</head>
<body>
	<!--一个小技巧,将jsp内的值放到隐藏域中,让引用的js能够访问到 -->
	<input id="APP_PATH" type="hidden" value="${APP_PATH}" />
	<div class="page">
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
							<!-- 留言 -->
							<li class="nav-item dropdown"><a id="notification_message"
								rel="nofollow" data-target="#" href="#" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false" class="nav-link"><i
									class="fa fa-bell-o" id=""></i> <!-- 这里显示消息条数 --> <span
									id="new_message_count" class="badge bg-orange badge-corner"></span>
							</a></li>
							<!-- 文章评论 -->
							<li class="nav-item dropdown"><a id="notification_comments"
								rel="nofollow" data-target="#" href="#" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false" class="nav-link"><i
									class="fa fa-commenting"></i><span id="new_comment_count"
									class="badge bg-red badge-corner"></span></a>	</li>
							<!-- 联系人-->
							<li class="nav-item dropdown"><a id="notification_contact"
								rel="nofollow" data-target="#" href="#" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false" class="nav-link"><i
									class="fa fa-address-book"></i> <!-- 这里显示消息条数 --> <span
									id="new_contact_count" class="badge bg-orange badge-corner"></span>
							</a></li> <!--	
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
					<li><a href="${APP_PATH}/admin/articles" aria-expanded="false">
							<i class="fa fa-book"></i>Article
					</a>
						<ul id="article_tool" class="show list-unstyled ">
							<li><a href="${APP_PATH}/admin/articles">Article</a></li>
							<li><a href="${APP_PATH}/admin/categorys">Category</a></li>
							<li class="active"><a href="${APP_PATH}/admin/tags">Tag</a></li>
						</ul></li>
					<li><a href="${APP_PATH}/admin/comments"> <i
							class="fa fa-comment"></i>Comment
					</a></li>
					<li><a href="${APP_PATH}/admin/messages"> <i
							class="fa fa-heart"></i>Message
					</a></li>
					<li><a href="${APP_PATH}/admin/me"> <i class="fa fa-user"></i>Profile
					</a></li>
					<li><a href="${APP_PATH}/admin/contact"> <i
							class="fa fa-phone" aria-hidden="true"></i> Contact
					</a></li>
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
					<div class="container-fluid" id="show">
						<div class="row">
							<button id="batchDeleteButton" class="btn btn-danger">批量删除</button>
							<button id="addButton" class="btn btn-black">新增标签</button>
						</div>
						<div class="row bg-white has-shadow">
							<table class="table  table-condensed table-bordered table-hover">
								<thead>
									<tr>
										<th><input type="checkbox" id="checkAll" /></th>
										<th>id</th>
										<th>name</th>
										<th>tagImage</th>
										<th>description</th>
										<th>opration</th>
									</tr>
								</thead>
								<tbody id="tags">
								</tbody>
							</table>
						</div>
						<div class="row">
							<div id="page_info" class="col-md-8"></div>
							<div id="page_jump" class="offset-md-8">
								跳转到第<input type="text" class="col-md-2" id="page_number" />
								<button class="btn btn-link" id="jumpButton">跳转</button>
							</div>
							<div id="page_line" class="col-md-8  offset-md-8"></div>
						</div>
					</div>
				</section>

				<!--模态框-->
				<!--修改Modal -->
				<div class="modal fade" id="myUpdateModal" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel">
					<div class="modal-dialog" role="document"
						style="margin-top: 170px;">
						<div class="modal-content">
							<div class="modal-body">
								<form id="updateForm">
									<div class="form-group">
										<label for="tagId">id:</label>
										<p id="tagId" class="u"></p>
									</div>
									<div class="form-group">
										<label for="tagName">tagName:</label> <input id="tagName"
											type="text" name="tagName" class="u form-control col-md-8" />
									</div>
									<div class="form-group">
							<label for="tagImage">tagImage:</label> <img
								id="tagImage" />
						</div>
						<div class="form-group">
							<label for="photo" class="control-label">上传照片:</label> <input
								type="file" id="photo" name="file" class="u">
						</div>
									<div class="form-group">
										<label for="tagDecription">tagDescription:</label> <input
											id="tagDescription" type="text" name="tagDescription"
											class="u form-control col-md-8" />
									</div>
								</form>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">关闭</button>
								<button type="button" class="btn btn-primary" id="updateButton">修改</button>
							</div>
						</div>
					</div>
				</div>


				<!-- 模态框 -->
				<!-- 新增模态框 -->
				<div class="modal fade" id="myAddModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel">
					<div class="modal-dialog" role="document"
						style="margin-top: 170px;">
						<div class="modal-content">
							<div class="modal-body">
								<form id="addForm">
									<div class="form-group">
										<label for="tagName1">tagName:</label> <input id="tagName1"
											type="text" name="tagName" class="a form-control col-md-8" />
									</div>
									<div class="form-group">
										<label for="tagImage1">tagImage:</label> <img class="a"
											id="tagImage1" />
									</div>
									<div class="form-group">
										<label for="photo1" class="control-label">上传标签图片:</label> <input
											type="file" id="photo1" name="file" class="a">
									</div>
									<div class="form-group">
										<label for="tagDescription1">tagDescription:</label>
										<textarea id="tagDescription1" name="tagDescription"
											class="a form-control col-md-8"></textarea>
									</div>
								</form>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">关闭</button>
								<button type="button" class="btn btn-primary"
									id="addButtonFinish">添加</button>
							</div>
						</div>
					</div>
				</div>



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
	<script src="${APP_PATH}/resource/admin/selenium/js/tags.js"></script>
</body>
</html>