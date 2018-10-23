package com.laziobird.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laziobird.bean.Role;
import com.laziobird.bean.RoleMapper;
import com.laziobird.bean.UserRole;
import com.laziobird.bean.UserRoleMapper;

import java.util.List;

/**
 * @author Yunfei
 */
@Service
public class RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    public List<Role> getRoles(String uid) {
        return roleMapper.getRoles(uid);
    }

    public int changeRole(UserRole userRole) {
//        System.out.println("uid = "+uid+" --rid = "+rid);
        return userRoleMapper.changeRole(userRole);
    }
}
