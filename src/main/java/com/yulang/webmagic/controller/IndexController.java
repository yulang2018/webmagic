package com.yulang.webmagic.controller;

import com.yulang.webmagic.dao.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class IndexController {

    @Autowired
    private ArticleMapper mapper;

    @RequestMapping
    public String index(Model model){

        model.addAttribute("articles",mapper.list());

        return "index";
    }

}
