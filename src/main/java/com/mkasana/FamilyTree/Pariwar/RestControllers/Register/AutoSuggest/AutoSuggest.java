package com.mkasana.FamilyTree.Pariwar.RestControllers.Register.AutoSuggest;

import com.mkasana.FamilyTree.Pariwar.Component.Register.AutoSuggest.UserReligionComponent;
import com.mkasana.FamilyTree.Pariwar.model.Country;
import com.mkasana.FamilyTree.Pariwar.model.Religion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * This Controller is for AutoSuggest
 */
@Service
@RestController
public class AutoSuggest {

    //Add the security for the APIs asap, like before validation of the user.
    @Autowired
    private UserReligionComponent userReligionComponent;
    /**
     *
     * @param headers
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/register/auto/religion", method = RequestMethod.GET, headers="Accept=application/json")
    private Religion SuggestReligion(@RequestHeader HttpHeaders headers) throws Exception {

        String function = "AutoSuggestController:SuggestReligion";

        headers.forEach((key, value) -> {
            System.out.printf("Parameter : %s, Value %s\n",key, value);
        });

        return userReligionComponent.getReligionById(13);
    }
}
