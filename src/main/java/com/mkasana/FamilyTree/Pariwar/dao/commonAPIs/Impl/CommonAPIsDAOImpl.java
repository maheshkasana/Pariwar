package com.mkasana.FamilyTree.Pariwar.dao.commonAPIs.Impl;

import com.mkasana.FamilyTree.Pariwar.dao.DatabaseConnection;
import com.mkasana.FamilyTree.Pariwar.dao.commonAPIs.CommonAPIsDAO;
import com.mkasana.FamilyTree.Pariwar.model.SearchFilters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.time.Instant;


@Component
@Configurable
public class CommonAPIsDAOImpl implements CommonAPIsDAO {

    @Autowired
    private DatabaseConnection databaseConnection;

    public ResultSet getBasicUserDetailsByUsername(final String username) throws Exception {
        String Function = "CommonAPIsDAOImpl:getBasicUserDetailsByUsername";

        String query = "SELECT * FROM userinfo WHERE Username = '"+username+"';";

        try {
            return databaseConnection.executeQuery(query);
        } catch(Exception e) {
            String error = "[Error] "+Function+" Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }

    public void setSessionDetails(final int UserId,final String username, final String GUID) throws Exception {
        String Function = "CommonAPIsDAOImpl:setSessionDetails";
        long ut1 = Instant.now().getEpochSecond();

        String query = "INSERT INTO UserSessionManagement(UserId, Username, Token, Created, Updated, DeleteIt, Flag) VALUES \n"
                + "(" + UserId + ",'" + username + "','" + GUID + "'," + ut1 + "," + ut1 + "," + 0 + "," + 0 + ");";
        try {
            databaseConnection.executeUpdate(query);
            databaseConnection.commit();
        } catch(Exception e) {
            String error = "[Error] CommonAPIsDAOImpl:setSessionDetails Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }

    public void updateSessionDetailsLastUse(final String GUID) throws Exception {
        String Function = "CommonAPIsDAOImpl:updateSessionDetailsLastUse";
        long ut1 = Instant.now().getEpochSecond();

        String query = "UPDATE UserSessionManagement SET Updated =" + ut1 + ", Flag = Flag + 1 WHERE Token = '"+ GUID + "';";
        try {
            databaseConnection.executeUpdate(query);
            databaseConnection.commit();
        } catch(Exception e) {
            String error = "[Error] CommonAPIsDAOImpl:updateSessionDetailsLastUse Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }

    public void deleteOldSessionDetails() throws Exception {
        String Function = "CommonAPIsDAOImpl:deleteOldSessionDetails";
        long ut1 = Instant.now().getEpochSecond();

        String query = "DELETE FROM UserSessionManagement WHERE " + ut1 + " - Updated > 600 OR " + ut1 + " - Created > 24*60*60 OR Flag > 100";
        try {
            databaseConnection.executeUpdate(query);
            databaseConnection.commit();
        } catch(Exception e) {
            String error = "[Error] CommonAPIsDAOImpl:deleteOldSessionDetails Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }

    public ResultSet getSessionDetailsByToken(final String GUID) throws Exception {
        String Function = "CommonAPIsDAOImpl:getSessionDetailsByToken";

        String query = "SELECT * FROM UserSessionManagement WHERE Token = '"+GUID+"';";

        try {
            return databaseConnection.executeQuery(query);
        } catch(Exception e) {
            String error = "[Error] CommonAPIsDAOImpl:getSessionDetailsByToken Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }

    public ResultSet getUserInfoDetailsByUserId(final int userId) throws Exception {
        String Function = "CommonAPIsDAOImpl:getUserInfoDetailsByUserId";

        String query = "SELECT * FROM userinfo WHERE Id = "+userId+";";

        try {
            return databaseConnection.executeQuery(query);
        } catch(Exception e) {
            String error = "[Error] "+Function+" Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }

    public ResultSet getRegistrationAddressDetailsByAddressDetailsId(final int addressDetailId) throws Exception {
        String Function = "CommonAPIsDAOImpl:getRegistrationAddressDetailsByAddressDetailsId";

        String query = "SELECT * FROM UserAddressDetails WHERE Id = "+addressDetailId+";";

        try {
            return databaseConnection.executeQuery(query);
        } catch(Exception e) {
            String error = "[Error] "+Function+" Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }

    public ResultSet getRegistrationReligionDetailsByReligiousDetailId(final int ReligiousDetailsId) throws Exception {
        String Function = "CommonAPIsDAOImpl:getRegistrationReligionDetailsByReligiousDetailId";

        String query = "SELECT * FROM UserReligionMapDetails WHERE Id = "+ReligiousDetailsId+";";

        try {
            return databaseConnection.executeQuery(query);
        } catch(Exception e) {
            String error = "[Error] "+Function+" Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }


    public ResultSet getUserParentIdList(final int userId) throws Exception {
        String Function = "CommonAPIsDAOImpl:getUserParentIdList";
        String query = "SELECT * FROM UserParent WHERE UserId = "+userId+";";
        try {
            return databaseConnection.executeQuery(query);
        } catch(Exception e) {
            String error = "[Error] "+Function+" Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }

    public ResultSet getUserChildsIdList(final int userId) throws Exception {
        String Function = "CommonAPIsDAOImpl:getUserChildsIdList";
        String query = "SELECT * FROM UserChild WHERE UserId = "+userId+";";
        try {
            return databaseConnection.executeQuery(query);
        } catch(Exception e) {
            String error = "[Error] "+Function+" Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }

    public ResultSet getUserSpouseIdList(final int userId) throws Exception {
        String Function = "CommonAPIsDAOImpl:getUserSpouseIdList";
        String query = "SELECT * FROM UserSpouse WHERE UserId = "+userId+";";
        try {
            return databaseConnection.executeQuery(query);
        } catch(Exception e) {
            String error = "[Error] "+Function+" Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }

    public ResultSet searchUsersBasedOnPassedConstrains(final SearchFilters filters) throws Exception {
        String Function = "CommonAPIsDAOImpl:searchUsersBasedOnPassedConstrains";
        String query = "SELECT userinfo.Id AS Id, userinfo.Username AS username, userinfo.FirstName AS name, userinfo.Gender AS gender, AD.firstAddress AS localaddress,"
                        + " CONCAT(USC.UserSubcasteName , ', ' , UC.UserCasteName , ', ' , URD.ReligionName) AS Religion,"
                        + " CONCAT(UAV.VillageTownLocalAreaName , ', ' , UAT.TehsilName , ', '  , UAD.DistrictCode, ', ' , UAS.StateName) AS Address FROM userinfo"
                        + " JOIN UserAddressDetails AS AD ON AD.Id = userinfo.UserAddressDetailsId AND AD.UserId = userinfo.Id"
                        + " JOIN UserReligionMapDetails AS RD ON RD.Id = userinfo.SubcasteReligion AND RD.UserId = userinfo.Id"
                        + " LEFT JOIN UserReligion AS URD ON URD.Id = RD.ReligionId"
                        + " LEFT JOIN UserCaste AS UC ON UC.Id = RD.CasteId"
                        + " LEFT JOIN UserSubcaste AS USC ON USC.Id = RD.SubCasteId"
                        + " LEFT JOIN StateDetails AS UAS ON UAS.Id = AD.StateId"
                        + " LEFT JOIN DistrictDetails AS UAD ON UAD.Id = AD.DistrictId"
                        +" LEFT JOIN TehsilDetails AS UAT ON UAT.Id = AD.TehsilId"
                        + " LEFT JOIN VillageTownLocalAreaDetails AS UAV ON UAV.Id = AD.VillageId"
                        + " WHERE (" + filters.getState() + " <=0 OR " + filters.getState() + " = AD.StateId)"
                        + " AND (" + filters.getDistrict() + "<=0 OR "+ filters.getDistrict() + "= AD.DistrictId)"
                        + " AND (" + filters.getTehsil() + "<=0 OR "+ filters.getTehsil() +" = AD.TehsilId)"
                        + " AND (" + filters.getVillage() +"<=0 OR " + filters.getVillage() + "= AD.VillageId)"
                        + " AND (" + filters.getReligion() + "<=0 OR " + filters.getReligion() + "= RD.ReligionId)"
                        + " AND (" + filters.getCaste() + "<=0 OR " + filters.getCaste() + "= RD.CasteId)"
                        + " AND (" + filters.getSubcaste() + "<=0 OR " + filters.getSubcaste() + "= RD.SubCasteId)"
                        + " ORDER BY userinfo.Id ASC;";
        System.out.println(query);
        try {
            return databaseConnection.executeQuery(query);
        } catch(Exception e) {
            String error = "[Error] "+Function+" Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }


    public void addParentToUserId(final int userId, final int parentId) throws Exception {
        String Function = "CommonAPIsDAOImpl:addParentToUserId";
        long ut1 = Instant.now().getEpochSecond();

        String query = "INSERT INTO USERPARENT (UserId, ParentId, ParentType, Flag) VALUES ("+userId +","+ parentId +",0,0)";
        try {
            databaseConnection.executeUpdate(query);
            databaseConnection.commit();
        } catch(Exception e) {
            String error = "[Error] CommonAPIsDAOImpl:addParentToUserId Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }

    public void addChildToParentId(final int parentId, final int userId) throws Exception {
        String Function = "CommonAPIsDAOImpl:addChildToParentId";
        long ut1 = Instant.now().getEpochSecond();

        String query = "INSERT INTO UserChild (UserId, ChildId, ChildType, Flag) VALUES("+parentId +","+ userId +",0,0)";
        try {
            databaseConnection.executeUpdate(query);
            databaseConnection.commit();
        } catch(Exception e) {
            String error = "[Error] CommonAPIsDAOImpl:addChildToParentId Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }

    @Override
    public void addSpouseToUser(final int userId, final int spouseId) throws Exception {
        String Function = "CommonAPIsDAOImpl:addSpouseToUser";
        long ut1 = Instant.now().getEpochSecond();

        String query = "INSERT INTO UserSpouse (UserId, SpouseId, SpouseType, Flag) VALUES("+userId +","+ spouseId +",0,0)";
        try {
            databaseConnection.executeUpdate(query);
            databaseConnection.commit();
        } catch(Exception e) {
            String error = "[Error] CommonAPIsDAOImpl:addSpouseToUser Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }


}
