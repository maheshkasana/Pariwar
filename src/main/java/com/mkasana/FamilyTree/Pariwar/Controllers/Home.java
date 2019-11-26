package com.mkasana.FamilyTree.Pariwar.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Home {

    @RequestMapping("/")
    public String home() {
        return "home";
    }


    @RequestMapping("/index")
    public String index() {
        System.out.println("in /index Controller");
        return "index";
    }
}