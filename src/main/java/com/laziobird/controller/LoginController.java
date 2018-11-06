package com.laziobird.controller;

import com.laziobird.bean.Permission;
import com.laziobird.bean.User;
import com.laziobird.service.PermissionService;
import com.laziobird.service.UserService;
import com.laziobird.urp.Menu;
import com.laziobird.util.MenuUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class LoginController {

    User user = new User();
    @Autowired
    private UserService userService;
    @Autowired
    private PermissionService permissionService;
    //登录Controller
    @RequestMapping("userlogin")
    public String login(@RequestParam String name, String pass, Model m,  HttpSession session){
        Object usero = session.getAttribute("user");
        //如果用户登陆过直接进入用户主页
        if(usero!=null){
            user = (User)usero;
            m.addAttribute("name",user.getName());
            List<Permission> list = permissionService.findPer(user.getId());
            List<Menu> menus = MenuUtil.permission2Menu(list);
            session.setAttribute("menus", menus);
            return "userhome";
        }

        user.setName(name);;
        user.setPassword(pass);

        //判断是否存在该用户
        Integer userId =  userService.hasUser(name,pass);
        if (userId>0){          //登录成功
            session.setAttribute("user",user);
            m.addAttribute("name",user.getName());
            List<Permission> list = permissionService.findPer(userId.toString());
            List<Menu> menus = MenuUtil.permission2Menu(list);
            session.setAttribute("menus", menus);
            return "userhome";
        }else if(userId==-1){      //密码错误
            m.addAttribute("name","1");
            return "login";
        }else {                 //不存在该用户
            m.addAttribute("name","2");
            return "login";
        }
    }

    //跳转到登录页面
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String indexpage(String name,Model model){
        model.addAttribute("name",name);
        return  "login";
    }

}