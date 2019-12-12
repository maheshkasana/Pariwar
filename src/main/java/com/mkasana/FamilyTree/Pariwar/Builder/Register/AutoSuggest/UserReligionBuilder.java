package com.mkasana.FamilyTree.Pariwar.Builder.Register.AutoSuggest;

import com.mkasana.FamilyTree.Pariwar.dao.Register.AutoSuggest.Impl.UserReligionDaoImpl;
import com.mkasana.FamilyTree.Pariwar.dao.Register.AutoSuggest.UserReligionDao;
import com.mkasana.FamilyTree.Pariwar.model.Caste;
import com.mkasana.FamilyTree.Pariwar.model.Religion;
import com.mkasana.FamilyTree.Pariwar.model.SubCaste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Configurable
@Component
public class UserReligionBuilder {

    @Autowired
    public UserReligionDao userReligionDao;


    /********************************************
     * All the below Builders are for Religion *
     *******************************************/


    /**
     * This function is to return Religion for Religion Id
     * @param id
     * @return
     */
    public Religion getReligionById(final int id) {
        final String function = "UserReligionBuilder:getReligionById";

        ResultSet resultSet;
        Religion religion = new Religion();
        try {
            resultSet = userReligionDao.getUserReligionById(id);
            if(resultSet.next()) {
                religion.setId(resultSet.getInt("Id"));
                religion.setReligionName(resultSet.getString("ReligionName"));
            }
            //Todo Convert the result set to the religion
        } catch(Exception e) {
            System.out.println(e);
        }
        return religion;
    }


    /**
     * this function is for returning All the available religions
     * @return
     */
    public List<Religion> getAllReligions() {
        final String function = "UserReligionBuilder:getAllReligions";

        ResultSet resultSet;
        List<Religion> religions = new ArrayList<>();

        try {
            resultSet = userReligionDao.getUserAllReligions();
            while(resultSet.next()) {
                Religion religion = new Religion();
                religion.setId(resultSet.getInt("Id"));
                religion.setReligionName(resultSet.getString("ReligionName"));
                religions.add(religion);
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return religions;
    }



    /********************************************
     * All the below Builders are for Caste *
     *******************************************/

    /**
     * This function is to Convert resultSet to Caste
     * @param
     */
    public Caste convertResultSetToCaste(@NotNull  ResultSet resultSet) throws Exception{
        Caste caste = new Caste();
        caste.setId(resultSet.getInt("Id"));
        caste.setUserCasteName(resultSet.getString("UserCasteName"));
        caste.setUserReligionId(resultSet.getInt("UserReligionId") );
        caste.setReligionName(resultSet.getString("ReligionName"));
        return caste;
    }

    /**
     * This function is to return Caste for Caste Id
     * @param id
     * @return
     */
    public Caste getCasteById(final int id) {
        final String function = "UserReligionBuilder:getCasteById";

        ResultSet resultSet;
        Caste caste = null;
        try {
            resultSet = userReligionDao.getUserCasteById(id);
            if(resultSet.next()) {
                caste = convertResultSetToCaste(resultSet);
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return caste;
    }


    /**
     * This function is to return All Caste
     * @param
     * @return
     */
    public List<Caste> getAllCaste() {
        final String function = "UserReligionBuilder:getAllCaste";

        ResultSet resultSet;
        List<Caste> castes = new ArrayList<>();
        try {
            resultSet = userReligionDao.getUserAllCaste();
            while(resultSet.next()) {
                Caste caste;
                caste = convertResultSetToCaste(resultSet);
                if(caste != null)
                    castes.add(caste);
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return castes;
    }

    /**
     * this is to return all the caste belongs to the passed religion id.
     * @param religionId
     * @return
     */
    public List<Caste> getAllCasteOfReligion(final int religionId) {
        String function = "UserReligionBuilder:getAllCasteOfReligion";

        ResultSet resultSet;
        List<Caste> castes = new ArrayList<>();
        try {
            resultSet = userReligionDao.getUserAllCasteOfReligion(religionId);
            while(resultSet.next()) {
                Caste caste;
                caste = convertResultSetToCaste(resultSet);
                if(caste != null)
                    castes.add(caste);
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return castes;
    }






    /*********************************************
     * All the below Builder are for Sub-caste *
     *********************************************/

    /**
     * This function is to Convert resultSet to SubCaste
     * @param
     */
    public SubCaste convertResultSetToSubCaste(@NotNull  ResultSet resultSet) throws Exception{
        SubCaste subCaste = new SubCaste();
        subCaste.setId(resultSet.getInt("Id"));
        subCaste.setUserSubCasteName(resultSet.getString("UserSubCasteName"));
        subCaste.setUserCasteId(resultSet.getInt("UserCasteId") );
        subCaste.setUserReligionId(resultSet.getInt("UserReligionId"));
        subCaste.setUserCasteName(resultSet.getString("UserCasteName"));
        subCaste.setReligionName(resultSet.getString("ReligionName"));
        return subCaste;
    }


    /**
     * This function is to return the Sub-Caste by Id
     * @param id
     */
    public SubCaste getSubCasteById(final int id) {
        String function = "UserReligionBuilder:getSubCasteById";

        ResultSet resultSet;
        SubCaste subCaste = null;
        try {
            resultSet = userReligionDao.getUserSubCasteById(id);
            if(resultSet.next()) {
                subCaste = convertResultSetToSubCaste(resultSet);
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return subCaste;
    }



    /**
     * This function is to return the All Sub-Caste
     * @param
     */
    public List<SubCaste> getAllSubCaste() {
        String function = "UserReligionBuilder:getAllSubCaste";

        ResultSet resultSet;
        List<SubCaste> subCastes = new ArrayList<>();
        try {
            resultSet = userReligionDao.getUserAllSubCaste();
            while(resultSet.next()) {
                SubCaste subCaste = null;
                subCaste = convertResultSetToSubCaste(resultSet);
                if(subCaste != null)
                    subCastes.add(subCaste);
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return subCastes;
    }


    /**
     * this is to return all the Sub-caste belongs to the passed Caste Id or religion id.
     * @param casteId, religionId

     * @return
     */
    public List<SubCaste> getSuggestAllSubCasteByCasteIdOrReligionId(final int casteId, final int religionId) {

        String function = "UserReligionBuilder:getAllSubCaste:getSuggestAllSubCasteByCasteIdOrReligionId";

        ResultSet resultSet;
        List<SubCaste> subCastes = new ArrayList<>();
        try {
            resultSet = userReligionDao.getAllSubCasteByCasteIdOrReligionId(casteId, religionId);
            while(resultSet.next()) {
                SubCaste subCaste = null;
                subCaste = convertResultSetToSubCaste(resultSet);
                if(subCaste != null)
                    subCastes.add(subCaste);
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return subCastes;
    }


}
