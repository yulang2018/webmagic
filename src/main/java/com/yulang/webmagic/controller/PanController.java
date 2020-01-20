package com.yulang.webmagic.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yulang.webmagic.dao.PanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pan")
public class PanController {

    @Autowired
    private PanMapper mapper;

    @RequestMapping
    public String list(Model model){
        model.addAttribute("panList",mapper.selectList(new QueryWrapper<>()));
        return "pan-source";
    }

}
