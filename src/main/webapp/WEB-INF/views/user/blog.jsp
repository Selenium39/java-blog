<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>blog</title>
<meta name="keywords" content="">
<meta name="description" content="">
<link rel="icon" href="${APP_PATH}/resource/image/logo.icon"
	type="image/x-icon" />
<link rel="stylesheet" type="text/css"
	href="${APP_PATH}/resource/user/template3/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${APP_PATH}/resource/user/template3/css/nprogress.css">
<link rel="stylesheet" type="text/css"
	href="${APP_PATH}/resource/user/template3/css/style.css">
<link rel="stylesheet" type="text/css"
	href="${APP_PATH}/resource/user/template3/css/font-awesome.min.css">
<script src="${APP_PATH}/resource/user/template3/js/jquery-2.1.4.min.js"></script>
<script src="${APP_PATH}/resource/user/template3/js/nprogress.js"></script>
<script
	src="${APP_PATH}/resource/user/template3/js/jquery.lazyload.min.js"></script>
<!--[if gte IE 9]>
  <script src="js/jquery-1.11.1.min.js" type="text/javascript"></script>
  <script src="js/html5shiv.min.js" type="text/javascript"></script>
  <script src="js/respond.min.js" type="text/javascript"></script>
  <script src="js/selectivizr-min.js" type="text/javascript"></script>
<![endif]-->
<!--[if lt IE 9]>
  <script>window.location.href='upgrade-browser.html';</script>
<![endif]-->
</head>

<body class="user-select">
	<input id="APP_PATH" type="hidden" value="${APP_PATH}" />
	<header class="header">
		<nav class="navbar navbar-default" id="navbar">
			<div class="container">
				<div class="header-topbar hidden-xs link-border">
					<!-- 右上角标签栏 -->
					<ul class="site-nav topmenu">
						<a>navbar</a>
					</ul>
					Don't forget your heart.
				</div>
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#header-navbar"
						aria-expanded="false">
						<span class="sr-only"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span> <span class="icon-bar"></span>
					</button>
					<h1 class="logo hvr-bounce-in">
						<!-- 可更换为照片 -->
						Selenium's blog
					</h1>
				</div>
				<!-- 右侧搜索栏 -->
				<div class="collapse navbar-collapse" id="header-navbar">
					<form class="navbar-form visible-xs" action="#" method="post">
						<div class="input-group">
							<input type="text" name="keyword" class="form-control"
								placeholder="input the keyword" maxlength="20"
								autocomplete="off"> <span class="input-group-btn">
								<button class="btn btn-default btn-search" name="search"
									type="submit">search</button>
							</span>
						</div>
					</form>

					<!-- 导航栏 -->
					<ul class="nav navbar-nav navbar-right">
						<li><a title="index" href="${APP_PATH}/user/blog">index</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>
	<section class="container">
		<div class="content-wrap">
			<div class="content">
				<!-- 首页的图片展览 820x200 px -->
				<div id="focusslide" class="carousel slide" data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#focusslide" data-slide-to="0" class="active"></li>
						<li data-target="#focusslide" data-slide-to="1"></li>
					</ol>
					<div class="carousel-inner" role="listbox">
						<div class="item active">
							<a href="#" target="_blank">
								<img
								src="${APP_PATH}/resource/image/1552546380466_820x200.png"
								class="img-responsive">
							</a>
						</div>
						<div class="item">
							<a href="#" target="_blank" > <img
								src="${APP_PATH}/resource/image/5girls_820x200.png"
								 class="img-responsive"></a>
						</div>
					</div>
					<a class="left carousel-control" href="#focusslide" role="button"
						data-slide="prev" rel="nofollow"> <span
						class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">previous</span>
					</a> <a class="right carousel-control" href="#focusslide" role="button"
						data-slide="next" rel="nofollow"> <span
						class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">next</span>
					</a>
				</div>
				<div class="title">
					<h3>NEW Article</h3>
					<!-- 文章界面导航栏 -->
					<div class="more">
						<a>navarbar</a> <a>navarbar</a>
					</div>
				</div>
				<!-- 文章列表 -->
				<div id="article_list"></div>
				<!-- 点击查看更多出来更多文章 -->
				<nav>
					<ul class="pager">
						<li><a class="col-md-12" id="show_more">查看更多</a></li>
					</ul>
				</nav>
			</div>
		</div>
		<div class="tlinks">
			Collect from <a href="http://www.cssmoban.com/">ä¼ä¸ç½ç«æ¨¡æ¿</a>
		</div>
		<aside class="sidebar">
			<div class="fixed">
				<!--右侧信息页面  -->
				<div class="widget widget-tabs">
					<ul class="nav nav-tabs" role="tablist">
						<li role="presentation" class="active"><a href="#notice"
							aria-controls="notice" role="tab" data-toggle="tab">Web
								Statistics</a></li>
						<li role="presentation"><a href="#contact"
							aria-controls="contact" role="tab" data-toggle="tab">Contact
								Me</a></li>
					</ul>
					<div class="tab-content">
						<div role="tabpanel" class="tab-pane contact active" id="notice">
							<h2>网站统计信息</h2>
						</div>
						<div role="tabpanel" class="tab-pane contact" id="contact">
							<h2>QQ</h2>

						</div>
					</div>
				</div>
				<div class="widget widget_search">
					<form class="navbar-form" action="#" method="post">
						<div class="input-group">
							<input type="text" name="keyword" class="form-control" size="35"
								placeholder="please input keyword" maxlength="15"
								autocomplete="off"> <span class="input-group-btn">
								<button class="btn btn-default btn-search" name="search"
									type="submit">Search</button>
							</span>
						</div>
					</form>
				</div>
			</div>
			<!-- 右侧最新评论文章 -->
			<div class="widget widget_hot">
				<h3>The New Comment Article</h3>
				<ul>
					<li><a title="title" href="#"><span class="thumbnail">
								<img class="thumb"
								data-original="${APP_PATH}/resource/user/template3/images/201610181739277776.jpg"
								src="${APP_PATH}/resource/user/template3/images/201610181739277776.jpg"
								alt="alttitle" style="display: block;">
						</span><span class="text">title</span><span class="muted"><i
								class="glyphicon glyphicon-time"></i> 2016-11-01 </span><span
							class="muted"><i class="glyphicon glyphicon-eye-open"></i>88</span></a></li>
				</ul>
			</div>
			<!-- 支付宝 -->
			<div class="widget widget_sentence">
				<a href="#" target="_blank" rel="nofollow" title="advertise"> <img
					style="width: 100%"
					src="${APP_PATH}/resource/user/template3/images/alipay.jpg"
					alt="advertise"></a>
			</div>
			<!-- 微信 -->
			<div class="widget widget_sentence">
				<a href="#" target="_blank" rel="nofollow" title="MZ-NetBlogä¸»é¢">
					<img style="width: 100%"
					src="${APP_PATH}/resource/user/template3/images/weixinpay.jpg"
					alt="MZ-NetBlogä¸»é¢">
				</a>
			</div>
			<!--友情链接 -->
			<div class="widget widget_sentence">
				<h3>friendly link</h3>
				<div class="widget-sentence-link">
					<a href="#" title="friendlylink" target="_blank">friendly link</a>&nbsp;&nbsp;&nbsp;
				</div>
			</div>
		</aside>
	</section>
	<footer class="footer">
		<div class="container">
			<p>
				<small>@上海电机学院 Selenium</small>
			</p>
		</div>
		<div id="gotop">
			<a class="gotop"></a>
		</div>
	</footer>
	<script src="${APP_PATH}/resource/user/template3/js/bootstrap.min.js"></script>
	<script src="${APP_PATH}/resource/user/template3/js/jquery.ias.js"></script>
	<script src="${APP_PATH}/resource/user/template3/js/scripts.js"></script>
	<!-- selenium -->
	<script src="${APP_PATH}/resource/user/selenium/js/blog.js"></script>
</body>
</html>
