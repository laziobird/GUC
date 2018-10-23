package com.laziobird.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laziobird.bean.Permission;
import com.laziobird.bean.PermissionMapper;

import java.util.List;

/**
 * @author Yunfei
 *
 */
@Service
public class PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    public List<Permission> findPer(String id) {
        return permissionMapper.getPerListByUid(id);
    }
}
