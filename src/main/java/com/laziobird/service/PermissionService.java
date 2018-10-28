package com.laziobird.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laziobird.bean.Permission;
import com.laziobird.bean.PermissionMapper;
import com.laziobird.bean.User;

/**
 * 
 * @author laziobird
 *
 */
@Service
public class PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    public List<Permission> findPer(String id) {
        return permissionMapper.getPerListByUid(id);
    }
    

    public List<Permission> listAll() {
        return permissionMapper.getPerListAll();
    }
    
    /**
    *
    * @param permission
    * @return 是否添加成功
    */
   public int addPermission(Permission permission){
       return permissionMapper.insert(permission);
   }    
    
    
}
