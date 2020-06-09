package com.gx.springboot.controller;

import com.gx.springboot.dto.UserDao;
import com.gx.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @createDate 2020/6/5 16:22
 */
@Controller
public class UserLoginController {

    @Autowired
    UserDao userDao;
    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public String userLogin(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            HttpSession session,
                            Model model){

        User user = userDao.queryForUser(username, password);
        if(user!=null){

            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }
          model.addAttribute("msg","用户名或密码错误");
          return "/index.html";
    }

    @RequestMapping("/user/logout")
    public String userLogout(HttpSession session) {


        session.removeAttribute("loginUser");
        return "redirect:/index.html";
    }
}
