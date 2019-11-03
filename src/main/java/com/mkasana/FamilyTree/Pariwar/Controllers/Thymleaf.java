package com.mkasana.FamilyTree.Pariwar.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Thymleaf {

        @RequestMapping(value = "/kasana")
        public @ResponseBody Model index(Model model) {

            System.out.println("in /kasana Controller");
            model.addAttribute("msg",
                    "Mkasana a jar packaging example");
            return model;
        }
}
