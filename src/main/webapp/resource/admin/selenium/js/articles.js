/**
 * Author:Selenium
 */
var APP_PATH = $("#APP_PATH").val();
$(function() {
	// 查询未读联系人，未读评论，未读留言数量
	selectNotificationCount();
	// 查询所有的文章并显示在分页中
	articles(1,0);
	// 为修改按钮绑定事件
	$("#updateButton").click(function() {
		update($(this));
	});
	// 为批量删除按钮绑定事件
	$("#batchDeleteButton").click(function() {
		deleteArticleByBatchById();
	});
	$("#addButton").click(function(){
		$(location).attr("href",APP_PATH+"/admin/article");
	});
	// 为跳转任意页面按钮绑定事件
	$("#jumpButton").click(function() {
		var pn = $("#page_number").val();
		var type=$(this).attr("jumpType");
		// 记得要做校验
		articles(pn,type);
	});
	$("#articleChoose").change(function() {
		var articleType = $("#articleChoose").val();
		/*
		 * 文章分类: 0.代表所有文章 1.代表有效文章 2.代表无效文章 3.代表置顶文章 4.代表未置顶文章
		 */
		if (articleType == 0) {
			articles(1, 0);
		}
		if (articleType == 1) {
			articles(1, 1);
		}
		if (articleType == 2) {
			articles(1, 2);
		}
		if (articleType == 3) {
			articles(1, 3);
		}
		if (articleType == 4) {
			articles(1, 4);
		}
	});
});

function articles(pn, type) {// 查询所有的文章并显示在分页中
	$.ajax({
		url : APP_PATH + "/admin/selectAllArticle/" + pn,
		type : "GET",
		data : {
			"type" : type,
		},
		success : function(result) {
			var articles = result.data.pageInfo.list;
			var type = result.data.type;
			$("#articles").empty();
			$.each(articles, function(index, item) {
				var tr = $("<tr></tr>");
				var checkbox = $("<td></td>").append(
						$("<input type='checkbox' class='check_item' />"))
				var articleId = $("<td></td>").append(item.articleId);
				var articleUserName = $("<td></td>").append(
						item.articleUserName);
				var articleTitle = $("<td></td>").append(item.articleTitle);
				var articleCreateTime = $("<td></td>").append(
						item.articleCreateTime);
				var buttons = $("<td></td>");
				var showButton = $("<button></button>").append("查看").attr(
						"class", "btn btn-info").attr("id",
						"btn-show-" + item.articleId);
				var updateButton = $("<button></button>").append("修改").attr(
						"class", "btn btn-success").attr("id",
						"btn-update-" + item.articleId);
				var deleteButton = $("<button></button>").append("删除").attr(
						"class", "btn btn-danger").attr("id",
						"btn-delete-" + item.articleId);
				var updateButton1 = $("<button></button>").append("详细修改").attr(
						"class", "btn btn-warning").attr("id",
						"btn-update1-" + item.articleId);
				buttons.append(showButton).append(" ").append(updateButton)
						.append(" ").append(deleteButton).append(" ").append(updateButton1);
				tr.append(checkbox).append(articleId).append(articleUserName)
						.append(articleTitle).append(articleCreateTime).append(
								buttons).appendTo($("#articles"));
				build_page_info(result);
				build_page_line(result, type);
				// 批量选择的选择框全选或者不全选
				selectCheckBox();
				// 为按钮绑定事件
				$("#btn-show-" + item.articleId).click(function() {
					build_show_modal(item.articleId);
				});
				$("#btn-update-" + item.articleId).click(function() {
					build_update_modal(item.articleId);
				});
				$("#btn-delete-" + item.articleId).click(
						function() {
							var flag = confirm("是否删除标题为:<<" + item.articleTitle
									+ ">>的文章?");
							if (flag == true) {
								deleteArticleById(item.articleId);
							}
						});
				$("#btn-update1-" + item.articleId).click(function() {
					$(location).attr("href",APP_PATH+"/admin/updateArticle/"+item.articleId);
				});
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

function build_page_line(result, type) {// 构建分页条
	$("#page_line").empty();// 注意每次构建前都要清空分页
	var ul = $("<ul></ul>").addClass("pagination")
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
		articles(1, type);
	});
	prePageLi.click(function() {// 跳转前一页(注意前面虽然禁止了首页跳转,但是只有禁止点击标志,还是可以点击)
		articles(result.data.pageInfo.pageNum == 1 ? 1
				: result.data.pageInfo.pageNum - 1, type)
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
		articles(result.data.pageInfo.pages, type);
	});
	nextPageLi
			.click(function() {// 跳转下一页(注意前面虽然禁止了末页跳转,但是只有禁止点击标志,还是可以点击,或者在pagehelper的配置中设置reasonable属性)
				articles(
						result.data.pageInfo.pageNum == result.data.pageInfo.pages ? result.data.pageInfo.pages
								: result.data.pageInfo.pageNum + 1, type)
			})
	$.each(result.data.pageInfo.navigatepageNums, function(index, item) {// 页数的生成与跳转
		var numLi = $("<li></li>").append(
				$("<a></a>").append(item).attr("href", "#").addClass(
						"page-link")).addClass("page-item");
		if (result.data.pageInfo.pageNum == item) {
			numLi.addClass("active");
		}
		numLi.click(function() {
			articles(item, type);
		})
		ul.append(numLi);
	})
	ul.append(nextPageLi).append(lastPageLi);
	var nav = $("<nav></nav>").append(ul).addClass();
	$("#page_line").append(nav).addClass("offset-md-7");
	$("#jumpButton").attr("jumpType",type);
}

function selectCheckBox() {// 完成批量删除的checkbox全选or全不选
	$("#checkAll").prop("checked", null);
	$(".check_item")
			.click(
					function() {
						if ($("input[type=checkbox].check_item:checked").length == $(".check_item").length) {
							$("#checkAll").prop("checked", "checked");
						} else {
							$("#checkAll").prop("checked", null);
						}
					});
	$("#checkAll").click(function() {
		// 这里注意dom原生的属性使用prop,自定义属性使用attr
		// alert($(this).prop("checked"));
		$(".check_item").prop("checked", $(this).prop("checked"));
	});
}

/**
 * @param articleId
 *            文章id
 * @param articleUserId
 *            文章作者id
 * @param articleUserName
 *            文章作者name
 * @param articleTitle
 *            文章标题
 * @param articleContent
 *            文章内容
 * @param articleViewCount
 *            文章浏览数量
 * @param articleCommentCount
 *            文章评论数量
 * @param articleDislikeCount
 *            不喜欢的数量
 * @param articleLikeCount
 *            喜欢的数量
 * @param articleIsComment
 *            是否允许评论 1允许评论 0不允许评论
 * @param articleStatus
 *            文章状态 1有效 2无效
 * @param articleOrder
 *            文章顺序 0为置顶1为正常
 * @param articleUpdateTime
 *            文章更新时间
 * @param articleCreateTime
 *            文章创建时间
 * @param tagList
 *            标签列表
 * @param categoryList
 *            分类列表
 */

function build_show_modal(articleId) { // 构建查看模态框
	$.ajax({
		url : APP_PATH + "/admin/selectArticleById/" + articleId,
		type : "GET",
		success : function(result) {
			var article = result.data.article;
			$(".s").empty();
			$("#articleId").append(article.articleId);
			$("#articleUserId").append(article.articleUserId);
			$("#articleUserName").append(article.articleUserName);
			$("#articleTitle").append(article.articleTitle);
			$("#articleViewCount").append(article.articleViewCount);
			$("#articleCommentCount").append(article.articleCommentCount);
			$("#articleDislikeCount").append(article.articleDislikeCount);
			$("#articleLikeCount").append(article.articleLikeCount);
			$("#articleIsComment").append(
					article.articleIsComment == 0 ? "不允许评论" : "允许评论");
			$("#articleStatus")
					.append(article.articleStatus == 0 ? "无效" : "有效");
			$("#articleOrder").append(article.articleOrder == 0 ? "置顶" : "正常");
			$("#articleUpdateTime").append(article.articleUpdateTime);
			$("#articleCreateTime").append(article.articleCreateTime);
			$('#myShowModal').modal({});
		}
	});
}

function build_update_modal(articleId) { // 构建修改模态框
	$.ajax({
		url : APP_PATH + "/admin/selectArticleById/" + articleId,
		type : "GET",
		success : function(result) {
			$(".u").empty();
			$("#updateForm")[0].reset();
			var article = result.data.article;
			$("#articleTitle1").val(article.articleTitle);
			article.articleIsComment == 0 ? $("#articleIsComment0").attr(
					"selected", "selected") : $("#articleIsComment1").attr(
					"selected", "selected");
			article.articleStatus == 0 ? $("#articleStatus0").attr("selected",
					"selected") : $("#articleStatus1").attr("selected",
					"selected");
			article.articleOrder == 0 ? $("#articleOrder0").attr("selected",
					"selected") : $("#articleOrder1").attr("selected",
					"selected");
			$("#updateButton").attr("update-id", article.articleId);
			$('#myUpdateModal').modal({});
		}
	});
}

function update(button) {// 修改文章
	$.ajax({
		url : APP_PATH + "/admin/updateArticleById",
		type : "POST",
		data : $("#updateForm").serialize() + "&articleId="
				+ button.attr("update-id"),
		success : function(result) {
			$('#myUpdateModal').modal('hide');
			window.location.reload();
		}
	});
}

function deleteArticleById(articleId) {// 删除单个
	$.ajax({
		url : APP_PATH + "/admin/deleteArticleById",
		type : "get",
		data : {
			"articleId" : articleId
		},
		success : function(result) {
			window.location.reload();
		}
	});
}

function deleteArticleByBatchById() {// 批量删除
	var articleId = "";
	var articleTitle = "";
	$.each($(".check_item:checked"), function() {
		articleId += $(this).parents("tr").find("td:eq(1)").text() + "-";
		articleTitle += "<<" + $(this).parents("tr").find("td:eq(3)").text()
				+ ">> ";
	});
	articleTitle = articleTitle.substring(0, articleTitle.length - 1);
	var flag = confirm("是否删除标题为" + articleTitle + "的文章?");
	if (flag == true) {
		$.ajax({
			url : APP_PATH + "/admin/deleteArticleById",
			type : "get",
			data : {
				"articleId" : articleId
			},
			success : function(result) {
				window.location.reload();
			}
		});
	}
}

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