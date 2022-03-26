package com.godcoder.rest.controller;

import com.godcoder.rest.model.User;
import com.godcoder.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashMap;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "account/login";
    }

    @GetMapping("/register")
    public String register(){
        return "account/register";
    }

    @PostMapping("/register")
    public String register(User user){
        userService.save(user);
        return "redirect:/";
    }

    @ResponseBody
    @PostMapping("/register2")
    //사용자 저장 (패스워드 암호화, 사용자 권한 추가)
    public HashMap<String, Object> register2(@Valid User user) {
        System.out.println("#############             1            #######################");
        HashMap<String, Object> result = userService.usernameOverlap(user.getUsername());
        System.out.println("###################         2                 #################");
        System.out.println(result);
        return result;
    }

}
