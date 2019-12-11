package com.mkasana.FamilyTree.Pariwar.RestControllers.Register.AutoSuggest;

import com.mkasana.FamilyTree.Pariwar.Component.Register.AutoSuggest.UserReligion;
import com.mkasana.FamilyTree.Pariwar.model.Religion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * This Controller is for AutoSuggestReligion
 */
@Service
@RestController
public class AutoSuggestReligion {

    //Add the security for the APIs asap, like before validation of the user.
    @Autowired
    private  UserReligion userReligion;
    /**
     *
     * @param headers
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/register/auto/religion", method = RequestMethod.GET, headers="Accept=application/json")
    private Religion SuggestReligion(@RequestHeader HttpHeaders headers) throws Exception {

        headers.forEach((key, value) -> {
            System.out.printf("Parameter : %s, Value %s\n",key, value);
        });

        return userReligion.getReligionById(13);
    }
}
