package com.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by liangwenchang on 2019/8/5.
 */
@Controller
public class ThymeleafController {
    @RequestMapping(value = "/index")
    public String index(Model model) {
        model.addAttribute("test", "Hello world!");
        return "index";
    }

    @RequestMapping(value = "/postman")
    @ResponseBody
    public String PostManTest() {
        System.out.println("Call me");
        return "hi,postMan";
    }
}
