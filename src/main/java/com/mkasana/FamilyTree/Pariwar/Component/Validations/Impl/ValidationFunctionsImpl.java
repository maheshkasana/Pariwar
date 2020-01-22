package com.mkasana.FamilyTree.Pariwar.Component.Validations.Impl;

import com.mkasana.FamilyTree.Pariwar.Builder.common.CommonAPIs;
import com.mkasana.FamilyTree.Pariwar.Component.Validations.ValidationFunctions;
import com.mkasana.FamilyTree.Pariwar.constants.RestControllersConstant;
import com.mkasana.FamilyTree.Pariwar.model.SessionDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
@Configurable
public class ValidationFunctionsImpl implements ValidationFunctions {

    @Autowired
    CommonAPIs commonAPIs;

    public SessionDetails validateRequest(final HttpHeaders headers, final Boolean compareUserId) throws Exception {
                SessionDetails session = getSessionDetailsFromRequestHeaders(headers);
                if (session == null || session.getToken() == null) {
                    throw new Exception("Failed to authenticate user");
                }

                SessionDetails sessionDB = commonAPIs.getSessionDetailsByToken(session.getToken());
                //System.out.println("Session Details got from DB " + sessionDB);
                if (sessionDB == null) {
                    throw new Exception("Failed to authenticate user, Invalid Token passed");
                }
                if(compareUserId) {
                    if(session.getUserId() != sessionDB.getUserId()
                        || session.getUsername() != sessionDB.getUsername())
                        throw new Exception("Failed to authenticate user, Invalid Token passed");
                }
                return sessionDB;
    }

    private SessionDetails getSessionDetailsFromRequestHeaders(final HttpHeaders headers) throws Exception {
        try {
            SessionDetails session = new SessionDetails();
            Boolean flag = false;
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                //System.out.println("Key : " + entry.getKey() + "\n Value : " + entry.getValue());
                if (entry.getKey().equals(RestControllersConstant.REQUEST_AUTHTOKEN)) {
                    session.setToken(entry.getValue().get(0));
                    flag = Boolean.TRUE;
                }

                if(entry.getKey().equals(RestControllersConstant.REQUEST_USERNAME)) {
                    session.setUsername(entry.getValue().get(0));
                flag = Boolean.TRUE;
                }

                if(entry.getKey().equals(RestControllersConstant.REQUEST_USERID)) {
                    session.setUserId(Integer.parseInt(entry.getValue().get(0)));
                    flag = Boolean.TRUE;
                }

                if (entry.getKey().equals(RestControllersConstant.REQUEST_COOKIES)) {
                    Map<String, String> listTOMap = getMapFromStringOfKeyValue(entry.getValue().get(0));
                    for (Map.Entry<String, String> keyval : listTOMap.entrySet()) {
                        //System.out.println("Key : " + keyval.getKey() + ", Value : " + keyval.getValue());
                        if (keyval.getKey().equals(RestControllersConstant.REQUEST_USERID))
                            session.setUserId(Integer.parseInt(keyval.getValue()));
                        if (keyval.getKey().equals(RestControllersConstant.REQUEST_USERNAME))
                            session.setUsername(keyval.getValue());
                        if (keyval.getKey().equals(RestControllersConstant.REQUEST_AUTHKEY))
                            session.setToken(keyval.getValue());
                        return session;
                    }
                }
            }
            if(flag)
                return session;
            throw new Exception("Authentication failed");
        } catch (Exception e) {
            System.out.println("Failed to validate the User " + e);
            throw new Exception("Authentication failed");
        }
    }

    private Map<String, String> getMapFromStringOfKeyValue(String cookies) throws Exception {
        try {
            Map<String, String> mapOfValues = new HashMap<String, String>();
            String[] listOfCookies = cookies.split(", ");
            for (String str : listOfCookies) {
                //System.out.println("\nStr : " + str);
                String[] KeyValue = str.split("=");
                if (KeyValue[0].equals(RestControllersConstant.REQUEST_USERID)
                        || KeyValue[0].equals(RestControllersConstant.REQUEST_AUTHKEY)
                        || KeyValue[0].equals(RestControllersConstant.REQUEST_USERNAME))
                    mapOfValues.put(KeyValue[0], KeyValue[1]);
            }
            return mapOfValues;
        } catch (Exception e) {
            throw  e;
        }
    }
}
