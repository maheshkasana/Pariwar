package com.mkasana.FamilyTree.Pariwar.Controllers;


import com.mkasana.FamilyTree.Pariwar.Component.Validations.ValidationFunctions;
import com.mkasana.FamilyTree.Pariwar.model.SessionDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommonController {

    @Autowired
    ValidationFunctions validate;

    @RequestMapping("/")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/home", method = {RequestMethod.POST, RequestMethod.GET})
    public String home(@RequestHeader HttpHeaders headers) throws Exception  {
        try {
            SessionDetails session = validate.validateRequest(headers, true);
        } catch (Exception e ) {
            return "login";
        }
        System.out.println("in /home Controller");
        //System.out.println("username:"+username+", token: "+token+", userId:"+userId);
        return "UserView";
    }

    @RequestMapping(value = "/profile", method = {RequestMethod.POST, RequestMethod.GET})
    public String profile(@RequestHeader HttpHeaders headers) throws Exception  {
        try {
            SessionDetails session = validate.validateRequest(headers, true);
        } catch (Exception e ) {
            return "login";
        }
        System.out.println("in /profile Controller");
        //System.out.println("username:"+username+", token: "+token+", userId:"+userId);
        return "UserProfile";
    }

    @RequestMapping(value = "/search", method = {RequestMethod.POST, RequestMethod.GET})
    public String search(@RequestHeader HttpHeaders headers) throws Exception  {
        try {
            SessionDetails session = validate.validateRequest(headers, true);
        } catch (Exception e ) {
            return "login";
        }
        System.out.println("in /search Controller");
        //System.out.println("username:"+username+", token: "+token+", userId:"+userId);
        return "UserSearch";
    }
}