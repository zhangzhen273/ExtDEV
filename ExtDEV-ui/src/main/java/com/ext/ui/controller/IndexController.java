package com.ext.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class IndexController {

    @RequestMapping("/index")
    public String  listUser() {
        return "/index";
    }

}