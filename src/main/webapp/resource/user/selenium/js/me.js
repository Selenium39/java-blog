/**
 * author:selenium
 */
var APP_PATH = $("#APP_PATH").val();
$(function() {
	selectMe();// 查询个人信息
});
function selectMe() {// 查询个人信息
	$.ajax({
		url : APP_PATH + "/admin/selectMe",
		type : "GET",
		success : function(result) {
			var me = result.data.me;
			$("#name").append(me.name);
			$("#nickname").append(me.nickname);
			me.gender == 0 ? $("#gender").append("female") : $("#gender")
					.append("male");
			$("#age").append(me.age);
			$("#phone").append(me.phone);
			$("#email").append(me.email);
			$("#title").append(me.title);
			$("#viceTitle").append(me.viceTitle);
			$("#introduction").append(me.introduction);
		}
	});
}