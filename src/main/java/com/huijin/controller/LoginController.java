package com.huijin.controller;

import com.huijin.model.User;
import com.huijin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 登录
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String list(HttpServletRequest request, User user) {
        if (StringUtils.hasLength(user.getUserName()) && StringUtils.hasLength(user.getPassword())) {
            User user1 = userService.findUserByNameAndPassword(user);
            if (user1 != null) {
                HttpSession session = request.getSession();
                session.setAttribute("userinfo", "userinfo");
                return "redirect:/update";
            }
        }
        return "login/login";
    }

}
