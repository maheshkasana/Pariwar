package com.mkasana.FamilyTree.Pariwar.RestControllers.Common;

import com.mkasana.FamilyTree.Pariwar.Component.CommonAPIs.CommonAPIsComponent;
import com.mkasana.FamilyTree.Pariwar.Component.Validations.ValidationFunctions;
import com.mkasana.FamilyTree.Pariwar.model.*;
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

    /**
     * this function is to get basic user spouse details
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/user/spouse/basic/{userId}", method = RequestMethod.GET, headers="Accept=application/json")
    private List<UserFullDetails> getBasicUserspouseDetailsByUserId(@PathVariable("userId") int userId, @RequestHeader HttpHeaders headers) throws Exception {
        SessionDetails session = validate.validateRequest(headers, false);
        String function = "CommonAPIsComponent:getBasicUserspouseDetailsByUserId";

        return commonAPIsComponent.getBasicUserspouseDetailsByUserId(userId);
    }

    /**
     * this function is to return result for the search filters.
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/user/search", method = RequestMethod.POST, headers="Accept=application/json")
    private List<SearchFiltersResponse> searchUsersBasedOnPassedConstrains(@RequestBody SearchFilters filters,
                                                                     @RequestHeader HttpHeaders headers) throws Exception {
        SessionDetails session = validate.validateRequest(headers, true);
        String function = "CommonAPIsComponent:searchUsersBasedOnPassedConstrains";
        System.out.println(filters);
        return commonAPIsComponent.searchUsersBasedOnPassedConstrains(filters);
    }

    /**
     * this function is to add parent to the logged in User.
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/user/add/parent/{parentId}", method = RequestMethod.POST, headers="Accept=application/json")
    private void addParentToLoggedInUser(@PathVariable("parentId") int parentId, @RequestHeader HttpHeaders headers) throws Exception {
        SessionDetails session = validate.validateRequest(headers, true);
        String function = "CommonAPIsComponent:addParentToLoggedInUser";
        if(session == null) {
            throw new Exception("failed to validate");
        }
        commonAPIsComponent.addParentToLoggedInUser(session.getUserId(), parentId);
        return;
    }



    /**
     * this function is to add parent to the logged in User.
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/user/add/child/{childId}", method = RequestMethod.POST, headers="Accept=application/json")
    private void addChildToLoggedInUser(@PathVariable("childId") int childId, @RequestHeader HttpHeaders headers) throws Exception {
        SessionDetails session = validate.validateRequest(headers, true);
        String function = "CommonAPIsComponent:addChildToLoggedInUser";
        if(session == null) {
            throw new Exception("failed to validate");
        }
        commonAPIsComponent.addChildToLoggedInUser(session.getUserId(), childId);
        return;
    }

    /**
     * this function is to add spouse to the logged in User.
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/user/add/spouse/{spouseId}", method = RequestMethod.POST, headers="Accept=application/json")
    private void addSpouseToLoggedInUser(@PathVariable("spouseId") int spouseId, @RequestHeader HttpHeaders headers) throws Exception {
        SessionDetails session = validate.validateRequest(headers, true);
        String function = "CommonAPIsComponent:addSpouseToLoggedInUser";
        if(session == null) {
            throw new Exception("failed to validate");
        }
        commonAPIsComponent.addSpouseToUser(session.getUserId(), spouseId);
        return;
    }


}
