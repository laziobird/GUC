package com.laziobird.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 *
 * @author Yunfei
 *
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String indexPage() {
        return "index";
    }

}
