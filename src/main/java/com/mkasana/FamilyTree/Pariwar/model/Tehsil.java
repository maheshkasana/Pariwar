package com.mkasana.FamilyTree.Pariwar.model;

public class Tehsil {
    int Id;
    int DistrictId;
    String TehsilName;
    String TehsilCode;
    District district;

    public Tehsil(int id, int districtId, String tehsilName, String tehsilCode, District districtIn) {
        Id = id;
        DistrictId = districtId;
        TehsilName = tehsilName;
        TehsilCode = tehsilCode;
        district = districtIn;
    }

    public Tehsil() {

    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getDistrictId() {
        return DistrictId;
    }

    public void setDistrictId(int districtId) {
        DistrictId = districtId;
    }

    public String getTehsilName() {
        return TehsilName;
    }

    public void setTehsilName(String tehsilName) {
        TehsilName = tehsilName;
    }

    public String getTehsilCode() {
        return TehsilCode;
    }

    public void setTehsilCode(String tehsilCode) {
        TehsilCode = tehsilCode;
    }

    @Override
    public String toString() {
        return "Tehsil{" +
                "Id=" + Id +
                ", DistrictId=" + DistrictId +
                ", TehsilName='" + TehsilName + '\'' +
                ", TehsilCode='" + TehsilCode + '\'' +
                ", district=" + district +
                '}';
    }
}
