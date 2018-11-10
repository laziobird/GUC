package com.laziobird.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laziobird.CommonEnum;
import com.laziobird.bean.User;
import com.laziobird.service.UserService;

/**
 * 
 * @author laziobird
 *
 */
@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 所有用户
	 *
	 * @return
	 */
	@RequestMapping("/alluser")
	public List<User> listAll() {
		return userService.listAll();
	}

	/**
	 * 根据id获取用户
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping("/getuser")
	public User getUserByid(@RequestParam("id") String uid) {
		return userService.getUserById(uid);
	}

	/**
	 * 添加用户
	 *
	 * @param id
	 * @param pass
	 * @param name
	 * @return
	 */
	@RequestMapping("/addUser")
	public int addUser(@RequestParam Integer id, String pass, String name) {
		return userService.addUser(new User(name, pass, 1));
	}

	/**
	 * 删除用户
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping("/delUser")
	public int delUser(@RequestParam String id) {
		return userService.deleteUser(id);
	}

	/**
	 * 更新用户
	 *
	 * @param id
	 * @param name
	 * @param pass
	 * @return
	 */
	@RequestMapping("/updateUser")
	public int updateUser(@RequestParam Integer id, String name, String pass) {
		User user = new User(name, pass, CommonEnum.USER_STATUS_FREEZE.getValue());
		user.setId(id);
		return userService.updateUser(user);
	}

	/**
	 * 修改密码
	 * 
	 * @param passold
	 * @param passnew
	 * @return
	 */
	@RequestMapping("/repass")
	public int rePass(@RequestParam String passold, String passnew) {
		return 1;
	}

	/**
	 * 修改头像
	 * 
	 * @param file
	 * @return
	 */
	@RequestMapping("/reimg")
	public int reImg(@RequestParam File file) {
		return 0;
	}
}
