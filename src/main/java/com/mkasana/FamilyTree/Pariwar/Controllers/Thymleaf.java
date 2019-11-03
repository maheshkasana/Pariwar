package com.mkasana.FamilyTree.Pariwar.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Thymleaf {

        @RequestMapping(value = "/arti")
        public String index(Model model) {

            System.out.println("in /arti Controller");
            model.addAttribute("msg",
                    "Mkasana a jar packaging example");
            return "myView";
        }
}