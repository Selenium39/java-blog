/**
 * author:selenium
 */
var APP_PATH = $("#APP_PATH").val();
$(function() {
	selectMe();// 查询个人信息
	$("#update").click(function(){//修改个人信息
		build_update_modal();
	});
	$("#updateButton").click(function(){
		update();
	});
});
/**
 * @param id
 *            个人id
 * @param name
 *            个人姓名
 * @param avatar
 *            个人头像
 * @param password
 *            个人密码
 * @param nickname
 *            个人昵称
 * @param gender
 *            个人性别 1:男性 2:女性
 * @param age
 *            个人年龄
 * @param phone
 *            个人电话
 * @param email
 *            个人邮箱
 * @param title
 *            个人简介标题
 * @param viceTitle
 *            个人简介副标题
 * @param introduction
 *            个人简介内容
 */
function selectMe() {// 查询个人信息
	$.ajax({
		url : APP_PATH + "/admin/selectMe",
		type : "GET",
		success : function(result) {
			var me = result.data.me;
			$("#id").append(me.id);
			$("#name").append(me.name);
			$("#avatar").prop(
					"src",
					me.avatar == null ? APP_PATH
							+ '/resource/avatar/avatar.jpg' : APP_PATH
							+ me.avatar).addClass("rounded-circle").prop(
					"height", 150);
			$("#password").append(me.password);
			$("#nickname").append(me.nickname);
			me.gender == 0 ? $("#gender").append("Female") : $("#gender")
					.append("Male");
			$("#age").append(me.age);
			$("#phone").append(me.phone);
			$("#email").append(me.email);
			$("#title").append(me.title);
			$("#viceTitle").append(me.viceTitle);
			$("#introduction").append(me.introduction).prop("readonly","true").attr("rows","10").attr("cols","40");;
		}
	});
}

function build_update_modal(){//构建修改模态框
	$.ajax({
		url : APP_PATH + "/admin/selectMe",
		type : "GET",
		success : function(result) {
			$(".m").empty();
			$("#updateForm")[0].reset();
			var me = result.data.me;
			$("#photo").change(function() {
				showImgOnTime();
			});
			$("#name1").val(me.name);
			$("#password1").val(me.password);
			$("#eye").click(function() {//控制密码是否可见
				if ($("#eye").attr("show") == "false") {
					$("#eye").attr("show", "true");
					$("#password1").attr("type", "text");
				} else {
					$("#eye").attr("show", "false");
					$("#password1").attr("type", "password");
				}
			});
			$("#nickname1").val(me.nickname);
			$("#age1").val(me.age);
			$("#phone1").val(me.phone);
			$("#email1").val(me.email);
			$("#title1").val(me.title);
			$("#viceTitle1").val(me.viceTitle);
			$("#introduction1").val(me.introduction);
			$("#avatar1").prop(
					"src",
					me.avatar == null ? APP_PATH
							+ '/resource/avatar/avatar.jpg' : APP_PATH
							+ me.avatar).addClass("rounded-circle").prop(
					"height", 150);
			me.gender == 0 ? $("#status0").attr("selected", "selected")
					: $("#status1").attr("selected", "selected");
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
			$("#avatar1").prop("src", APP_PATH + result.data.imgUrl);
		}

	});
}

function update() {// 修改个人信息
	var formData = new FormData($("#updateForm")[0]);
	formData.append("file", $("#photo")[0]);// ajax文件上传
	$.ajax({
		url : APP_PATH + "/admin/updateMe",
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