package com.yulang.webmagic.controller;

import com.yulang.webmagic.dao.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class IndexController {

    @Autowired
    private ArticleMapper mapper;

    @RequestMapping
    public String index(Model model){
        return "index";
    }

    @RequestMapping("/about")
    public String about(){
        return "about";
    }

    @RequestMapping("/contact")
    public String contact(){
        return "contact";
    }
    @RequestMapping("/zhuce")
    public String panSource(){
        return "zhuce";
    }

    @RequestMapping("/login")
    public String java(){
        return "login";
    }

    @RequestMapping("/spring")
    public String spring(Model model){
        model.addAttribute("panList",mapper.list());
        return "spring";
    }

    @RequestMapping("/spring-cloud")
    public String springCloud(Model model){
        model.addAttribute("panList",mapper.list());
        return "spring-cloud";
    }

}
