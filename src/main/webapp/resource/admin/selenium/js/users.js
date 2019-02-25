/**
 * Author:Selenium
 */
var APP_PATH = $("#APP_PATH").val();
$(function() {
	// 查询所有的用户并显示在分页中
	users(1);
	// 为修改按钮绑定事件
	$("#updateButton").click(function() {
		update($(this));
	});
	// 为批量删除按钮绑定事件
	$("#batchDeleteButton").click(function() {
		deleteUserByBatchById();
	});
	//为新增按钮绑定事件
	$("#addButton").click(function(){
		add();
	});
});

function users(pn) {// 查询所有的用户并显示在分页中
	$.ajax({
		url : APP_PATH + "/admin/selectAllUser/" + pn,
		type : "GET",
		success : function(result) {
			var users = result.data.pageInfo.list;
			$("#users").empty();
			$.each(users, function(index, item) {
				var tr = $("<tr></tr>");
				var checkbox = $("<td></td>").append(
						$("<input type='checkbox' class='check_item' />"))
				var id = $("<td></td>").append(item.userId);
				var name = $("<td></td>").append(item.userName);
				var nickname = $("<td></td>").append(item.userNickname);
				var lastLoginTime = $("<td></td>").append(
						item.userLastLoginTime);
				var lastLoginIp = $("<td></td>").append(item.userLastLoginIp);
				var buttons = $("<td></td>");
				var showButton = $("<button></button>").append("查看").attr(
						"class", "btn btn-info").attr("id",
						"btn-show-" + item.userId);
				var updateButton = $("<button></button>").append("修改").attr(
						"class", "btn btn-success").attr("id",
						"btn-update-" + item.userId);
				var deleteButton = $("<button></button>").append("删除").attr(
						"class", "btn btn-danger").attr("id",
						"btn-delete-" + item.userId);
				buttons.append(showButton).append(" ").append(updateButton)
						.append(" ").append(deleteButton);
				tr.append(checkbox).append(id).append(name).append(nickname)
						.append(lastLoginTime).append(lastLoginIp).append(
								buttons).appendTo($("#users"));
				build_page_info(result);
				build_page_line(result);
				// 批量选择的选择框全选或者不全选
				selectCheckBox();
				// 为按钮绑定事件
				$("#btn-show-" + item.userId).click(function() {
					build_show_modal(item.userId);
				});
				$("#btn-update-" + item.userId).click(function() {
					build_update_modal(item.userId);
				});
				$("#btn-delete-" + item.userId).click(function() {
					var flag = confirm("是否删除" + item.userName + "?");
					if (flag == true) {
						deleteUserById(item.userId);
					}
				});
			});

		}
	});
}

/**
 * @param userId
 *            用户id
 * @param userName
 *            用户姓名
 * @param userPassword
 *            用户密码
 * @param userNickname
 *            用户昵称
 * @param userEmail
 *            用户邮箱
 * @param userUrl
 * @param userAvatar
 *            用户头像
 * @param userLastLoginIp
 *            用户登录ip
 * @param userRegisterTime
 *            用户注册时间
 * @param userLastLoginTime
 *            用户上次登录时间
 * @param userStatus
 *            用户状态
 * @param articleCount
 */

function build_show_modal(userId) { // 构建查看模态框
	$.ajax({
		url : APP_PATH + "/admin/selectUserById/" + userId,
		type : "GET",
		success : function(result) {
			var user = result.data.user;
			$(".s").empty();
			$("#showTitle").append(user.userId);
			$("#userId").append(user.userId);
			$("#userName").append(user.userName);
			$("#userPassword").append(user.userPassword);
			$("#userNickname").append(user.userNickname);
			$("#userEmail").append(user.userEmail);
			$("#userAvatar").append(
					$("<img></img>").prop(
							"src",
							user.userAvatar == null ? APP_PATH
									+ '/resource/avatar/avatar.jpg' : APP_PATH
									+ user.userAvatar).addClass(
							"rounded-circle").prop("height", 150));
			$("#userLastLoginIp").append(user.userLastLoginIp);
			$("#userRegisterTime").append(user.userRegisterTime);
			$("#userLastLoginTime").append(user.userLastLoginTime);
			$("#userStatus").append(user.userStatus == 0 ? "无效账户" : "有效账户");
			$('#myShowModal').modal({});
		}
	});
}

function build_update_modal(userId) { // 构建修改模态框
	$.ajax({
		url : APP_PATH + "/admin/selectUserById/" + userId,
		type : "GET",
		success : function(result) {
			$(".u").empty();
			$("#updateForm")[0].reset();
			var user = result.data.user;
			$("#photo").change(function() {
				showImgOnTime();
			});
			$("#userName1").append(user.userName);
			$("#userPassword1").val(user.userPassword);
			$("#eye").click(function() {//控制密码是否可见
				if ($("#eye").attr("show") == "false") {
					$("#eye").attr("show", "true");
					$("#userPassword1").attr("type", "text");
				} else {
					$("#eye").attr("show", "false");
					$("#userPassword1").attr("type", "password");
				}
			});
			$("#userNickname1").val(user.userNickname);
			$("#userEmail1").val(user.userEmail);
			$("#userAvatar1").prop(
					"src",
					user.userAvatar == null ? APP_PATH
							+ '/resource/avatar/avatar.jpg' : APP_PATH
							+ user.userAvatar).addClass("rounded-circle").prop(
					"height", 150);
			user.userStatus == 0 ? $("#status0").attr("selected", "selected")
					: $("#status1").attr("selected", "selected");
			$("#updateButton").attr("update-id", user.userId);
			$('#myUpdateModal').modal({});
		}
	});
}

function showImgOnTime() { // 发送ajax请求实时显示修改的照片
	var formData = new FormData($("#updateForm")[0]);
	formData.append("file", $("#photo")[0]);// ajax文件上传
	$.ajax({
		url : APP_PATH + "/admin/showImgOnTime",
		type : "post",
		data : formData,
		cache : false,
		contentType : false,
		processData : false,
		success : function(result) {
			$("#userAvatar1").prop("src", APP_PATH + result.data.imgUrl);
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
		users(1);
	});
	prePageLi.click(function() {// 跳转前一页(注意前面虽然禁止了首页跳转,但是只有禁止点击标志,还是可以点击)
		users(result.data.pageInfo.pageNum == 1 ? 1
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
		users(result.data.pageInfo.pages);
	});
	nextPageLi
			.click(function() {// 跳转下一页(注意前面虽然禁止了末页跳转,但是只有禁止点击标志,还是可以点击,或者在pagehelper的配置中设置reasonable属性)
				users(result.data.pageInfo.pageNum == result.data.pageInfo.pages ? result.data.pageInfo.pages
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
			users(item);
		})
		ul.append(numLi);
	})
	ul.append(nextPageLi).append(lastPageLi);
	var nav = $("<nav></nav>").append(ul).addClass();
	$("#page_line").append(nav).addClass("offset-md-7");
}

function update(button) {// 修改用户
	var formData = new FormData($("#updateForm")[0]);
	formData.append("file", $("#photo")[0]);// ajax文件上传
	formData.append("userId", button.attr("update-id"));
	$.ajax({
		url : APP_PATH + "/admin/updateUserById",
		type : "post",
		data : formData,
		cache : false,
		contentType : false,
		processData : false,
		success : function(result) {
			$('#myUpdateModal').modal('hide');
			window.location.reload();
		}
	});
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

function deleteUserById(userId) {// 删除单个
	$.ajax({
		url : APP_PATH + "/admin/deleteUserById",
		type : "get",
		data : {
			"userId" : userId
		},
		success : function(result) {
			window.location.reload();
		}
	});
}

function deleteUserByBatchById() {// 批量删除
	var userId = "";
	var userName = "";
	$.each($(".check_item:checked"), function() {
		userId += $(this).parents("tr").find("td:eq(1)").text() + "-";
		userName += $(this).parents("tr").find("td:eq(2)").text() + " ";
	});
	userName = userName.substring(0, userName.length - 1);
	var flag = confirm("是否删除用户" + userName + "?");
	if (flag == true) {
		$.ajax({
			url : APP_PATH + "/admin/deleteUserById",
			type : "get",
			data : {
				"userId" : userId
			},
			success : function(result) {
				window.location.reload();
			}
		});
	}
}


function add(){//增加新用户
	$("#userAvatar2").attr("src",null);
	$("#addForm")[0].reset();
	$(".a").empty();
	$('#myAddModal').modal({});
	$("#eye2").click(function() {//控制密码是否可见
		if ($("#eye").attr("show") == "false") {
			$("#eye").attr("show", "true");
			$("#userPassword2").attr("type", "text");
		} else {
			$("#eye").attr("show", "false");
			$("#userPassword2").attr("type", "password");
		}
	});
	$("#photo2").change(function() {//ajax实时显示上传的照片
		showImgOnTime2();
	});
	$("#addButtonFinish").click(function(){
		var formData = new FormData($("#addForm")[0]);
		formData.append("file", $("#photo2")[0]);// ajax文件上传
		$.ajax({
			url : APP_PATH + "/admin/addUser",
			type : "post",
			data : formData,
			cache : false,
			contentType : false,
			processData : false,
			success : function(result) {
				$('#myAddModal').modal('hide');
				window.location.reload();
			}
		});
	});
}

function showImgOnTime2() { // 发送ajax请求实时显示上传的照片
	var formData = new FormData($("#addForm")[0]);
	formData.append("file", $("#photo2")[0]);// ajax文件上传
	$.ajax({
		url : APP_PATH + "/admin/showImgOnTime",
		type : "post",
		data : formData,
		cache : false,
		contentType : false,
		processData : false,
		success : function(result) {
			$("#userAvatar2").prop("src", APP_PATH + result.data.imgUrl).addClass("rounded-circle").prop(
					"height", 150);
		}

	});
}