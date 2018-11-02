package com.laziobird.api;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.laziobird.api.bean.APIVo;
import com.laziobird.bean.Permission;
import com.laziobird.bean.User;
import com.laziobird.service.PermissionService;
import com.laziobird.service.UserService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
/**
 * 
 * @author laziobird
 *
 */
@RestController
@RequestMapping("/api/v1")
public class APIController {

    @Autowired
    private PermissionService permissionService;
    
    @Autowired
    private UserService userService;    
    
    @ApiOperation(value="获取权限列表", notes="根据查询条件获取权限集合")
    @RequestMapping(value = "/listPermission",method = RequestMethod.GET)
    public APIVo list(HttpServletRequest request,Model model) {
    	List<Permission> list = permissionService.listAll();	 
    	APIVo apiVo = new APIVo();
    	apiVo.setData(list);
        return apiVo;
    }

 
    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "uid", value = "用户ID", required = true, dataType = "Long")    
    @RequestMapping(value = "/getUser/{uid}",method = RequestMethod.GET)
    public APIVo getUserByid(@PathVariable String uid) {
    	APIVo apiVo = new APIVo();
    	apiVo.setData(userService.getUserById(uid));
        return apiVo;
    }    
    

}
