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
     * this function is to get user parent with full details
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/user/parent/details/{userId}", method = RequestMethod.GET, headers="Accept=application/json")
    private List<UserFullDetails> getUserParentsDetailsByUserId(@PathVariable("userId") int userId, @RequestHeader HttpHeaders headers) throws Exception {
        SessionDetails session = validate.validateRequest(headers, false);
        String function = "CommonAPIsComponent:getUserParentsDetailsByUserId";

        return commonAPIsComponent.getUserParentsDetailsByUserId(userId);
    }

    /**
     * this function is to get basic user parent details =
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/user/parent/basic/{userId}", method = RequestMethod.GET, headers="Accept=application/json")
    private List<UserFullDetails> getBasicUserParentsDetailsByUserId(@PathVariable("userId") int userId, @RequestHeader HttpHeaders headers) throws Exception {
        SessionDetails session = validate.validateRequest(headers, false);
        String function = "CommonAPIsComponent:getBasicUserParentsDetailsByUserId";

        return commonAPIsComponent.getBasicUserParentsDetailsByUserId(userId);
    }

    /**
     * this function is to get user Siblings with full details
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/user/siblings/details/{userId}", method = RequestMethod.GET, headers="Accept=application/json")
    private List<UserFullDetails> getUserSiblingsDetailsByUserId(@PathVariable("userId") int userId, @RequestHeader HttpHeaders headers) throws Exception {
        SessionDetails session = validate.validateRequest(headers, false);
        String function = "CommonAPIsComponent:getUserSiblingsDetailsByUserId";

        return commonAPIsComponent.getUserSiblingsDetailsByUserId(userId);
    }

    /**
     * this function is to get basic user Siblings details
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/user/siblings/basic/{userId}", method = RequestMethod.GET, headers="Accept=application/json")
    private List<UserFullDetails> getBasicUserSiblingsDetailsByUserId(@PathVariable("userId") int userId, @RequestHeader HttpHeaders headers) throws Exception {
        SessionDetails session = validate.validateRequest(headers, false);
        String function = "CommonAPIsComponent:getBasicUserSiblingsDetailsByUserId";

        return commonAPIsComponent.getBasicUserSiblingsDetailsByUserId(userId);
    }

    /**
     * this function is to get user Childs with full details
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/user/childs/details/{userId}", method = RequestMethod.GET, headers="Accept=application/json")
    private List<UserFullDetails> getUserChildsDetailsByUserId(@PathVariable("userId") int userId, @RequestHeader HttpHeaders headers) throws Exception {
        SessionDetails session = validate.validateRequest(headers, false);
        String function = "CommonAPIsComponent:getUserChildsDetailsByUserId";

        return commonAPIsComponent.getUserChildsDetailsByUserId(userId);
    }

    /**
     * this function is to get basic user childs details
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/user/childs/basic/{userId}", method = RequestMethod.GET, headers="Accept=application/json")
    private List<UserFullDetails> getBasicUserChildsDetailsByUserId(@PathVariable("userId") int userId, @RequestHeader HttpHeaders headers) throws Exception {
        SessionDetails session = validate.validateRequest(headers, false);
        String function = "CommonAPIsComponent:getBasicUserChildsDetailsByUserId";

        return commonAPIsComponent.getBasicUserChildsDetailsByUserId(userId);
    }

}
