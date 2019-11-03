package com.mkasana.FamilyTree.Pariwar.Controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Helloworld {

    @RequestMapping("/index")
    public String index() {
        System.out.println("in HelloWorld RestController");
        return "Hello World";
    }


}
