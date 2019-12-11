package com.mkasana.FamilyTree.Pariwar.RestControllers.Register.AutoSuggest;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import com.mkasana.FamilyTree.Pariwar.model.Country;

import java.util.List;

/**
 * This Controller is for AutoSuggest Country
 */
@Service
@RestController
public class AutoSuggestCountry {

    //Add the security for the APIs asap, like ore validation of the user.

    /**
     *
     * @param headers
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/register/auto/country", method = RequestMethod.POST, headers="Accept=application/json")
    private List<Country> SuggestCountry(@RequestHeader HttpHeaders headers) throws Exception {

        headers.forEach((key, value) -> {
            System.out.printf("Parameter : %s, Value %s\n",key, value);
        });

        return null;
    }
}
