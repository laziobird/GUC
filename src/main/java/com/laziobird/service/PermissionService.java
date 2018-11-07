package com.laziobird.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laziobird.bean.Permission;
import com.laziobird.bean.PermissionMapper;
import com.laziobird.urp.Menu;
import com.laziobird.util.MenuUtil;

/**
 * 
 * @author laziobird
 *
 */
@Service
public class PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    public List<Permission> findPer(Integer uid) {
        return permissionMapper.getPerListByUid(uid);
    }
    
    public List<Permission> getPerListByPid(String pid) {
        return permissionMapper.getPerListByPid(pid);
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
    
   /**
    * 得到所有的权限数
    * @return
    */
   public List<Menu> allMenu(){
	   List<Permission> list = listAll();
	   List<Menu> menus = MenuUtil.permission2Menu(list);	
	   return menus;
   }
   

    
}
