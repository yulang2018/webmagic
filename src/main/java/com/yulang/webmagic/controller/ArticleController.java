package com.yulang.webmagic.controller;

import com.yulang.webmagic.dao.ArticleMapper;
import com.yulang.webmagic.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleMapper mapper;


    @RequestMapping
    public void list(Model model){
        model.addAttribute("articles",mapper.list());
        return;
    }

}
