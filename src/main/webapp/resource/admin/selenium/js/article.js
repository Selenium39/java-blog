/**
 * author:selenium
 */
var APP_PATH = $("#APP_PATH").val();
$(function(){
	// 查询未读联系人，未读评论，未读留言数量
	selectNotificationCount();
	show_categorys();
	show_tags();
	$("#addFormButton").click(function(){
		addArticle();
		return false;
	});
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

function addArticle(){
	$.ajax({
		url:APP_PATH+"/admin/addArticle",
		type:"post",
		data:$("#addForm").serialize(),
		success:function(){
			alert("文章添加成功");
			$(location).attr("href",APP_PATH+"/admin/articles");
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