/**
 * author:Selenium
 */
var ARTICLE_ID=$("#ARTICLE_ID").val();
var APP_PATH = $("#APP_PATH").val();
$(function(){
	show();
})

function show(){
	$.ajax({
		url:APP_PATH+"/user/selectArticleById",
		type:"get",
		data:{
			"articleId":ARTICLE_ID,
		},
		success:function(result){
			var article=result.data.article;
			var category=result.data.category;
			$("#article_title").append(article.articleTitle);
			$("#article_time").append(article.articleCreateTime).attr({"data-original-title":article.articleCreateTime});
		    $("#article_author").append(article.articleUserName).attr({"data-original-title":article.articleUserName});
		    $("#article_category").append(category.categoryName).attr("data-original-title",category.categoryName);
		}
	});
}