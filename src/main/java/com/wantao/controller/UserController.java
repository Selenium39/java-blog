package com.wantao.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wantao.bean.Contact;
import com.wantao.bean.Me;
import com.wantao.service.ContactService;
import com.wantao.service.MeService;
import com.wantao.util.Message;

/**
 * @author wantao
 * @date 2019-02-13 23:02
 * @description: 控制前台逻辑
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	MeService meService;
	@Autowired
	ContactService contactService;
	private static final Logger logger = LoggerFactory.getLogger("UserController.class");

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
	/**
	 * @param
	 * @return Message
	 * @description 查询个人信息
	 */
	@GetMapping("/selectMe")
	@ResponseBody
	public Message selectMe() {
		Me me = meService.selectMe();
		return Message.success().add("me", me);
	}

	/**
	 * @param
	 * @return Message
	 * @description 增加联系人
	 */
	@PostMapping("/aboutMe")
	public String addContact(Contact contact,HttpServletRequest request) {
		contact.setSendTime(new SimpleDateFormat("yyyy-mm-dd  HH:mm:ss").format(new Date()));
		contact.setSendIp(request.getRemoteAddr());
		contactService.addContact(contact);
		return "user/me";
	}

}
