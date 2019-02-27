package com.wantao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wantao
 * @date 2019-02-13 23:02
 * @description: 控制前台逻辑
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	
//---------------------------控制页面跳转-----------------------
	/**
	 * @param
	 * @return String
	 * @description 跳转首页
	 */
	@RequestMapping("/index")
	public String index() {
		return "user/index";
	}

	/**
	 * @param
	 * @return String
	 * @description 跳转个人信息页面
	 */
	@RequestMapping("/aboutMe")
	public String aboutMe() {
		return "user/me";
	}
	

//---------------------------ajax请求获取数据-----------------------	
	
}
