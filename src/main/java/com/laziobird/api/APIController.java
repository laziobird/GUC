package com.laziobird.api;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.laziobird.CommonEnum;
import com.laziobird.api.bean.APIVo;
import com.laziobird.bean.Permission;
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

    /**
     * paramType  :  path, query, body, header, form 
     * @param uid
     * @return
     */
    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "uid", value = "用户ID", required = true, dataType = "String", paramType="path")    
    @RequestMapping(value = "/getUser/{uid}",method = RequestMethod.GET)
    public APIVo getUserByid(@PathVariable String uid) {
    	APIVo apiVo = new APIVo();
    	apiVo.setData(userService.getUserById(uid));
        return apiVo;
    }    
    
    
    /**
     * 冻结用户
     * @param uid
     * @return
     */
    @ApiOperation(value="冻结用户", notes="用户被冻结，只能登录没有权限")
    @ApiImplicitParam(name = "uid", value = "用户ID", required = true, dataType = "String", paramType="path")    
    @RequestMapping(value = "/freezeUser/{uid}",method = RequestMethod.POST)
    public APIVo freezeUser(@PathVariable String uid) {
    	APIVo apiVo = new APIVo();
    	int re = userService.freezeUserById(uid);
    	if(re==1){
    		apiVo.setStatus(CommonEnum.USER_UPDATE_SUCCESS.getKey());
    	}else{
    		apiVo.setStatus(CommonEnum.USER_UPDATE_FAIL.getKey());
    		apiVo.setMessage("不存在该Uid：["+uid+"]的记录！");
    	}
        return apiVo;
    }       
    
    /**
     * 删除用户
     * @param uid
     * @return
     */
    @ApiOperation(value="删除用户", notes="用户被删除，不能恢复")
    @ApiImplicitParam(name = "uid", value = "用户ID", required = true, dataType = "String", paramType="path")    
    @RequestMapping(value = "/delUser/{uid}",method = RequestMethod.POST)
    public APIVo delUser(@PathVariable String uid) {
    	APIVo apiVo = new APIVo();
    	int re = userService.deleteUserById(uid);
    	if(re==1){
    		apiVo.setStatus(CommonEnum.USER_UPDATE_SUCCESS.getKey());
    	}else{
    		apiVo.setStatus(CommonEnum.USER_UPDATE_FAIL.getKey());
    		apiVo.setMessage("不存在该Uid：["+uid+"]的记录！");
    	}
        return apiVo;
    }     
    
    /**
     * 恢复用户
     * @param uid
     * @return
     */
    @ApiOperation(value="恢复用户", notes="用户被冻结，被恢复")
    @ApiImplicitParam(name = "uid", value = "用户ID", required = true, dataType = "String", paramType="path")    
    @RequestMapping(value = "/recoverUser/{uid}",method = RequestMethod.POST)
    public APIVo recoverUser(@PathVariable String uid) {
    	APIVo apiVo = new APIVo();
    	int re = userService.recoverUserById(uid);
    	if(re==1){
    		apiVo.setStatus(CommonEnum.USER_UPDATE_SUCCESS.getKey());
    	}else{
    		apiVo.setStatus(CommonEnum.USER_UPDATE_FAIL.getKey());
    		apiVo.setMessage("不存在该Uid：["+uid+"]的记录！");
    	}
        return apiVo;
    }       

}
