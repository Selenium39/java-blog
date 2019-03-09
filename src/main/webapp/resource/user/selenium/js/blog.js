/**
 * author:selenium
 */
var APP_PATH = $("#APP_PATH").val();
$(function(){
	articles(1);
});

function articles(pn){
	$.ajax({
		url:APP_PATH+"/user/selectAllArticle/"+pn,
		type:"get",
		success:function(result){
			var articles=result.data.pageInfo.list;
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
			    var articleContent=$("<p></p>").append(content).append($("<a></a>").append("查看全文"));
			    article.append(articleImage).append(articleHeader).append(articleMeta).append(articleContent).appendTo($("#article_list"));
			});
		}
	});
}