package com.mkasana.FamilyTree.Pariwar.RestController;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Helloworld {

    @RequestMapping("/HelloWorld")
    public String index() {
        System.out.println("in HelloWorld RestController");
        return "Hello World";
    }

}
