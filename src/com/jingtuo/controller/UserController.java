package com.jingtuo.controller;

import com.jingtuo.pojo.User;
import com.jingtuo.service.IUserService;
import com.jingtuo.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Crested by 张鹏
 * Date 2018/12/20 16:54
 * version:1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private IUserService iUserService;

    @RequestMapping("toAdd")
    public String toAdd() {
        return "add";
    }

    @RequestMapping("/add.do")
    public String add(User user) {
        iUserService = new UserServiceImpl();
        iUserService.add(user);
        return "redirect:/user/toList.do";
    }

    @RequestMapping("toList.do")
    public String list(Model model) {
        iUserService = new UserServiceImpl();
        List<User> userList = iUserService.findAll();
        model.addAttribute("userList", userList);
        return "list";
    }

}
