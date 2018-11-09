package com.laziobird.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.laziobird.CommonEnum;
import com.laziobird.bean.User;
import com.laziobird.service.UserService;

/**
 * 
 * @author laziobird
 *
 */
@Controller
public class UserFrontController {

	@Autowired
	private UserService userService;


	/**
	 * 注册用户
	 * 
	 * @param id
	 * @param pass
	 * @param uname
	 * @param phone
	 * @param email
	 * @return
	 */
	@RequestMapping(value = "/registUser", method = RequestMethod.POST)
	public String registUser(Model m, String pass, String uname,
			@RequestParam(name = "phone", required = false) String phone,
			@RequestParam(name = "email", required = false) String email) {
		if (userService.hasSameName(uname)) {
			m.addAttribute("code", -1);
		} else {
			//默认用户注册成功冻结状态
			int ok = userService
					.registUser(new User(uname, pass, CommonEnum.USER_STATUS_FREEZE.getValue(), phone, email));
			if (ok == 1) {
				m.addAttribute("code", 1);
			} else {
				m.addAttribute("code", -2);
			}
		}
		return "regist";
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping("/toRegistUser")
	public String toRegistUser(Model m) {
		m.addAttribute("code", 0);
		return "regist";
	}
}
