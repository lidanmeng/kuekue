package com.kuekue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class BaseController {

    @RequestMapping(value = {"/", "/index"})
    public String index() {
        return "index";
    }
}
