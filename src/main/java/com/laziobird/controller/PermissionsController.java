package com.laziobird.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


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

    @RequestMapping("/toadd")
    public String toadd(HttpServletRequest request,Model model) {
    	//暂时只支持一二级菜单
    	model.addAttribute("permissionList", permissionService.allMenu());   
        return "/permission/toadd";
    }
    
    
    @RequestMapping("/getPlistByPid")
	@ResponseBody
    public Map<String, Object> getPlistByPid(@RequestParam("pid") String pid) {
    	List<Permission> plist = permissionService.getPerListByPid(pid);        
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("plist", plist);
		return returnMap;
    }    
    

}
