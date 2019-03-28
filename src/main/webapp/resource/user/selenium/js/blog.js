/**
 * author:selenium
 */
var APP_PATH = $("#APP_PATH").val();
var page=1;
$(function(){
	articles(page,0);
	my_time();
	show_navbar();
	show_categorys();
	$("#article_category").change(function(){
		$("#current_category").empty();
		$("#current_category").append("当前分类:"+$("option:selected").text());
		var categoryId=$("option:selected").val();
		$("#current_category").attr("jump",categoryId);
		articles(page,categoryId);
	});
	$("#current_category").click(function(){
		var categoryId=$(this).attr("jump");
		articles(page,categoryId);
	});
	$("#findButton").click(function(){
		find(1);
		return false;
	});
});

function articles(pn,categoryId){
	$.ajax({
		url:APP_PATH+"/user/selectArticle/"+pn,
		data:{
			"categoryId":categoryId,
		},
		type:"get",
		success:function(result){
			$("#article_list").empty();
			$(".category_a").removeAttr("style");
			var articles=result.data.pageInfo.list;
			pages=result.data.pageInfo.pages;
			var categoryId=result.data.categoryId;
			$.each(articles, function(index, item) {
				var content=item.articleContent.substr(0,100)+"...";
				var article=$("<article></article>").addClass("excerpt excerpt-"+item.articleId);
				var articleImage=$("<a></a>").addClass("focus").prop({"title":item.articleTitle,"target":"_blank"})
				.append($("<img></img>").addClass("thumb").attr({"data-original":APP_PATH+"/resource/tag/language.jpg","src":APP_PATH+"/resource/tag/language.jpg","alt":item.articleTitle,"style":"display: inline;"}));
				var articleHeader=$("<header></header>").append($("<a></a>").addClass("cat").attr("title",item.articleTitle).append(item.articleTitle)).append($("<h2></h2>").append($("<a></a>").prop({"title":item.articleTitle,"target":"_blank"})).append(item.articleTitle));
				var articleMeta=$("<p></p>").addClass("meta");
				var time=$("<time></time>").addClass("time").append($("<i></i>").addClass("glyphicon glyphicon-time")).append(item.articleCreateTime);
				var views=$("<span></span>").addClass("views").append($("<i></i>").addClass("glyphicon glyphicon-eye-open")).append(item.articleViewCount);
			    var comment=$("<a></a>").addClass("comment").attr({"title":"comment","target":"_blank"}).append($("<i></i>").addClass("glyphicon glyphicon-comment")).append(item.articleCommentCount);
			    articleMeta.append(time).append(views).append(comment);
			    var articleContent=$("<p></p>").append(content).append($("<a></a>").append("查看全文").attr("target","_blank").prop("href",APP_PATH+"/user/article/"+item.articleId));
			    article.append(articleImage).append(articleHeader).append(articleMeta).append(articleContent).appendTo($("#article_list"));
			});
			$("#category_a_"+categoryId).attr("style","color:red");
			  build_page_info(result);
			  build_page_line(result,categoryId);
		}
	});
}

function my_time(){
	// 获取当前时间时间戳
	var currentTime = Date.now(); 
	// 获取指定时间时间戳
	// 注1：这里写的是2019年3月1日0时0分0秒
	// 注2：Javascript中月份是实际数字减1
	var targetTime = (new Date(2019, 2, 1, 0, 0, 0)).getTime();
	// 获取差值，如果指定日期早于现在，则为负数
	var offsetTime = targetTime - currentTime;
    // 求绝对值，获取相差的时间
	offsetTime = Math.abs(offsetTime);
	// 将时间转位天数
	// 注：Javascript中时间戳的单位是毫秒
	var offsetDays = Math.floor(offsetTime / (3600 * 24 * 1e3));
	$("#my_time").text(offsetDays);	
}

function show_navbar(){//显示导航栏分类
	$.ajax({
		url:APP_PATH+"/user/selectMostArticleCategory4",
		type:"get",
		success:function(result){
			var categorys=result.data.categorys;
			$.each(categorys,function(index,item){
				var category=$("<a></a>").append(item.categoryName).attr("id","category_a_"+item.categoryId).addClass("category_a");
				$("#more").prepend(category);
				$("#category_a_"+item.categoryId).click(function(){
					articles(1,item.categoryId);
				});
			});
		}
	});
}


function show_categorys(){//显示所有的分类
	$.ajax({
		url:APP_PATH+"/user/selectAllCategoryIdAndName",
		type:"get",
		success:function(result){
			var categorys=result.data.categoryIdAndName;
			$("#article_category").append($("<option></option>").append("全部文章").attr("id","category-0").attr("value","0"));
			$.each(categorys,function(index,map){
				  $("<option></option>").append(map.categoryName).attr("id","category-"+map.categoryId).attr("value",map.categoryId).appendTo($("#article_category"));	      
			});
		}
	});
}

function build_page_info(result) {// 构建分页信息
	$("#page_info").empty();// 注意每次构建前都要清空分页
	$("#page_info").append(
			"当前第" + result.data.pageInfo.pageNum + "页,共"
					+ result.data.pageInfo.pages + "页,共"
					+ result.data.pageInfo.total + "条记录")
}

function build_page_line(result,categoryId) {// 构建分页条
	$("#page_line").empty();// 注意每次构建前都要清空分页
	var ul = $("<ul></ul>").addClass("pagination");
	// 首页
	firstPageLi = $("<li></li>").append(
			$("<a></a>").append("首页").attr("href", "#").addClass("page-link"))
			.addClass("page-item");
	// 前一页
	prePageLi = $("<li></li>").append(
			$("<a></a>").append("&laquo;").attr("href", "#").addClass(
					"page-link")).addClass("page-item");
	if (result.data.pageInfo.hasPreviousPage == false) {// 如果当前页是第一页,禁止点击
		firstPageLi.addClass("disabled");
		prePageLi.addClass("disabled");
	}
	firstPageLi.click(function() {// 跳转首页
		articles(1,categoryId);
	});
	prePageLi.click(function() {// 跳转前一页(注意前面虽然禁止了首页跳转,但是只有禁止点击标志,还是可以点击)
		articles(result.data.pageInfo.pageNum == 1 ? 1
				: result.data.pageInfo.pageNum - 1,categoryId)
	})
	ul.append(firstPageLi).append(prePageLi);
	// 下一页
	nextPageLi = $("<li></li>").append(
			$("<a></a>").append("&raquo;").attr("href", "#").addClass(
					"page-link")).addClass("page-item");
	// 末页
	lastPageLi = $("<li></li>").append(
			$("<a></a>").append("末页").attr("href", "#").addClass("page-link"))
			.addClass("page-item");
	if (result.data.pageInfo.hasNextPage == false) {// 如果当前页是最后一页禁止点击
		lastPageLi.addClass("disabled");
		nextPageLi.addClass("disabled");
	}
	lastPageLi.click(function() {// 跳转最后一页
		articles(result.data.pageInfo.pages,categoryId);
	});
	nextPageLi
			.click(function() {// 跳转下一页(注意前面虽然禁止了末页跳转,但是只有禁止点击标志,还是可以点击,或者在pagehelper的配置中设置reasonable属性)
				articles(result.data.pageInfo.pageNum == result.data.pageInfo.pages ? result.data.pageInfo.pages
						: result.data.pageInfo.pageNum + 1,categoryId)
			})
	$.each(result.data.pageInfo.navigatepageNums, function(index, item) {// 页数的生成与跳转
		var numLi = $("<li></li>").append(
				$("<a></a>").append(item).attr("href", "#").addClass(
						"page-link")).addClass("page-item");
		if (result.data.pageInfo.pageNum == item) {
			numLi.addClass("active");
		}
		numLi.click(function() {
			articles(item,categoryId);
		})
		ul.append(numLi);
	})
	ul.append(nextPageLi).append(lastPageLi);
	var nav = $("<nav></nav>").append(ul).attr("style","margin-left:350px;");
	$("#page_line").append(nav).addClass("offset-md-7");
}

function find(pn){
	$.ajax({
		url:APP_PATH+"/user/selectArticleByKeyword/"+pn,
		type:"post",
		data:$("#findArticleForm").serialize(),
		success:function(result){
			find_show(result);
		}
	});
}

function find_show(result){
	$("#article_list").empty();
	$("#page_info").empty();
	$("#page_line").empty();
	var ky_articles=result.data.pageInfo.list;
	var flag=$.isEmptyObject(ky_articles);
	if(flag==false){
	$.each(ky_articles, function(index, item) {
		var content=item.articleContent.substr(0,100)+"...";
		var article=$("<article></article>").addClass("excerpt excerpt-"+item.articleId);
		var articleImage=$("<a></a>").addClass("focus").prop({"title":item.articleTitle,"target":"_blank"})
		.append($("<img></img>").addClass("thumb").attr({"data-original":APP_PATH+"/resource/tag/language.jpg","src":APP_PATH+"/resource/tag/language.jpg","alt":item.articleTitle,"style":"display: inline;"}));
		var articleHeader=$("<header></header>").append($("<a></a>").addClass("cat").attr("title",item.articleTitle).append(item.articleTitle)).append($("<h2></h2>").append($("<a></a>").prop({"title":item.articleTitle,"target":"_blank"})).append(item.articleTitle));
		var articleMeta=$("<p></p>").addClass("meta");
		var time=$("<time></time>").addClass("time").append($("<i></i>").addClass("glyphicon glyphicon-time")).append(item.articleCreateTime);
		var views=$("<span></span>").addClass("views").append($("<i></i>").addClass("glyphicon glyphicon-eye-open")).append(item.articleViewCount);
	    var comment=$("<a></a>").addClass("comment").attr({"title":"comment","target":"_blank"}).append($("<i></i>").addClass("glyphicon glyphicon-comment")).append(item.articleCommentCount);
	    articleMeta.append(time).append(views).append(comment);
	    var articleContent=$("<p></p>").append(content).append($("<a></a>").append("查看全文").attr("target","_blank").prop("href",APP_PATH+"/user/article/"+item.articleId));
	    article.append(articleImage).append(articleHeader).append(articleMeta).append(articleContent).appendTo($("#article_list"));
	      build_page_info(result);
		  build_find_page_line(result);
	});
	}else{
		alert("没有找到相关的文章，换个关键字试试吧");
		window.location.reload();
	}
}

function build_find_page_line(result) {// 构建分页条
	$("#page_line").empty();// 注意每次构建前都要清空分页
	var ul = $("<ul></ul>").addClass("pagination");
	// 首页
	firstPageLi = $("<li></li>").append(
			$("<a></a>").append("首页").attr("href", "#").addClass("page-link"))
			.addClass("page-item");
	// 前一页
	prePageLi = $("<li></li>").append(
			$("<a></a>").append("&laquo;").attr("href", "#").addClass(
					"page-link")).addClass("page-item");
	if (result.data.pageInfo.hasPreviousPage == false) {// 如果当前页是第一页,禁止点击
		firstPageLi.addClass("disabled");
		prePageLi.addClass("disabled");
	}
	firstPageLi.click(function() {// 跳转首页
		find(1);
	});
	prePageLi.click(function() {// 跳转前一页(注意前面虽然禁止了首页跳转,但是只有禁止点击标志,还是可以点击)
		find(result.data.pageInfo.pageNum == 1 ? 1
				: result.data.pageInfo.pageNum - 1)
	})
	ul.append(firstPageLi).append(prePageLi);
	// 下一页
	nextPageLi = $("<li></li>").append(
			$("<a></a>").append("&raquo;").attr("href", "#").addClass(
					"page-link")).addClass("page-item");
	// 末页
	lastPageLi = $("<li></li>").append(
			$("<a></a>").append("末页").attr("href", "#").addClass("page-link"))
			.addClass("page-item");
	if (result.data.pageInfo.hasNextPage == false) {// 如果当前页是最后一页禁止点击
		lastPageLi.addClass("disabled");
		nextPageLi.addClass("disabled");
	}
	lastPageLi.click(function() {// 跳转最后一页
		find(result.data.pageInfo.pages);
	});
	nextPageLi
			.click(function() {// 跳转下一页(注意前面虽然禁止了末页跳转,但是只有禁止点击标志,还是可以点击,或者在pagehelper的配置中设置reasonable属性)
				find(result.data.pageInfo.pageNum == result.data.pageInfo.pages ? result.data.pageInfo.pages
						: result.data.pageInfo.pageNum + 1)
			})
	$.each(result.data.pageInfo.navigatepageNums, function(index, item) {// 页数的生成与跳转
		var numLi = $("<li></li>").append(
				$("<a></a>").append(item).attr("href", "#").addClass(
						"page-link")).addClass("page-item");
		if (result.data.pageInfo.pageNum == item) {
			numLi.addClass("active");
		}
		numLi.click(function() {
			find(item);
		})
		ul.append(numLi);
	})
	ul.append(nextPageLi).append(lastPageLi);
	var nav = $("<nav></nav>").append(ul).attr("style","margin-left:350px;");
	$("#page_line").append(nav).addClass("offset-md-7");
}


