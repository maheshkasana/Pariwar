package com.mkasana.FamilyTree.Pariwar.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Home {

    @RequestMapping("/home")
    public String home() {
        System.out.println("in /home Controller");
        return "home";
    }
}
