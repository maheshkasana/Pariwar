package com.mkasana.FamilyTree.Pariwar.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommonController {

    @RequestMapping("/")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/home", method = {RequestMethod.POST, RequestMethod.GET})
    public String home() {
        System.out.println("in /home Controller");
        //System.out.println("username:"+username+", token: "+token+", userId:"+userId);
        return "UserView";
    }

    @RequestMapping(value = "/profile", method = {RequestMethod.POST, RequestMethod.GET})
    public String profile() {
        System.out.println("in /profile Controller");
        //System.out.println("username:"+username+", token: "+token+", userId:"+userId);
        return "UserProfile";
    }
}