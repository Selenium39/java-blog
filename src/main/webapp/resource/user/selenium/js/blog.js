/**
 * author:selenium
 */
var APP_PATH = $("#APP_PATH").val();
var pages=null;
var page=1;
$(function(){
	articles(page);
	my_time();
	$("#show_more").click(function(){
		if(page<=pages){
			page++;
			articles(page);
		}else{
			$("#show_more").text("已经到最底部了!!!");
		}
	});
	$("#find").click(function(){
		return;
	});
});

function articles(pn){
	$.ajax({
		url:APP_PATH+"/user/selectAllArticle/"+pn,
		type:"get",
		success:function(result){
			var articles=result.data.pageInfo.list;
			pages=result.data.pageInfo.pages;
			$.each(articles, function(index, item) {
				var content=item.articleContent.substr(0,100)+"...";
				var article=$("<article></article>").addClass("excerpt excerpt-"+item.articleId);
				var articleImage=$("<a></a>").addClass("focus").prop({"title":item.articleTitle,"target":"_blank"})
				.append($("<img></img>").addClass("thumb").attr({"data-original":APP_PATH+"/resource/tag/java.jpg","src":APP_PATH+"/resource/tag/java.jpg","alt":item.articleTitle,"style":"display: inline;"}));
				var articleHeader=$("<header></header>").append($("<a></a>").addClass("cat").attr("title",item.articleTitle).append(item.articleTitle)).append($("<h2></h2>").append($("<a></a>").prop({"title":item.articleTitle,"target":"_blank"})).append(item.articleTitle));
				var articleMeta=$("<p></p>").addClass("meta");
				var time=$("<time></time>").addClass("time").append($("<i></i>").addClass("glyphicon glyphicon-time")).append(item.articleCreateTime);
				var views=$("<span></span>").addClass("views").append($("<i></i>").addClass("glyphicon glyphicon-eye-open")).append(item.articleViewCount);
			    var comment=$("<a></a>").addClass("comment").attr({"title":"comment","target":"_blank"}).append($("<i></i>").addClass("glyphicon glyphicon-comment")).append(item.articleCommentCount);
			    articleMeta.append(time).append(views).append(comment);
			    var articleContent=$("<p></p>").append(content).append($("<a></a>").append("查看全文").prop("href",APP_PATH+"/user/article/"+item.articleId));
			    article.append(articleImage).append(articleHeader).append(articleMeta).append(articleContent).appendTo($("#article_list"));
			});
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
