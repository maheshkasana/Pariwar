package com.mkasana.FamilyTree.Pariwar.dao.Register.RegisterUser.Impl;

import com.mkasana.FamilyTree.Pariwar.dao.DatabaseConnection;
import com.mkasana.FamilyTree.Pariwar.dao.Register.RegisterUser.UserRegistrationDao;
import com.mkasana.FamilyTree.Pariwar.model.userRegistrationAddressDetails;
import com.mkasana.FamilyTree.Pariwar.model.userRegistrationReligionDetails;
import com.mkasana.FamilyTree.Pariwar.model.userRegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.time.Instant;

@Component
@Configurable
public class UserRegistrationDaoImpl implements UserRegistrationDao {


    @Autowired
    public DatabaseConnection databaseConnection;

    /**
     * this is for Registering basic details
     * @param user
     * @return
     */
    public void registerUserBasicDetails(final userRegistrationRequest user) throws Exception{
        String Function = "UserRegistrationDaoImpl:registerUserBasicDetails";
        long ut1 = Instant.now().getEpochSecond();

        String query = "INSERT INTO userInfo(Username, FirstName,NickName, Email, Phone, DateOfBirth, Gender, Passphrase, UserAddressDetailsId, SubcasteReligion, Flag, Created, Updated, About) VALUES("
                        + "'" + user.getUsername() + "',"
                        + "'" + user.getFirstname() + "',"
                        + "'',"
                        + "'" + user.getContact().getEmailAddress() + "',"
                        + "'" + user.getContact().getPhone() + "',"
                        + "'" + user.getDateofbirth() + "',"
                        + user.getGender() + ","
                        + "'" + user.getPassword() + "',"
                        + 0 + ","
                        + 0 + ","
                        + 1 + ","
                        + ut1 + ","
                        + ut1 + ","
                        + "' ');";

        try {
            databaseConnection.executeUpdate(query);
            databaseConnection.commit();
        } catch(Exception e) {
            String error = "[Error] UserRegistrationDaoImpl:registerUserBasicDetails Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }

    }


    public ResultSet getUserIdByUsername(final String username) throws Exception {
        String Function = "UserRegistrationDaoImpl:getUserIdByUsername";

        String query = "SELECT Id FROM userInfo WHERE username = '"+username+"';";

        try {
            return databaseConnection.executeQuery(query);
        } catch(Exception e) {
            String error = "[Error] UserRegistrationDaoImpl:getUserIdByUsername Exception while executing query [" + query + "]\n" + e;
            System.out.println(error);
            throw new Exception(error);
        }
    }


    public  void createOrUpdateUserAddress(userRegistrationAddressDetails address, int userId) throws Exception {
        String Function = "UserRegistrationDaoImpl:createOrUpdateUserAddress";

        try {
                int addressId = 0;
                String query1 = "SELECT Id FROM UserAddressDetails WHERE UserId = "+userId+";";
                ResultSet resultSet1 = databaseConnection.executeQuery(query1);
                if(resultSet1.next()) {
                    addressId = resultSet1.getInt("Id");
                }

                if(addressId <= 0) {
                    String query = "INSERT INTO UserAddressDetails(UserId, firstAddress, VillageId, TehsilId, DistrictId, StateId, Flag) VALUES ("
                            + userId + ","
                            + "'" + address.getLocality() + "',"
                            + address.getVillage() + ","
                            + address.getTehsil() + ","
                            + address.getDistrict() + ","
                            + address.getState() + ", 1);";

                    databaseConnection.executeUpdate(query);
                    databaseConnection.commit();
                    String query2 = "SELECT Id FROM UserAddressDetails WHERE UserId = "+userId+";";
                    ResultSet resultSet2 = databaseConnection.executeQuery(query2);
                    if(resultSet2.next()) {
                        addressId = resultSet2.getInt("Id");
                        String query3 = "UPDATE userInfo SET UserAddressDetailsId = " + addressId + " WHERE Id = " + userId + ";";
                        databaseConnection.executeUpdate(query3);
                        databaseConnection.commit();
                    }
                } else {
                    String query = "UPDATE UserAddressDetails SET "
                                    + " firstAddress = '" + address.getLocality() + "',"
                                    + " VillageId = "+ address.getVillage() + ","
                                    + " TehsilId = "+ address.getTehsil() + ","
                                    + " DistrictId = " + address.getDistrict() + ","
                                    + " StateId = "+ address.getState()
                                    + " WHERE Id = " + addressId;

                    databaseConnection.executeUpdate(query);
                    databaseConnection.commit();
                }
        } catch(Exception e) {
            throw new Exception("Failed to Execute Query " + e);
        }
    }



    public  void createOrUpdateUserReligiousDetails(final userRegistrationReligionDetails religious, final int userId) throws Exception {
        String Function = "UserRegistrationDaoImpl:createOrUpdateUserReligiousDetails";

        try {
            int religiousId = 0;
            String query1 = "SELECT Id FROM UserReligionMapDetails WHERE UserId = "+userId+";";
            ResultSet resultSet1 = databaseConnection.executeQuery(query1);
            if(resultSet1.next()) {
                religiousId = resultSet1.getInt("Id");
            }

            if(religiousId <= 0) {
                String query = "INSERT INTO UserReligionMapDetails(UserId, ReligionId, CasteId, SubCasteId, Flag) VALUES ("
                        + userId + ","
                        + religious.getReligion() + ","
                        + religious.getCaste() + ","
                        + religious.getSubCaste() + ", 1);";

                databaseConnection.executeUpdate(query);
                databaseConnection.commit();
                String query2 = "SELECT Id FROM UserReligionMapDetails WHERE UserId = "+userId+";";
                ResultSet resultSet2 = databaseConnection.executeQuery(query2);
                if(resultSet2.next()) {
                    religiousId = resultSet2.getInt("Id");
                    String query3 = "UPDATE userInfo SET SubcasteReligion = " + religiousId + " WHERE Id = " + userId + ";";
                    databaseConnection.executeUpdate(query3);
                    databaseConnection.commit();
                }
            } else {
                String query = "UPDATE UserReligionMapDetails SET "
                        + " ReligionId = "+ religious.getReligion() + ","
                        + " CasteId = "+ religious.getCaste() + ","
                        + " SubCasteId = " + religious.getSubCaste()
                        + " WHERE Id = " + religiousId;

                databaseConnection.executeUpdate(query);
                databaseConnection.commit();
            }
        } catch(Exception e) {
            throw new Exception("Failed to Execute Query " + e);
        }
    }
}
