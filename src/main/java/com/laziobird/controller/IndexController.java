package com.laziobird.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {

    @RequestMapping("/")
    public String indexPage() {
        return "index";
    }
    
    
    @RequestMapping("/back/logout")
    public String logOut(HttpSession session) {
        session.invalidate();
        // remove("user");
        return "index";
    }    

}
