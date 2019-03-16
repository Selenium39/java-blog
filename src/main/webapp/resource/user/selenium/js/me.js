/**
 * author:selenium
 */
var APP_PATH = $("#APP_PATH").val();
$(function() {
	selectMe();// 查询个人信息
	$("#submitButton").click(function(){
		addContact();
		return false;//阻止表单的默认提交
	});
});
function selectMe() {// 查询个人信息
	$.ajax({
		url : APP_PATH + "/user/selectMe",
		type : "GET",
		success : function(result) {
			var me = result.data.me;
			$("#name").append(me.name);
			$("#nickname").append(me.nickname);
			me.gender == 0 ? $("#gender").append("女") : $("#gender")
					.append("男");
			$("#age").append(me.age);
			$("#phone").append(me.phone);
			$("#email").append(me.email);
			$("#title").append(me.title);
			$("#viceTitle").append(me.viceTitle);
			$("#introduction").append(me.introduction);
		}
	});
}

function addContact(){
	$.ajax({
		url:APP_PATH+"/user/addContact",
		type:"post",
		data:$("#contactForm").serialize(),
		success:function(result){
			 alert("I have received your letter and I will contact you.");
			 window.location.reload();
		}
	});
}
