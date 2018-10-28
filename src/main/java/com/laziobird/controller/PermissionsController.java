package com.laziobird.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String list(HttpServletRequest request,Model model) {
    	List<Permission> list = permissionService.listAll();
		model.addAttribute("permissionList", list);    	
        return "/permission/list";
    }
    @RequestMapping("/add")
    public String changeRole(HttpServletRequest request,Model model,@ModelAttribute Permission permission) {
    	permissionService.addPermission(permission);
        return list(request,model);
    }


}
