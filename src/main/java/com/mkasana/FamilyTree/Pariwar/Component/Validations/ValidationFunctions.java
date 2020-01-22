package com.mkasana.FamilyTree.Pariwar.Component.Validations;

import com.mkasana.FamilyTree.Pariwar.model.SessionDetails;
import org.springframework.http.HttpHeaders;

public interface ValidationFunctions {

    public SessionDetails validateRequest(final HttpHeaders headers, final Boolean compareUserId) throws Exception;
}
