<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!DOCTYPE html>
<html lang="en" class="ace ace-card-on ace-tab-nav-on ace-main-nav-on ace-sidebar-on" data-theme-color="#c0e3e7">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>留言</title>
    <meta name="description" content="">

    <!-- Selenium icon -->
    <link rel="icon" href="${APP_PATH}/resource/image/logo.icon"
	type="image/x-icon" />

    <!-- Google Fonts -->
    <link href="${APP_PATH}/resource/user/template4/fonts/font1.css" rel="stylesheet">
    <link href="${APP_PATH}/resource/user/template4/fonts/font2.css" rel="stylesheet">

    <!-- Icon Fonts -->
    <link href="${APP_PATH}/resource/user/template4/fonts/icomoon/style.css" rel="stylesheet">
    
    <!-- Styles -->
    <link href="${APP_PATH}/resource/user/template4/js/plugins/highlight/solarized-light.css" rel="stylesheet">
    <link href="${APP_PATH}/resource/user/template4/style.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css"
	href="${APP_PATH}/resource/user/template4/style1.css">
	    <link rel="stylesheet" type="text/css"
	href="${APP_PATH}/resource/user/template4/bootstrap.min.css">
	<script type="text/javascript" src="${APP_PATH}/resource/user/template4/js/bootstrap.min.js"></script>
    <!-- Modernizer -->
    <script type="text/javascript" src="${APP_PATH}/resource/user/template4/js/vendor/modernizr-3.3.1.min.js"></script>
  </head>
  <body>
  <input id="APP_PATH" type="hidden" value="${APP_PATH}" />
     <div class="ace-wrapper">
         <header id="ace-header" class="ace-container-shift ace-logo-in ace-head-boxed ace-nav-right">
             <div class="ace-head-inner">
                 <div class="ace-head-container ace-container">
                     <div class="ace-head-row">
                         <div id="ace-head-col1" class="ace-head-col text-left">
                             <a id="ace-logo" class="ace-logo" href="${APP_PATH}/user/index">
                                <img src="${APP_PATH}/resource/user/template4/img/uploads/brand/logo.svg" alt="ace resume"><span>Selenium</span>
                             </a>
                         </div>
                         <div id="ace-head-col2" class="ace-head-col text-right">
                             <div class="ace-nav-container ace-container hidden-sm hidden-xs">
                                 <nav id="ace-main-nav">
                                    <ul class="clear-list">
										<li><a href="${APP_PATH}/user/index">首页</a></li>
										<li><a href="${APP_PATH}/user/blog">博客</a></li>
										<li><a href="${APP_PATH}/user/message">留言</a></li>
										<li><a href="${APP_PATH}/user/aboutMe">关于我</a></li>
									</ul>
                                 </nav>
                             </div>
                         </div>
                     </div>
                 </div><!-- .ace-container -->
             </div><!-- .ace-head-inner -->
        </header><!-- #ace-header -->
        <!-- #ace-tab-nav-sm -->

        <article id="ace-card" class="ace-card bg-primary">
			<div class="ace-card-inner text-center" style="position:fixed;">
				<img class="avatar avatar-350" src="${APP_PATH}/resource/user/template4/img/uploads/avatar/liuyan.png" width="195" height="195" alt="">
			</div>
		</article><!-- #ace-card -->

        <div id="ace-content" class="ace-container-shift">
            <div class="ace-container">

                
                    <div id="ace-nav-wrap" class="hidden-sm hidden-xs">
                        <div class="ace-nav-cont">
                            <div id="ace-nav-scroll">
                                <nav id="ace-nav" class="ace-nav">
                                    <ul class="clear-list">
										<li>
											<a data-tooltip="女朋友一"><img class="avatar avatar-42" src="${APP_PATH}/resource/user/template4/img/uploads/avatar/1.jpeg" alt=""></a>
										</li>
										<li>
											<a  data-tooltip="女朋友二"><img class="avatar avatar-42" src="${APP_PATH}/resource/user/template4/img/uploads/avatar/2.jpeg" alt=""></a>
										</li>
										<li>
											<a data-tooltip="老婆"><img class="avatar avatar-42" src="${APP_PATH}/resource/user/template4/img/uploads/avatar/3.jpeg" alt=""></a>
										</li>
										<li>
											<a  data-tooltip="女朋友四"><img class="avatar avatar-42" src="${APP_PATH}/resource/user/template4/img/uploads/avatar/4.jpeg" alt=""></a>
										</li>
										<li>
											<a  data-tooltip="女朋友五"><img class="avatar avatar-42" src="${APP_PATH}/resource/user/template4/img/uploads/avatar/5.jpeg" alt=""></a>
										</li>
									</ul>
                                </nav>
                            </div>

                            <div id="ace-nav-tools" class="hidden">
                                <span class="ace-icon ace-icon-dots-three-horizontal"></span>

                                <button id="ace-nav-arrow" class="clear-btn">
                                    <span class="ace-icon ace-icon-chevron-thin-down"></span>
                                </button>
                            </div>
                        </div>
                        <div class="ace-nav-btm"></div>
                    </div><!-- .ace-nav-wrap -->

                <div class="ace-paper-stock">
                    <main class="ace-paper clearfix">
                        <div class="ace-paper-cont clear-mrg">
						
						<!-- START: PAGE CONTENT -->

    <h2 class="title-lg text-upper padd-box">留言板</h2>

    <div class="padd-box-xs">
        <header class="contact-head">
            <ul class="ace-social primary-social clear-list">
                <li><a><span class="ace-icon ace-icon-qq"></span></a></li>
                <li><a><span class="ace-icon ace-icon-wechat"></span></a></li>
                <li><a href="https://weibo.com/u/6857791826"><span class="ace-icon ace-icon-weibo"></span></a></li>
                <li><a href="https://github.com/wantao666"><span class="ace-icon ace-icon-github"></span></a></li>
            </ul>
            <p class="title text-upper">欢迎您留下评论</p>
        </header>
    </div>

    <div class="padd-box-sm">
        <form action="#" method="post" class="messageForm">
            <div class="form-group">
                <label class="form-label" for="author">您的昵称</label>
                <div class="form-item-wrap">
                    <input id="comment_user_name" name="comment_user_name" class="form-item" type="text">
                </div>
            </div>
            <div class="form-group">
                <label class="form-label" for="comment">评论</label>
                <div class="form-item-wrap">
                    <textarea id="comment_content" id="comment" class="form-item"></textarea>
                </div>
            </div>

            <div class="form-submit form-item-wrap">
                <input class="btn btn-primary btn-lg" type="submit" value="发表评论">
            </div>
        </form>
    </div>
<!-- 评论显示 -->
			<div id="postcomments">
	<ol id="comment_list" class="commentlist"> </ol>   
	<div class="container-fluid" id="show">    
	<div class="row">
							<div id="page_info" class="col-md-8"></div>
							<div id="page_line" class="col-md-8  offset-md-1"></div>
						</div>
  </div>
  </div>
    <div id="map" data-latitude="50.84592" data-longitude="4.366859999999974"></div>

<!-- END: PAGE CONTENT -->
						
                </div><!-- .ace-paper-cont -->
            </main><!-- .ace-paper -->
        </div><!-- .ace-paper-stock -->

        </div><!-- .ace-container -->
    </div><!-- #ace-content -->
	</div><!-- #ace-sidebar -->

    <footer id="ace-footer" class="ace-container-shift">
        <div class="ace-container">
            <div class="ace-footer-cont clear-mrg">
                <p class="text-center">@上海电机学院 Selenium</p>
            </div>
        </div><!-- .ace-container -->
    </footer><!-- #ace-footer -->

    <!-- Triangle Shapes -->
    <svg id="ace-bg-shape-1" class="hidden-sm hidden-xs" height="519" width="758">
        <polygon points="0,455,693,352,173,0,92,0,0,71" style="fill:#d2d2d2;stroke:purple;stroke-width:0; opacity: 0.5">
    </svg>

    <svg id="ace-bg-shape-2" class="hidden-sm hidden-xs" height="536" width="633">
        <polygon points="0,0,633,0,633,536" style="fill:#c0e3e7;stroke:purple;stroke-width:0" />
    </svg>
</div><!-- .ace-wrapper -->

<!-- Scripts -->
<script type="text/javascript" src="${APP_PATH}/resource/user/template4/js/vendor/jquery-1.12.4.min.js"></script>


<!---<script type="text/javascript" src="http://ditu.google.cn/maps/api/js?key=AIzaSyDiwY_5J2Bkv2UgSeJa4NOKl6WUezSS9XA"></script>--->
<script type="text/javascript" src="${APP_PATH}/resource/user/template4/js/plugins/highlight/highlight.pack.js"></script>
<script type="text/javascript" src="${APP_PATH}/resource/user/template4/js/plugins/jquery.mCustomScrollbar.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/resource/user/template4/js/plugins/isotope.pkgd.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/resource/user/template4/js/plugins/progressbar.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/resource/user/template4/js/plugins/slick.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/resource/user/template4/js/options.js"></script>
<script type="text/javascript" src="${APP_PATH}/resource/user/template4/js/main.js"></script>
<!-- selenium -->
<script src="${APP_PATH}/resource/user/selenium/js/message.js"></script>
</body>
</html>

