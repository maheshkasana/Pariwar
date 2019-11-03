package com.mkasana.FamilyTree.Pariwar.Controllers;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

@Controller
public class ModelHome extends AbstractController{

    @Override
    @RequestMapping("/ModelView")
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
                                                 HttpServletResponse response) throws Exception {
        System.out.println("in /ModelView Controller");
        ModelAndView model = new ModelAndView("home");

        return model;
    }

}