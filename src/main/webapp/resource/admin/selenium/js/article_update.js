/**
 * author:selenium
 */
var APP_PATH = $("#APP_PATH").val();
var ARTICLE_ID=$("#ARTICLE_ID").val();
$(function(){
	 var ue = UE.getEditor('editor');
	// 查询未读联系人，未读评论，未读留言数量
	selectNotificationCount();
	show_categorys();
	show_tags();
	ue.ready(function() {
		show_article(ue,ARTICLE_ID);
	});
	show_category_tags(ARTICLE_ID);
});


function selectNotificationCount() {// 查询未读联系人,未读信息，未读留言的数量
	$.ajax({
		url : APP_PATH + "/admin/selectNotificationCount",
		type : "get",
		success : function(result) {
			$("#new_contact_count").append(result.data.newContactCount);
			$("#new_message_count").append(result.data.newMessageCount);
			$("#new_comment_count").append(result.data.newCommentCount);
		}
	});
}

function show_categorys(){
	$.ajax({
		url:APP_PATH+"/admin/selectAllCategoryIdAndName",
		type:"get",
		success:function(result){
			var categorys=result.data.categoryIdAndName;
			$.each(categorys,function(index,map){
				  $("<option></option>").append(map.categoryName).attr("id","category-"+map.categoryId).attr("value",map.categoryId).appendTo($("#article_category"));	      
			});
		}
	});
}

function show_tags(){
	$.ajax({
		url:APP_PATH+"/admin/selectAllTagIdAndName",
		type:"get",
		success:function(result){
			var tags=result.data.tagIdAndName;
			$.each(tags,function(index,map){
				  $("<option></option>").append(map.tagName).attr("id","tag-"+map.tagId).attr("value",map.tagId).appendTo($("#article_tag")); 
			});
		}
	});
}

function show_article(ue,ARTICLE_ID){
	 $.ajax({
		 url:APP_PATH+"/admin/selectArticleById/"+ARTICLE_ID,
		 type:"get",
		 success:function(result){
			var article=result.data.article;
			var articleTitle=article.articleTitle;
			var articleContent=article.articleContent;
			$("#article_title").val(articleTitle);
			ue.setContent(articleContent, true);
		 }
	 });
}

function show_category_tags(ARTICLE_ID){
	$.ajax({
		url:APP_PATH+"/admin/selectArticleTagAndCategoryByArticleId/"+ARTICLE_ID,
		type:"get",
		success:function(result){
			var tags=result.data.tags;
			var category=result.data.category;
			$("#category-"+category.categoryId).attr("selected","selected");
			$.each(tags,function(index,item){
				$("#tag-"+item.tagId).attr("selected","selected");
			})
		}
	});
}