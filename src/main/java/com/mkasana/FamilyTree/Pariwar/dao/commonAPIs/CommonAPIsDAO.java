package com.mkasana.FamilyTree.Pariwar.dao.commonAPIs;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;


public interface CommonAPIsDAO {

    public ResultSet getBasicUserDetailsByUsername(final String username) throws Exception;

    public void setSessionDetails(final int UserId,final String username, final String GUID) throws Exception;
}
