/**
 * Author:Selenium
 */
var APP_PATH = $("#APP_PATH").val();
$(function() {
	// 查询未读联系人数量
	selectNewContactCount();
	// 查询所有的评论并显示在分页中
	comments(1);
	// 为批量删除按钮绑定事件
	$("#batchDeleteButton").click(function() {
		deleteCommentByBatchById();
	});
	// 为跳转任意页面按钮绑定事件
	$("#jumpButton").click(function() {
		var pn = $("#page_number").val();
		// 记得要做校验
		comments(pn);
	});

});

function comments(pn) {// 查询所有的用户并显示在分页中
	$
			.ajax({
				url : APP_PATH + "/admin/selectAllComment/" + pn,
				type : "GET",
				success : function(result) {
					var comments = result.data.pageInfo.list;
					$("#comments").empty();
					$
							.each(
									comments,
									function(index, item) {
										var tr = $("<tr></tr>");
										var checkbox = $("<td></td>")
												.append(
														$("<input type='checkbox' class='check_item' />"))

										var commentId = $("<td></td>").append(
												item.commentId);
										var commentArticleId = $("<td></td>")
												.append(item.commentArticleId);
										var commentUserName = $("<td></td>")
												.append(item.commentUserName);
										var commentUserEmail = $("<td></td>")
												.append(item.commentUserEmail);
										var commentContent = $("<td></td>")
												.append(item.commentContent);
										var commentIp = $("<td></td>").append(
												item.commentIp);
										var commentCreateTime = $("<td></td>")
												.append(item.commentCreateTime);
										var buttons = $("<td></td>");
										var deleteButton = $(
												"<button></button>").append(
												"删除").attr("class",
												"btn btn-danger").attr("id",
												"btn-delete-" + item.commentId);
										buttons.append(deleteButton);
										tr.append(checkbox).append(commentId)
												.append(commentArticleId)
												.append(commentUserName)
												.append(commentUserEmail)
												.append(commentContent)
												.append(commentIp)
												.append(commentCreateTime)
												.append(buttons)
												.appendTo($("#comments"));
										build_page_info(result);
										build_page_line(result);
										// 批量选择的选择框全选或者不全选
										selectCheckBox();
										// 为按钮绑定事件
										$("#btn-delete-" + item.commentId)
												.click(
														function() {
															var flag = confirm("是否删除id为:"
																	+ item.commentId
																	+ "的评论?");
															if (flag == true) {
																deleteCommentById(item.commentId);
															}
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

function build_page_line(result) {// 构建分页条
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
		comments(1);
	});
	prePageLi.click(function() {// 跳转前一页(注意前面虽然禁止了首页跳转,但是只有禁止点击标志,还是可以点击)
		comments(result.data.pageInfo.pageNum == 1 ? 1
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
		comments(result.data.pageInfo.pages);
	});
	nextPageLi
			.click(function() {// 跳转下一页(注意前面虽然禁止了末页跳转,但是只有禁止点击标志,还是可以点击,或者在pagehelper的配置中设置reasonable属性)
				comments(result.data.pageInfo.pageNum == result.data.pageInfo.pages ? result.data.pageInfo.pages
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
			comments(item);
		})
		ul.append(numLi);
	})
	ul.append(nextPageLi).append(lastPageLi);
	var nav = $("<nav></nav>").append(ul).addClass();
	$("#page_line").append(nav).addClass("offset-md-7");
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

function deleteCommentById(commentId) {// 删除单个
	$.ajax({
		url : APP_PATH + "/admin/deleteCommentById",
		type : "get",
		data : {
			"commentId" : commentId
		},
		success : function(result) {
			window.location.reload();
		}
	});
}

function deleteCommentByBatchById() {// 批量删除
	var commentId = "";
	var commentIdShow = "";
	$.each($(".check_item:checked"), function() {
		commentId += $(this).parents("tr").find("td:eq(1)").text() + "-";
		commentIdShow += $(this).parents("tr").find("td:eq(1)").text() + " ";
	});
	var flag = confirm("是否批量删除id为:" + commentIdShow + "的评论?");
	if (flag == true) {
		$.ajax({
			url : APP_PATH + "/admin/deleteCommentById",
			type : "get",
			data : {
				"commentId" : commentId
			},
			success : function(result) {
				window.location.reload();
			}
		});
	}
}

function selectNewContactCount() {// 查询未读联系人的数量
	$.ajax({
		url : APP_PATH + "/admin/selectNewContactCount",
		type : "get",
		success : function(result) {
			$("#new_contact_count").append(result.data.newContactCount);
		}
	});
}