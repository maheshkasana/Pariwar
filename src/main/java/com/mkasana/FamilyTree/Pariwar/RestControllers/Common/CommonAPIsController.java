package com.mkasana.FamilyTree.Pariwar.RestControllers.Common;

import com.mkasana.FamilyTree.Pariwar.Component.CommonAPIs.CommonAPIsComponent;
import com.mkasana.FamilyTree.Pariwar.Component.Validations.ValidationFunctions;
import com.mkasana.FamilyTree.Pariwar.model.Religion;
import com.mkasana.FamilyTree.Pariwar.model.ReturnStatus;
import com.mkasana.FamilyTree.Pariwar.model.SessionDetails;
import com.mkasana.FamilyTree.Pariwar.model.UserFullDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@RestController
public class CommonAPIsController {

    @Autowired
    private CommonAPIsComponent commonAPIsComponent;

    @Autowired
    ValidationFunctions validate;
    /**
     * this function is to get user details by token
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/user/details/{token}", method = RequestMethod.GET, headers="Accept=application/json")
    private UserFullDetails getUserFullDetailsByToken(@PathVariable("token") String token, @RequestHeader HttpHeaders headers) throws Exception {
        SessionDetails session = validate.validateRequest(headers, true);
        String function = "CommonAPIsComponent:getUserFullDetailsByToken";

        return commonAPIsComponent.getUserFullDetailsByToken(token);
    }
}
