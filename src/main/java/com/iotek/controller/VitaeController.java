package com.iotek.controller;

import com.iotek.service.VitaeService;
import org.springframework.stereotype.Controller;


import javax.annotation.Resource;

@Controller
public class VitaeController {
    @Resource(name = "vitaeServiceImpl")
    private VitaeService vitaeService;

    public String goVitae()throws Exception{
        return "vitae";
    }
}
