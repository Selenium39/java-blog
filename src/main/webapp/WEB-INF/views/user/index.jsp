<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!-- 前台首页 -->
<!doctype html>
<html class="no-js" lang="zxx">
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>index</title>
<meta name="description" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Favicon -->

<link rel="icon" href="${APP_PATH}/resource/image/logo.icon"
	type="image/x-icon" />
<!-- Google font (font-family: 'Dosis', sans-serif;) -->
<link
	href="https://fonts.googleapis.com/css?family=Dosis:300,400,500,600,700"
	rel="stylesheet">

<!-- Plugins -->
<link rel="stylesheet"
	href="${APP_PATH}/resource/user/template1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${APP_PATH}/resource/user/template1/css/plugins.css">

<!-- Style Css -->
<link rel="stylesheet"
	href="${APP_PATH}/resource/user/template1/style.css">

<!-- Custom Styles -->
<link rel="stylesheet"
	href="${APP_PATH}/resource/user/template1/css/custom.css">
</head>

<body>
	<!--[if lte IE 9]>
    <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
  <![endif]-->

	<!-- Add your site or application content here -->

	<!-- Wrapper -->
	<!--一个小技巧,将jsp内的值放到隐藏域中,让引用的js能够访问到 -->
	<input id="APP_PATH" type="hidden" value="${APP_PATH}" />
	<div id="wrapper" class="wrapper">

		<span class="cursor"></span>

		<!-- Header -->
		<header class="header sticky-header fixed-header">
			<div class="container">
				<div class="header-inner d-none d-lg-flex">
					<div class="header-logo">
						<a href="index.html"> <img
							src="${APP_PATH}/resource/user/template1/img/logo/logo-dark.png"
							alt="logo">
						</a>
					</div>
					<div class="header-navigation">
						<button class="header-navigation-trigger">
							<span></span> <span></span> <span></span>
						</button>
						<!--导航栏界面  -->
						<nav class="main-navigation">
							<ul>
								<li><a href="${APP_PATH}/user/index">HOME</a>
							    <li><a href="${APP_PATH}/user/aboutMe">ABOUT ME</a>
							</ul>
						</nav>
					</div>
				</div>
				<div class="mobile-menu-wrapper d-block d-lg-none">
					<div class="mobile-menu clearfix">
						<a href="index.html" class="mobile-logo"> <img
							src="${APP_PATH}/resource/user/template1/img/logo/logo-dark.png"
							alt="mobile logo">
						</a>
					</div>
				</div>
			</div>
		</header>
		<!--// Header -->
		<div class="tlinks">
			Collect from <a href="http://www.cssmoban.com/">ç½é¡µæ¨¡æ¿</a>
		</div>
		<!-- Hero Area -->
		<div class="hero-area bg-white">
			<div class="container">
				<div class="hero-area-inner">
					<div class="hero-area-text">
						<h1>
							HELLO, <br> I AM Selenium...
						</h1>
						<h5>A NOOB PROGRAMMER</h5>
						<a href="about.html" class="readmore">ABOUT ME</a>
					</div>
					<div class="hero-area-image">
						<img
							src="${APP_PATH}/resource/user/template1/img/slider/slider-image-1.png"
							alt="man mask">
					</div>
					<div class="social-icons">
						<ul>
							<li><a href="https://github.com/wantao666"><i class="fa fa-github"></i></a></li>
							<li><a href="#"><i class="fa fa-qq"></i></a></li>
							<li><a href="#"><i class="fa fa-wechat"></i></a></li>
							<li><a href="https://weibo.com/u/6857791826"><i class="fa fa-weibo"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<!--// Hero Area -->

		<!-- Page Conttent -->
		<main class="page-content"> <!-- Portfolios Ara -->
		<div class="cr-section portfolios-area section-padding-lg bg-white">
			<div class="container">

				<div class="portfolio-filters text-center">
					<button data-filter="*" class="is-checked">ALL</button>
					<button data-filter=".portfolio-filter-graphic">GRAPHIC</button>
					<button data-filter=".portfolio-filter-photoshop">PHOTOSHOP</button>
					<button data-filter=".portfolio-filter-design">DESIGN</button>
				</div>

				<div class="row portfolios-wrapper portfolios-zoom-button-holder">

					<!-- Single Portfolio -->
					<div
						class="col-lg-4 col-md-6 col-12 portfolio-item portfolio-filter-graphic portfolio-filter-design">
						<div class="portfolio">
							<div class="portfolio-image">
								<img
									src="${APP_PATH}/resource/user/template1/img/portfolio/portfolio-image-1.jpg"
									alt="portfolio image">
							</div>
							<div class="portfolio-content">
								<a
									href="${APP_PATH}/resource/user/template1/img/portfolio/lg-size/portfolio-image-lg-1.jpg"
									class="portfolio-zoom-button"></a>
								<h5>
									<a href="portfolio-details.html">AWESOME RACING CAR</a>
								</h5>
								<h6>
									<a href="portfolio.html">PORTFOLIO</a>
								</h6>
							</div>
						</div>
					</div>
					<!--// Single Portfolio -->

					<!-- Single Portfolio -->
					<div
						class="col-lg-4 col-md-6 col-12 portfolio-item portfolio-filter-graphic">
						<div class="portfolio">
							<div class="portfolio-image">
								<img
									src="${APP_PATH}/resource/user/template1/img/portfolio/portfolio-image-2.jpg"
									alt="portfolio image">
							</div>
							<div class="portfolio-content">
								<a
									href="${APP_PATH}/resource/user/template1/img/portfolio/lg-size/portfolio-image-lg-2.jpg"
									class="portfolio-zoom-button"></a>
								<h5>
									<a href="portfolio-details.html">AWESOME RACING CAR</a>
								</h5>
								<h6>
									<a href="portfolio.html">PORTFOLIO</a>
								</h6>
							</div>
						</div>
					</div>
					<!--// Single Portfolio -->

					<!-- Single Portfolio -->
					<div
						class="col-lg-4 col-md-6 col-12 portfolio-item portfolio-filter-photoshop portfolio-filter-design">
						<div class="portfolio">
							<div class="portfolio-image">
								<img
									src="${APP_PATH}/resource/user/template1/img/portfolio/portfolio-image-3.jpg"
									alt="portfolio image">
							</div>
							<div class="portfolio-content">
								<a
									href="${APP_PATH}/resource/user/template1/img/portfolio/lg-size/portfolio-image-lg-3.jpg"
									class="portfolio-zoom-button"></a>
								<h5>
									<a href="portfolio-details.html">AWESOME RACING CAR</a>
								</h5>
								<h6>
									<a href="portfolio.html">PORTFOLIO</a>
								</h6>
							</div>
						</div>
					</div>
					<!--// Single Portfolio -->

					<!-- Single Portfolio -->
					<div
						class="col-lg-4 col-md-6 col-12 portfolio-item portfolio-filter-graphic portfolio-filter-design">
						<div class="portfolio">
							<div class="portfolio-image">
								<img
									src="${APP_PATH}/resource/user/template1/img/portfolio/portfolio-image-4.jpg"
									alt="portfolio image">
							</div>
							<div class="portfolio-content">
								<a
									href="${APP_PATH}/resource/user/template1/img/portfolio/lg-size/portfolio-image-lg-4.jpg"
									class="portfolio-zoom-button"></a>
								<h5>
									<a href="portfolio-details.html">AWESOME RACING CAR</a>
								</h5>
								<h6>
									<a href="portfolio.html">PORTFOLIO</a>
								</h6>
							</div>
						</div>
					</div>
					<!--// Single Portfolio -->

					<!-- Single Portfolio -->
					<div
						class="col-lg-4 col-md-6 col-12 portfolio-item portfolio-filter-photoshop">
						<div class="portfolio">
							<div class="portfolio-image">
								<img
									src="${APP_PATH}/resource/user/template1/img/portfolio/portfolio-image-5.jpg"
									alt="portfolio image">
							</div>
							<div class="portfolio-content">
								<a
									href="${APP_PATH}/resource/user/template1/img/portfolio/lg-size/portfolio-image-lg-5.jpg"
									class="portfolio-zoom-button"></a>
								<h5>
									<a href="portfolio-details.html">AWESOME RACING CAR</a>
								</h5>
								<h6>
									<a href="portfolio.html">PORTFOLIO</a>
								</h6>
							</div>
						</div>
					</div>
					<!--// Single Portfolio -->

					<!-- Single Portfolio -->
					<div
						class="col-lg-4 col-md-6 col-12 portfolio-item portfolio-filter-photoshop portfolio-filter-design">
						<div class="portfolio">
							<div class="portfolio-image">
								<img
									src="${APP_PATH}/resource/user/template1/img/portfolio/portfolio-image-6.jpg"
									alt="portfolio image">
							</div>
							<div class="portfolio-content">
								<a
									href="${APP_PATH}/resource/user/template1/img/portfolio/lg-size/portfolio-image-lg-6.jpg"
									class="portfolio-zoom-button"></a>
								<h5>
									<a href="portfolio-details.html">AWESOME RACING CAR</a>
								</h5>
								<h6>
									<a href="portfolio.html">PORTFOLIO</a>
								</h6>
							</div>
						</div>
					</div>
					<!--// Single Portfolio -->

					<!-- Single Portfolio -->
					<div
						class="col-lg-4 col-md-6 col-12 portfolio-item portfolio-filter-graphic">
						<div class="portfolio">
							<div class="portfolio-image">
								<img
									src="${APP_PATH}/resource/user/template1/img/portfolio/portfolio-image-7.jpg"
									alt="portfolio image">
							</div>
							<div class="portfolio-content">
								<a
									href="${APP_PATH}/resource/user/template1/img/portfolio/lg-size/portfolio-image-lg-7.jpg"
									class="portfolio-zoom-button"></a>
								<h5>
									<a href="portfolio-details.html">AWESOME RACING CAR</a>
								</h5>
								<h6>
									<a href="portfolio.html">PORTFOLIO</a>
								</h6>
							</div>
						</div>
					</div>
					<!--// Single Portfolio -->

					<!-- Single Portfolio -->
					<div
						class="col-lg-4 col-md-6 col-12 portfolio-item portfolio-filter-design">
						<div class="portfolio">
							<div class="portfolio-image">
								<img
									src="${APP_PATH}/resource/user/template1/img/portfolio/portfolio-image-8.jpg"
									alt="portfolio image">
							</div>
							<div class="portfolio-content">
								<a
									href="${APP_PATH}/resource/user/template1/img/portfolio/lg-size/portfolio-image-lg-8.jpg"
									class="portfolio-zoom-button"></a>
								<h5>
									<a href="portfolio-details.html">AWESOME RACING CAR</a>
								</h5>
								<h6>
									<a href="portfolio.html">PORTFOLIO</a>
								</h6>
							</div>
						</div>
					</div>
					<!--// Single Portfolio -->

					<!-- Single Portfolio -->
					<div
						class="col-lg-4 col-md-6 col-12 portfolio-item portfolio-filter-graphic portfolio-filter-design">
						<div class="portfolio">
							<div class="portfolio-image">
								<img
									src="${APP_PATH}/resource/user/template1/img/portfolio/portfolio-image-9.jpg"
									alt="portfolio image">
							</div>
							<div class="portfolio-content">
								<a
									href="${APP_PATH}/resource/user/template1/img/portfolio/lg-size/portfolio-image-lg-9.jpg"
									class="portfolio-zoom-button"></a>
								<h5>
									<a href="portfolio-details.html">AWESOME RACING CAR</a>
								</h5>
								<h6>
									<a href="portfolio.html">PORTFOLIO</a>
								</h6>
							</div>
						</div>
					</div>
					<!--// Single Portfolio -->

				</div>
			</div>
		</div>
		<!--// Portfolios Ara --> <!-- Service Area -->
		<div
			class="cr-section services-area section-padding-bottom-lg bg-white">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-lg-7">
						<div class="section-title text-center">
							<h2>WHICH I PROVIDE</h2>
							<p>Here is the services which i know & provide all the time</p>
						</div>
					</div>
				</div>
				<div class="row">

					<!-- Single Service -->
					<div class="col-lg-4 col-md-6 col-12">
						<div class="service text-center">
							<h5>BRANDING</h5>
							<p>Random text. It has roots in classical Latin making it
								over 2000 years old.</p>
						</div>
					</div>
					<!--// Single Service -->

					<!-- Single Service -->
					<div class="col-lg-4 col-md-6 col-12">
						<div class="service text-center">
							<h5>PHOTOSHOP</h5>
							<p>Random text. It has roots in classical Latin making it
								over 2000 years old.</p>
						</div>
					</div>
					<!--// Single Service -->

					<!-- Single Service -->
					<div class="col-lg-4 col-md-6 col-12">
						<div class="service text-center">
							<h5>WEB DESIGN</h5>
							<p>Random text. It has roots in classical Latin making it
								over 2000 years old.</p>
						</div>
					</div>
					<!--// Single Service -->

					<!-- Single Service -->
					<div class="col-lg-4 col-md-6 col-12">
						<div class="service text-center">
							<h5>ILLUSTRATOR</h5>
							<p>Random text. It has roots in classical Latin making it
								over 2000 years old.</p>
						</div>
					</div>
					<!--// Single Service -->

					<!-- Single Service -->
					<div class="col-lg-4 col-md-6 col-12">
						<div class="service text-center">
							<h5>MARKETING</h5>
							<p>Random text. It has roots in classical Latin making it
								over 2000 years old.</p>
						</div>
					</div>
					<!--// Single Service -->

					<!-- Single Service -->
					<div class="col-lg-4 col-md-6 col-12">
						<div class="service text-center">
							<h5>PRINT DESIGN</h5>
							<p>Random text. It has roots in classical Latin making it
								over 2000 years old.</p>
						</div>
					</div>
					<!--// Single Service -->

				</div>
			</div>
		</div>
		<!--// Service Area --> </main>
		<!--// Page Conttent -->

		<!-- Footer Area -->
		<footer class="footer-area bg-white">
			<div class="container text-right">
				<ul class="footer-inner">
					<li>@上海电机学院 Selenium</li>
				</ul>
			</div>
		</footer>
		<!--// Footer Area -->

	</div>
	<!--// Wrapper -->

	<!-- Js Files -->
	<script
		src="${APP_PATH}/resource/user/template1/js/vendor/modernizr-3.6.0.min.js"></script>
	<script
		src="${APP_PATH}/resource/user/template1/js/vendor/jquery-3.3.1.min.js"></script>
	<script src="${APP_PATH}/resource/user/template1/js/popper.min.js"></script>
	<script src="${APP_PATH}/resource/user/template1/js/bootstrap.min.js"></script>
	<script src="${APP_PATH}/resource/user/template1/js/plugins.js"></script>
	<script src="${APP_PATH}/resource/user/template1/js/main.js"></script>
</body>



</html>