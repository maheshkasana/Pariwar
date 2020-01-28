package com.mkasana.FamilyTree.Pariwar.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Home {

    @RequestMapping("/")
    public String home() {
        return "login";
    }

    @RequestMapping(value = "/home", method = {RequestMethod.POST, RequestMethod.GET})
    public String index() {
        System.out.println("in /home Controller");
        //System.out.println("username:"+username+", token: "+token+", userId:"+userId);
        return "UserView";
    }
}