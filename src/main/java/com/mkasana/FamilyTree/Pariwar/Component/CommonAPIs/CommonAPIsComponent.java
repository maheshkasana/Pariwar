package com.mkasana.FamilyTree.Pariwar.Component.CommonAPIs;

import com.mkasana.FamilyTree.Pariwar.model.UserFullDetails;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CommonAPIsComponent {

    public UserFullDetails getUserFullDetailsByToken(final String token);

    public List<UserFullDetails> getUserParentsDetailsByToken(final String token);

    public List<UserFullDetails> getBasicUserParentsDetailsByToken(final String token);

    public List<UserFullDetails> getUserSiblingsDetailsByToken(final String token);

    public List<UserFullDetails> getBasicUserSiblingsDetailsByToken(final String token);

    public List<UserFullDetails> getUserChildsDetailsByToken(final String token);

    public List<UserFullDetails> getBasicUserChildsDetailsByToken(final String token);

}
