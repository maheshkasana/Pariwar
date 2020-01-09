package com.mkasana.FamilyTree.Pariwar.Component.CommonAPIs;

import com.mkasana.FamilyTree.Pariwar.model.UserFullDetails;
import org.springframework.web.bind.annotation.PathVariable;

public interface CommonAPIsComponent {

    public UserFullDetails getUserFullDetailsByToken(final String token);
}
