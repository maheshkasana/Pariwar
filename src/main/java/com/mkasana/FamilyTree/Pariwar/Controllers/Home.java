package com.mkasana.FamilyTree.Pariwar.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Home {

    @RequestMapping("/Home")
    public String home() {
        System.out.println("in /Home Controller");
        return "Home";
    }


    @RequestMapping("/index")
    public String index() {
        System.out.println("in /Home Controller");
        return "index";
    }
}