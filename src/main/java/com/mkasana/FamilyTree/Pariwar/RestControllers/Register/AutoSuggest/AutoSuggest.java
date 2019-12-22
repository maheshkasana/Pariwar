package com.mkasana.FamilyTree.Pariwar.RestControllers.Register.AutoSuggest;

import com.mkasana.FamilyTree.Pariwar.Component.Register.AutoSuggest.UserAddressComponent;
import com.mkasana.FamilyTree.Pariwar.Component.Register.AutoSuggest.UserReligionComponent;
import com.mkasana.FamilyTree.Pariwar.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * This Controller is for AutoSuggest
 */
@Service
@RestController
public class AutoSuggest {

    //Add the security for the APIs asap, like before validation of the user.
    @Autowired
    private UserReligionComponent userReligionComponent;

    @Autowired
    private UserAddressComponent userAddressComponent;





    /**********************************************
     * All the below Controllers are for Religion *
     **********************************************/

    /**
     * this function is to Create new Religion
     * @param headers
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/register/create/religion", method = RequestMethod.POST, headers="Accept=application/json")
    private ReturnStatus createNewReligion(@RequestBody Religion religion, @RequestHeader HttpHeaders headers) throws Exception {

        String function = "AutoSuggestController:createNewReligion";

        return userReligionComponent.createNewReligion(religion);
    }

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
    @RequestMapping(value = "/register/auto/allReligions", method = RequestMethod.GET, headers="Accept=application/json")
    private List<Religion> SuggestAllReligions(@RequestHeader HttpHeaders headers) throws Exception {

        String function = "AutoSuggestController:SuggestAllReligions";

        return userReligionComponent.getAllReligions();
    }







    /**********************************************
     * All the below Controllers are for Caste    *
     **********************************************/

    /**
     * this function is to Create new Caste
     * @param headers
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/register/create/caste", method = RequestMethod.POST, headers="Accept=application/json")
    private ReturnStatus createNewCaste(@RequestBody Caste caste, @RequestHeader HttpHeaders headers) throws Exception {

        String function = "AutoSuggestController:createNewCaste";

        return userReligionComponent.createNewCaste(caste);
    }


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
     * this function is to Create new SubCaste
     * @param headers
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/register/create/subCaste", method = RequestMethod.POST, headers="Accept=application/json")
    private ReturnStatus createNewSubCaste(@RequestBody SubCaste subCaste, @RequestHeader HttpHeaders headers) throws Exception {

        String function = "AutoSuggestController:createNewSubCaste";

        return userReligionComponent.createNewSubCaste(subCaste);
    }


    /**
     *
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

    /**
     * this function is to Suggest Sub - Caste based on passed Caste Id or Religion Id;
     * @param headers
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/register/auto/casteAllSubCaste/{casteId}", method = RequestMethod.GET, headers="Accept=application/json")
    private List<SubCaste> SuggestAllSubCasteByCasteId(@PathVariable("casteId") int casteId, @RequestHeader HttpHeaders headers) throws Exception {

        String function = "AutoSuggestController:SuggestAllSubCasteByCasteId";

        return userReligionComponent.getAllSubCasteByCasteId(casteId);
    }

    /**
     * this function is to Suggest Sub - Caste based on passed Caste Id or Religion Id;
     * @param headers
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/register/auto/AllSubCaste/{casteId}/{religionId}", method = RequestMethod.GET, headers="Accept=application/json")
    private List<SubCaste> SuggestAllSubCasteByCasteIdOrReligionId(@PathVariable("casteId") int casteId, @PathVariable("religionId") int religionId, @RequestHeader HttpHeaders headers) throws Exception {

        String function = "AutoSuggestController:SuggestAllSubCasteByCasteIdOrReligionId";

        return userReligionComponent.getSuggestAllSubCasteByCasteIdOrReligionId(casteId, religionId);
    }





    /**********************************************
     *  All the below Controllers are for Country *
     **********************************************/
    /**
     * this function is to return Country based on passed Country Id;
     * @param headers
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/register/auto/country/{countryId}", method = RequestMethod.GET, headers="Accept=application/json")
    private Country suggestCountryById(@PathVariable("countryId") int countryId, @RequestHeader HttpHeaders headers) throws Exception {

        String function = "AutoSuggestController:SuggestCountryById";

        return userAddressComponent.getCountryById(countryId);
    }


    /**
     * this function is to return All Country;
     * @param headers
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/register/auto/allCountries", method = RequestMethod.GET, headers="Accept=application/json")
    private List<Country> suggestAllCountries(@RequestHeader HttpHeaders headers) throws Exception {

        String function = "AutoSuggestController:SuggestAllCountries";

        return userAddressComponent.getAllCountries();
    }


    /**
     * this function is to Create New Country
     * @param headers
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/register/create/country", method = RequestMethod.POST, headers="Accept=application/json")
    private ReturnStatus createNewCountry(@RequestBody Country country,@RequestHeader HttpHeaders headers) throws Exception {

    String function = "AutoSuggestController:CreateNewCountry";

    return userAddressComponent.createNewCountry(country);
    }

    /**
     * this function is to Create New state
     * @param headers
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/register/create/state", method = RequestMethod.POST, headers="Accept=application/json")
    private ReturnStatus createNewState(@RequestBody State state,@RequestHeader HttpHeaders headers) throws Exception {

        String function = "AutoSuggestController:createNewState";

        return userAddressComponent.createNewState(state);
    }

    /**
     * this function is to Create New district
     * @param headers
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/register/create/district", method = RequestMethod.POST, headers="Accept=application/json")
    private ReturnStatus createNewDistrict(@RequestBody District district,@RequestHeader HttpHeaders headers) throws Exception {

        String function = "AutoSuggestController:CreateNewDistrict";

        return userAddressComponent.createNewDistrict(district);
    }

    /**
     * this function is to Create New Tehsil
     * @param headers
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/register/create/tehsil", method = RequestMethod.POST, headers="Accept=application/json")
    private ReturnStatus createNewTehsil(@RequestBody Tehsil tehsil,@RequestHeader HttpHeaders headers) throws Exception {

        String function = "AutoSuggestController:createNewTehsil";

        return userAddressComponent.createNewTehsil(tehsil);
    }

    /**
     * this function is to Create New villageTown
     * @param headers
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/register/create/villageTown", method = RequestMethod.POST, headers="Accept=application/json")
    private ReturnStatus createNewVillageTown(@RequestBody VillageTown villageTown,@RequestHeader HttpHeaders headers) throws Exception {

        String function = "AutoSuggestController:createNewVillageTown";

        return userAddressComponent.createNewVillageTown(villageTown);
    }

    /**
     * this function is to Create New villageTown in batch
     * @param headers
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/register/create/villageTown/inBatch", method = RequestMethod.POST, headers="Accept=application/json")
    private ReturnStatus createNewVillageTownInBatch(@RequestBody List<VillageTown> villageTowns,@RequestHeader HttpHeaders headers) throws Exception {

        String function = "AutoSuggestController:createNewVillageTownInBatch";

        return userAddressComponent.createNewVillageTownInBatch(villageTowns);
    }



    /**
     * this function is to Update the PinCode villageTown
     * @param headers
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/register/update/villageTown/pincode", method = RequestMethod.POST, headers="Accept=application/json")
    private ReturnStatus updateVillageTownPinCode(@RequestBody VillageTown villageTown,@RequestHeader HttpHeaders headers) throws Exception {

        String function = "AutoSuggestController:updateVillageTownPinCode";

        return userAddressComponent.updateVillageTownPinCode(villageTown);
    }


    /**********************************************
     *  All the below Controllers are for State   *
     **********************************************/

    /**
     * this function is to return State by Id
     * @param headers
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/register/auto/state/{stateId}", method = RequestMethod.GET, headers="Accept=application/json")
    private State suggestStateById(@PathVariable("stateId") int stateId, @RequestHeader HttpHeaders headers) throws Exception {

        String function = "AutoSuggestController:suggestStateById";

        return userAddressComponent.getStateById(stateId);
    }


    /**
     * this function is to return All State;
     * @param headers
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/register/auto/allStates", method = RequestMethod.GET, headers="Accept=application/json")
    private List<State> suggestAllStates(@RequestHeader HttpHeaders headers) throws Exception {

        String function = "AutoSuggestController:suggestAllStates";

        return userAddressComponent.getAllState();
    }

    /**********************************************
     *  All the below Controllers are for District   *
     **********************************************/

    /**
     * this function is to return District by Id
     * @param headers
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/register/auto/district/{districtId}", method = RequestMethod.GET, headers="Accept=application/json")
    private District suggestDistrictById(@PathVariable("districtId") int districtId, @RequestHeader HttpHeaders headers) throws Exception {

        String function = "AutoSuggestController:suggestDistrictById";

        return userAddressComponent.getDistrictById(districtId);
    }

    /**
     * this function is to return District by State Id
     * @param headers
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/register/auto/districtByStateId/{stateId}", method = RequestMethod.GET, headers="Accept=application/json")
    private List<District> suggestDistrictByStateId(@PathVariable("stateId") int stateId, @RequestHeader HttpHeaders headers) throws Exception {

        String function = "AutoSuggestController:suggestDistrictByStateId";

        return userAddressComponent.suggestDistrictByStateId(stateId);
    }

    /**
     * this function is to return All District;
     * @param headers
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/register/auto/allDistrict", method = RequestMethod.GET, headers="Accept=application/json")
    private List<District> suggestAllDistrict(@RequestHeader HttpHeaders headers) throws Exception {

        String function = "AutoSuggestController:suggestAllDistrict";

        return userAddressComponent.getAllDistrict();
    }

    /****************************************************
     *  All the below Controllers are for Teshil   *
     ****************************************************/

    /**
     * this function is to return tehsilId by Id
     * @param headers
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/register/auto/tehsil/{tehsilId}", method = RequestMethod.GET, headers="Accept=application/json")
    private Tehsil suggestTehsilById(@PathVariable("tehsilId") int tehsilId, @RequestHeader HttpHeaders headers) throws Exception {

        String function = "AutoSuggestController:suggestTehsilById";

        return userAddressComponent.getTehsilById(tehsilId);
    }


    /**
     * this function is to return All Tehsil;
     * @param headers
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/register/auto/allTehsil", method = RequestMethod.GET, headers="Accept=application/json")
    private List<Tehsil> suggestAllTehsil(@RequestHeader HttpHeaders headers) throws Exception {

        String function = "AutoSuggestController:suggestAllTehsil";

        return userAddressComponent.getAllTehsil();
    }

    /**
     * this function is to return All Tehsil by District Id;
     * @param headers
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/register/auto/allTehsilByDistrictId/{districtId}", method = RequestMethod.GET, headers="Accept=application/json")
    private List<Tehsil> suggestAllTehsilByDistrictId(@PathVariable("districtId") int districtId,@RequestHeader HttpHeaders headers) throws Exception {

        String function = "AutoSuggestController:suggestAllTehsilByDistrictId";

        return userAddressComponent.getAllTehsilByDistrictId(districtId);
    }



    /****************************************************
     *  All the below Controllers are for VillageTown   *
     ****************************************************/

    /**
     * this function is to return VillageTown by Id
     * @param headers
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/register/auto/villageTown/{villageTownId}", method = RequestMethod.GET, headers="Accept=application/json")
    private VillageTown suggestVillageTownById(@PathVariable("villageTownId") int villageTownId, @RequestHeader HttpHeaders headers) throws Exception {

        String function = "AutoSuggestController:suggestVillageTownById";

        return userAddressComponent.getVillageTownById(villageTownId);
    }


    /**
     * this function is to return All VillageTown;
     * @param headers
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/register/auto/allVillageTown", method = RequestMethod.GET, headers="Accept=application/json")
    private List<VillageTown> suggestAllVillageTown(@RequestHeader HttpHeaders headers) throws Exception {

        String function = "AutoSuggestController:suggestAllVillageTown";

        return userAddressComponent.getAllVillageTown();
    }


    /**
     * this function is to return All VillageTown by Tehsil Id;
     * @param headers
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/register/auto/allVillageTownByTehsilId/{tehsilId}", method = RequestMethod.GET, headers="Accept=application/json")
    private List<VillageTown> suggestAllVillageTownByTehSilId(@PathVariable("tehsilId") int tehsilId,@RequestHeader HttpHeaders headers) throws Exception {

        String function = "AutoSuggestController:suggestAllVillageTownByTehSilId";

        return userAddressComponent.getAllVillageTownByTehsilId(tehsilId);
    }


    /**
     * this function is to validate username availability
     * @param headers
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/register/auto/validateAvailabilityUsername/{username}", method = RequestMethod.GET, headers="Accept=application/json")
    private ReturnStatus validateAvailabilityUsername(@PathVariable("username") String username,@RequestHeader HttpHeaders headers) throws Exception {

        String function = "AutoSuggestController:validateAvailabilityUsername";

        return userAddressComponent.validateAvailabilityUsername(username);
    }


}