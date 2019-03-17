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
<title>article</title>
<meta name="keywords" content="">
<meta name="description" content="">
<link rel="stylesheet" type="text/css"
	href="${APP_PATH}/resource/user/template3/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${APP_PATH}/resource/user/template3/css/nprogress.css">
<link rel="stylesheet" type="text/css"
	href="${APP_PATH}/resource/user/template3/css/style.css">
<link rel="stylesheet" type="text/css"
	href="${APP_PATH}/resource/user/template3/css/font-awesome.min.css">
<link rel="icon" href="${APP_PATH}/resource/image/logo.icon"
	type="image/x-icon" />
<link rel="stylesheet" type="text/css"
	href="${APP_PATH}/resource/user/selenium/css/article.css"  />
		<link rel="stylesheet" href="${APP_PATH}/resource/user/template5/css/style.css">
<script  src="${APP_PATH}/resource/user/template5/js/index.js"></script>	
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
<body class="user-select single">
	<input id="APP_PATH" type="hidden" value="${APP_PATH}" />
	<input id="ARTICLE_ID" type="hidden" value="${ARTICLE_ID}" />
	<header class="header">
		<nav class="navbar navbar-default" id="navbar">
			<div class="container">
				<div class="header-topbar hidden-xs link-border">
					<!-- 右上角标签栏 -->
					<!--  <ul class="site-nav topmenu">
						<a>navbar</a>-->
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
						<li><a title="index" href="${APP_PATH}/user/index">首页</a></li>
					    <li><a title="blog" href="${APP_PATH}/user/blog">博客</a></li>
					    <li><a title="index" href="${APP_PATH}/user/message">留言</a></li>
					    <li><a title="index" href="${APP_PATH}/user/aboutMe">关于我</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>

	<section class="container">
		<div class="content-wrap">
			<div class="content">
				<!--文章  -->
				<header class="article-header">
					<!-- 文章标题 -->
					<h1 class="article-title">
						<a id="article_title"></a>
					</h1>
					<!-- 文章有关内容 -->
					<div class="article-meta">
						<span class="item article-meta-time">
						    <time class="time"
								data-toggle="tooltip" data-placement="bottom"
								id="article_time">
								  <i class="glyphicon glyphicon-time"></i>
							</time>
						</span>
					   <span class="item article-meta-source" data-toggle="tooltip"
							data-placement="bottom"
							id="article_author">
							<i class="glyphicon glyphicon-globe"></i>
					   </span>
					   <span class="item article-meta-category" data-toggle="tooltip"
							data-placement="bottom">
							<i class="glyphicon glyphicon-list"> </i> 
							<a href="#" id="article_category"></a>
					   </span>
					   <span class="item article-meta-views" data-toggle="tooltip"
							data-placement="bottom" id="article_view_count" >
							<i class="glyphicon glyphicon-eye-open"></i></span> 
							<span class="item article-meta-comment" data-toggle="tooltip"
							data-placement="bottom" id="article_comment_count">
							<i class="glyphicon glyphicon-comment"></i> 
					   </span>
					</div>
				</header>
				<!-- 文章内容 -->
				<article class="article-content">
				    <p id="article_content"></p>
					<div class="bdsharebuttonbox">
						<a href="#" class="bds_more" data-cmd="more"></a><a href="#"
							class="bds_qzone" data-cmd="qzone" title="qzone"></a><a
							href="#" class="bds_tsina" data-cmd="tsina"
							title="weibo"></a><a href="#"
							class="bds_weixin" data-cmd="weixin" title="wexin"></a><a
							href="#" class="bds_tieba" data-cmd="tieba"
							title="tieba"></a><a href="#" class="bds_sqq"
							data-cmd="sqq" title="qq"></a>
					</div>

					<script>
						window._bd_share_config = {
							"common" : {
								"bdSnsKey" : {},
								"bdText" : "",
								"bdMini" : "2",
								"bdMiniList" : false,
								"bdPic" : "",
								"bdStyle" : "1",
								"bdSize" : "32"
							},
							"share" : {}
						};
						with (document)
							0[(getElementsByTagName('head')[0] || body)
									.appendChild(createElement('script')).src = 'http://bdimg.share.baidu.com/static/api/js/share.js?v=0.js?cdnversion='
									+ ~(-new Date() / 36e5)];
					</script>
				</article>
				<!-- 文章标签 -->
				<div class="article-tags" id="tagDiv">
					
				</div>

				<!-- 相关推荐 -->
				<div style="font-size:20px;">
					<div>
					<h2>相关推荐</h2>
					</div>
					<div>
					   <ul id="relate_recommend"></ul>
					</div>
				</div>
				
				<!-- 文章评论 -->
				<div id="comment">
					<h3>文章评论</h3>
				</div>
				<!--添加评论-->
				<div>
					<form class="form-horizontal" role="form" id="comment_form">
	<div class="form-group">
		<div class="col-sm-10">
			<input type="text" class="form-control a" name="commentUserName" 
				   placeholder="您的昵称(必填)">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-10">
			<input type="text" class="form-control a" name="commentUserEmail" 
				   placeholder="您的邮箱(非必填)">
		</div>
	</div>
	<div class="form-group">
	 <div class="col-sm-10">
    <textarea class="form-control a" rows="3" placeholder="您的评论或留言" name="commentContent" ></textarea>
    </div>
  </div>
  <div class="form-group">
     <div class="col-sm-10">
      <button type="button" id="comment_submit_button">评论</button>
     </div>
  </div>
</form>
</div>
<br/>
				<!-- 评论显示 -->
				<div id="postcomments">
					<ol id="comment_list" class="commentlist">
					</ol>
				</div>
			</div>
		</div>

		<aside class="sidebar">
			<div class="fixed">
				<!--右侧信息页面  -->
				<div class="widget widget-tabs">		
					<div class="tab-content">
						<div role="tabpanel" class="tab-pane contact active" id="notice">
							<h2>站长:万涛</h2>
							<h2>已维护<span id="my_time"></span>天</h2>
						</div>
						<div role="tabpanel" class="tab-pane contact" id="contact">
							<h2>QQ:895484122</h2>
                            <h2>微信:wt895484122</h2>
						</div>
					</div>
				</div>
				<div class="widget widget_search">
					<form class="navbar-form" action="#" method="post">
						<div class="input-group">
							<input type="text" name="keyword" class="form-control" size="35"
								placeholder="请输入关键字" maxlength="15"
								autocomplete="off"> <span class="input-group-btn">
								<button class="btn btn-default btn-search" name="search"
									type="submit">查找</button>
							</span>
						</div>
					</form>
				</div>
			</div>
			<!-- 右侧日历 -->
			<div class="widget widget_hot">
				<div  class="calendar">
	             <div class="header">
		           <a data-action="prev-month" href="javascript:void(0)" title="Previous Month"><i></i></a>
		            <div class="text" data-render="month-year"></div>
		             <a data-action="next-month" href="javascript:void(0)" title="Next Month"><i></i></a>
	              </div>
	              <div class="months" data-flow="left">
		          <div class="month month-a">
			      <div class="render render-a"></div>
		    </div>
		   <div class="month month-b">
			<div class="render render-b"></div>
		</div>
	</div>
</div>
				
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
				Copyright &copy; 2016.Company name All rights reserved.More
				Templates <a href="http://www.cssmoban.com/" target="_blank"
					title="æ¨¡æ¿ä¹å®¶">æ¨¡æ¿ä¹å®¶</a> - Collect from <a
					href="http://www.cssmoban.com/" title="ç½é¡µæ¨¡æ¿"
					target="_blank">ç½é¡µæ¨¡æ¿</a>
			</p>
		</div>
		<div id="gotop">
			<a class="gotop"></a>
		</div>
	</footer>
	<script src="${APP_PATH}/resource/user/template3/js/bootstrap.min.js"></script>
	<script src="${APP_PATH}/resource/user/template3/js/jquery.ias.js"></script>
	<script src="${APP_PATH}/resource/user/template3/js/scripts.js"></script>
	<!-- Selenium -->
	<script src="${APP_PATH}/resource/user/selenium/js/article.js"></script>
    
</body>
</html>
