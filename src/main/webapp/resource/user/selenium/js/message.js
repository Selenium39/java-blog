/**
 * author:selenium
 */
var APP_PATH = $("#APP_PATH").val();
$(function(){
	messages(1);
});

function messages(pn){
	$.ajax({
		url:APP_PATH+"/user/selectAllMessage/"+pn,
		type:"get",
		success:function(result){
			$("#comment_list").empty();
			var messages=result.data.pageInfo.list;
			var page_number=result.data.pageInfo.pageNum;
			var count=(page_number-1)*5+1;
			$.each(messages,function(index,item){
				number=$("<li></li>").addClass("comment-content").append($("<span></span>").addClass("comment-f").append("#"+count));
				commentDiv=$("<div></div>").addClass("comment-main");
				commentDiv.append($("<p style='color:blue;font-size:30px;'></p>").append($("<a class='address' rel='nofollow'></a>")).append(item.messageUserName).append($("<span style='color:red;'></span>").addClass("time").append(item.messageCreateTime).append($("<br>")).append($("<p style='color:black;font-size:20px;'></p>").append(item.messageContent))));
				$("#comment_list").append(number).append(commentDiv);
				++count;
			});
			build_page_info(result);
			build_page_line(result);
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
		messages(1);
	});
	prePageLi.click(function() {// 跳转前一页(注意前面虽然禁止了首页跳转,但是只有禁止点击标志,还是可以点击)
		messages(result.data.pageInfo.pageNum == 1 ? 1
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
		messages(result.data.pageInfo.pages);
	});
	nextPageLi
			.click(function() {// 跳转下一页(注意前面虽然禁止了末页跳转,但是只有禁止点击标志,还是可以点击,或者在pagehelper的配置中设置reasonable属性)
				messages(result.data.pageInfo.pageNum == result.data.pageInfo.pages ? result.data.pageInfo.pages
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
			messages(item);
		})
		ul.append(numLi);
	})
	ul.append(nextPageLi).append(lastPageLi);
	var nav = $("<nav></nav>").append(ul).addClass();
	$("#page_line").append(nav).addClass("offset-md-7");
}
