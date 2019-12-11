package com.mkasana.FamilyTree.Pariwar.RestControllers.Register.AutoSuggest;

import com.mkasana.FamilyTree.Pariwar.Component.Register.AutoSuggest.UserReligionComponent;
import com.mkasana.FamilyTree.Pariwar.model.Caste;
import com.mkasana.FamilyTree.Pariwar.model.Country;
import com.mkasana.FamilyTree.Pariwar.model.Religion;
import com.mkasana.FamilyTree.Pariwar.model.SubCaste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

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





    /**********************************************
     * All the below Controllers are for Religion *
     **********************************************/

    /**
     * this function is to return the religion details for the religion id
     * @param headers
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/register/auto/religion/{religionId}", method = RequestMethod.GET, headers="Accept=application/json")
    private Religion SuggestReligion(@PathVariable("religionId") int religionId, @RequestHeader HttpHeaders headers) throws Exception {

        String function = "AutoSuggestController:SuggestReligion";

        /*
        headers.forEach((key, value) -> {
            System.out.printf("Parameter : %s, Value %s\n",key, value);
        });
        */

        return userReligionComponent.getReligionById(religionId);
    }


    /**
     * this function is to return all the available religions
     * @param headers
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/register/auto/religions", method = RequestMethod.GET, headers="Accept=application/json")
    private List<Religion> SuggestAllReligions(@RequestHeader HttpHeaders headers) throws Exception {

        String function = "AutoSuggestController:SuggestAllReligions";

        return userReligionComponent.getAllReligions();
    }







    /**********************************************
     * All the below Controllers are for Caste    *
     **********************************************/


    /**
     * this function is to return Caste based on passed Caste Id;
     * @param headers
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/register/auto/caste/{casteId}", method = RequestMethod.GET, headers="Accept=application/json")
    private Caste SuggestCasteById(@PathVariable("casteId") int casteId, @RequestHeader HttpHeaders headers) throws Exception {

        String function = "AutoSuggestController:SuggestCasteById";

        return userReligionComponent.getCasteById(casteId);
    }



    /**
     * this function is to return All Caste;
     * @param headers
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/register/auto/allCaste", method = RequestMethod.GET, headers="Accept=application/json")
    private List<Caste> SuggestAllCaste(@RequestHeader HttpHeaders headers) throws Exception {

        String function = "AutoSuggestController:SuggestAllCaste";

        return userReligionComponent.getAllCaste();
    }


    /**
     * this function is to return All Caste of Religion;
     * @param headers
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/register/auto/religionAllCaste/{religionId}", method = RequestMethod.GET, headers="Accept=application/json")
    private List<Caste> SuggestAllCasteOfReligion(@PathVariable("religionId") int religionId, @RequestHeader HttpHeaders headers) throws Exception {

        String function = "AutoSuggestController:SuggestAllCasteOfReligion";

        if(0 >= religionId) {
            System.out.println("Invalid Religion id Passed [" + religionId + "]");
            return userReligionComponent.getAllCaste();
        }
        return userReligionComponent.getAllCasteOfReligion(religionId);
    }






    /**************************************************
     * All the below Controllers are for Sub-Caste    *
     **************************************************/
    /**
     * this function is to return Sub - Caste based on passed sub-Caste Id;
     * @param headers
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/register/auto/subCaste/{subCasteId}", method = RequestMethod.GET, headers="Accept=application/json")
    private SubCaste SuggestSubCasteById(@PathVariable("subCasteId") int subCasteId, @RequestHeader HttpHeaders headers) throws Exception {

        String function = "AutoSuggestController:SuggestSubCasteById";

        return userReligionComponent.getSubCasteById(subCasteId);
    }

    /**
     * this function is to return All Sub - Caste;
     * @param headers
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/register/auto/AllSubCaste", method = RequestMethod.GET, headers="Accept=application/json")
    private List<SubCaste> SuggestAllSubCaste(@RequestHeader HttpHeaders headers) throws Exception {

        String function = "AutoSuggestController:SuggestAllSubCaste";

        return userReligionComponent.getAllSubCaste();
    }

}
