package com.yulang.webmagic.controller;

import com.yulang.webmagic.dao.JavaArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/java-article")
public class JavaArticleController {

    @Autowired
    private JavaArticleMapper mapper;


    @RequestMapping
    public String list(Model model){
        model.addAttribute("panList",mapper.list());
        return "java";
    }

}
