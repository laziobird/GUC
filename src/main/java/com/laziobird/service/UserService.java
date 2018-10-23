package com.laziobird.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laziobird.bean.User;
import com.laziobird.bean.UserMapper;

import java.util.List;

/**
 *
 * @author Yunfei
 * User Service
 *
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * @return allUsers
     */
    public List<User> listAll() {
        return userMapper.showAll();
    }

    /**
     *
     * @param id
     * @return User
     */
    public User getUserById(String id){
        return userMapper.getById(id);
    }

    /**
     *
     * @param name
     * @param pass
     * @return int 是否存在
     */
    public int hasUser(String name ,String pass){
        User user = userMapper.getByName(name);
        if (user!=null){
            if (user.getPassword().equals(pass))
                return Integer.parseInt(user.getId());
            else return -1;
        }
        return 0;
    }

    /**
     *
     * @param user
     * @return 是否添加成功
     */
    public int addUser(User user){
        return userMapper.insert(user);
    }

    /**
     *
     * @param id
     * @return 是否删除成功
     */
    public int deleteUser(String id){
        return userMapper.delete(id);
    }

    /**
     *
     * @param user
     * @return
     */
    public int updateUser(User user){
        return userMapper.update(user);
    }
}
