package com.laziobird.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.laziobird.bean.Permission;
import com.laziobird.service.PermissionService;
/**
 * 
 * @author laziobird
 *
 */
@Controller
@RequestMapping("/permission")
public class PermissionsController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/list")
    public String list() {
    	permissionService.listAll();
        return "/list";
    }
    @RequestMapping("/add")
    public String changeRole(@ModelAttribute Permission permission) {
    	permissionService.addPermission(permission);
        return list();
    }


}
