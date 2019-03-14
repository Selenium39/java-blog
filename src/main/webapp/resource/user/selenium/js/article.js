/**
 * author:Selenium
 */
var ARTICLE_ID = $("#ARTICLE_ID").val();
var APP_PATH = $("#APP_PATH").val();
$(function() {
	show();
	// 为评论提交按钮绑定事件
	$("#comment_submit_button").click(function() {
		add_comment($(this).attr("send_id"));
		return false;
	});
})

function show() {
	$.ajax({
		url : APP_PATH + "/user/selectArticleById",
		type : "get",
		data : {
			"articleId" : ARTICLE_ID,
		},
		success : function(result) {
			var article = result.data.article;
			var category = result.data.category;
			var tags = result.data.tags;
			var relateArticles = result.data.relateArticles;
			$("#article_title").append(article.articleTitle);
			// 构建文章
			$("#article_time").append(article.articleCreateTime).attr({
				"data-original-title" : article.articleCreateTime
			});
			$("#article_author").append(article.articleUserName).attr({
				"data-original-title" : article.articleUserName
			});
			$("#article_category").append(category.categoryName).attr(
					"data-original-title", category.categoryName);
			$("#article_view_count").append(article.articleViewCount).attr(
					"data-original-title", article.articleViewCount);
			$("#article_comment_count").append(article.articleCommentCount)
					.attr("data-original-title", article.articleCommentCount);
			$("#article_content").append(article.articleContent);
			$("#comment_submit_button").attr("send_id", article.articleId);
			// 构建文章标签
			var tagString = "标签: ";
			$("#tagDiv").append(tagString);
			$.each(tags, function(index, item) {
				var tag = $("<a></a>").attr({
					"rel" : "tag",
					"draggable" : "false"
				}).append(item.tagName).appendTo($("#tagDiv"));
			});
			var recommend = $("#relate_recommend");
			$.each(relateArticles, function(index, item) {
				recommend.append($("<li></li>").append(
						$("<a></a>").prop("href",
								APP_PATH + "/user/article/" + item.articleId)
								.append(item.articleTitle)));
			})

		}
	});
}

function show_comment(articleId) {
	$.ajax({
		url : APP_PATH + "/user/selectCommentsByArticleId",
		type : "get",
		data : {
			"articleId" : articleId,
		},
		success : function(result) {

		}
	});
}

function add_comment(articleId) {
   $.ajax({
	   url:APP_PATH+"/user/addComment",
	   type:"post",
	   data:$("#comment_form").serialize()+"&commentArticleId="+articleId,
	   success:function(result){
		   $(".a").empty();
		   $("#comment_form")[0].reset();
		   alert("您已成功添加评论!!!");
		   window.location.reload();
	   }
   });
}