package com.iotek.controller;

import com.iotek.service.UserService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class UserController {
    @Resource(name = "userServiceImpl")
    private UserService userService;
}
