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

import java.util.List;

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
        SessionDetails session = validate.validateRequest(headers, false);
        String function = "CommonAPIsComponent:getUserFullDetailsByToken";

        return commonAPIsComponent.getUserFullDetailsByToken(token);
    }

    /**
     * this function is to get user parent with full details by token
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/user/parent/details/{token}", method = RequestMethod.GET, headers="Accept=application/json")
    private List<UserFullDetails> getUserParentsDetailsByToken(@PathVariable("token") String token, @RequestHeader HttpHeaders headers) throws Exception {
        SessionDetails session = validate.validateRequest(headers, false);
        String function = "CommonAPIsComponent:getUserParentsDetailsByToken";

        return commonAPIsComponent.getUserParentsDetailsByToken(token);
    }

    /**
     * this function is to get basic user parent details by token
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/user/parent/basic/{token}", method = RequestMethod.GET, headers="Accept=application/json")
    private List<UserFullDetails> getBasicUserParentsDetailsByToken(@PathVariable("token") String token, @RequestHeader HttpHeaders headers) throws Exception {
        SessionDetails session = validate.validateRequest(headers, false);
        String function = "CommonAPIsComponent:getBasicUserParentsDetailsByToken";

        return commonAPIsComponent.getBasicUserParentsDetailsByToken(token);
    }

    /**
     * this function is to get user Siblings with full details by token
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/user/siblings/details/{token}", method = RequestMethod.GET, headers="Accept=application/json")
    private List<UserFullDetails> getUserSiblingsDetailsByToken(@PathVariable("token") String token, @RequestHeader HttpHeaders headers) throws Exception {
        SessionDetails session = validate.validateRequest(headers, false);
        String function = "CommonAPIsComponent:getUserSiblingsDetailsByToken";

        return commonAPIsComponent.getUserSiblingsDetailsByToken(token);
    }

    /**
     * this function is to get basic user Siblings details by token
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/user/siblings/basic/{token}", method = RequestMethod.GET, headers="Accept=application/json")
    private List<UserFullDetails> getBasicUserSiblingsDetailsByToken(@PathVariable("token") String token, @RequestHeader HttpHeaders headers) throws Exception {
        SessionDetails session = validate.validateRequest(headers, false);
        String function = "CommonAPIsComponent:getBasicUserSiblingsDetailsByToken";

        return commonAPIsComponent.getBasicUserSiblingsDetailsByToken(token);
    }

    /**
     * this function is to get user Childs with full details by token
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/user/childs/details/{token}", method = RequestMethod.GET, headers="Accept=application/json")
    private List<UserFullDetails> getUserChildsDetailsByToken(@PathVariable("token") String token, @RequestHeader HttpHeaders headers) throws Exception {
        SessionDetails session = validate.validateRequest(headers, false);
        String function = "CommonAPIsComponent:getUserChildsDetailsByToken";

        return commonAPIsComponent.getUserChildsDetailsByToken(token);
    }

    /**
     * this function is to get basic user childs details by token
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/user/childs/basic/{token}", method = RequestMethod.GET, headers="Accept=application/json")
    private List<UserFullDetails> getBasicUserChildsDetailsByToken(@PathVariable("token") String token, @RequestHeader HttpHeaders headers) throws Exception {
        SessionDetails session = validate.validateRequest(headers, false);
        String function = "CommonAPIsComponent:getBasicUserChildsDetailsByToken";

        return commonAPIsComponent.getBasicUserChildsDetailsByToken(token);
    }

}
