package com.laziobird.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import com.laziobird.CommonEnum;
import com.laziobird.bean.User;
import com.laziobird.bean.UserMapper;
import com.laziobird.bean.UserVo;

/**
 *
 * @author Yunfei User Service
 *
 */
@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;

	/**
	 * @return allUsers
	 */
	public List<UserVo> listAll() {
		return userMapper.showAllAndRole();
	}

	/**
	 *
	 * @param id
	 * @return User
	 */
	public User getUserById(String id) {
		return userMapper.getById(id);
	}

	public int freezeUserById(Integer uid) {
		User user = new User();
		user.setId(uid);
		user.setStatus(CommonEnum.USER_STATUS_FREEZE.getValue());
		return userMapper.updateStatusById(user);
	}

	public int deleteUserById(Integer uid) {
		User user = new User();
		user.setId(uid);
		user.setStatus(CommonEnum.USER_STATUS_DELETE.getValue());
		return userMapper.updateStatusById(user);
	}

	public int recoverUserById(Integer uid) {
		User user = new User();
		user.setId(uid);
		user.setStatus(CommonEnum.USER_STATUS_OK.getValue());
		return userMapper.updateStatusById(user);
	}

	/**
	 *
	 * @param name
	 * @param pass
	 * @return int 是否存在
	 */
	public int hasUser(String name, String pass) {
		User user = userMapper.getByName(name);
		if (user != null) {
			if (user.getPassword().equals(pass))
				return user.getId();
			else
				return -1;
		}
		return 0;
	}
	/**
	 * 有没有重复用户名
	 * @param name
	 * @return
	 */
	public boolean hasSameName(String name) {
		return userMapper.countByName(name) > 0 ? true : false;
	}

	/**
	 *
	 * @param user
	 * @return 是否添加成功
	 */
	public int addUser(User user) {
		return userMapper.insert(user);
	}

	/**
	 * 
	 * @param user
	 * @return 是非用户注册成功
	 */
	public int registUser(User user) {
		if (StringUtils.isEmptyOrWhitespace(user.getEmail())) {
			user.setEmail("0");
		}
		if (StringUtils.isEmptyOrWhitespace(user.getPhone())) {
			user.setPhone("0");
		}
		return userMapper.insertAll(user);
	}

	/**
	 *
	 * @param id
	 * @return 是否删除成功
	 */
	public int deleteUser(String id) {
		return userMapper.delete(id);
	}

	/**
	 *
	 * @param user
	 * @return
	 */
	public int updateUser(User user) {
		return userMapper.update(user);
	}
}
