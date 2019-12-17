package com.mkasana.FamilyTree.Pariwar.model;

public class VillageTown {
    int Id;
    int DistrictId;
    String VillageTownLocalAreaName;
    String VillageTownLocalAreaCode;
    int PinCode;
    int Flag;
    District district;


    public VillageTown(int id, int districtId, String villageTownLocalAreaName, int pinCode, int flag, District districtIn, String VillageTownLocalAreaCodeIn) {
        Id = id;
        DistrictId = districtId;
        VillageTownLocalAreaName = villageTownLocalAreaName;
        PinCode = pinCode;
        Flag = flag;
        district = districtIn;
        VillageTownLocalAreaCode = VillageTownLocalAreaCodeIn;
    }

    public String getVillageTownLocalAreaCode() {
        return VillageTownLocalAreaCode;
    }

    public void setVillageTownLocalAreaCode(String villageTownLocalAreaCode) {
        VillageTownLocalAreaCode = villageTownLocalAreaCode;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public VillageTown() {
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

    public String getVillageTownLocalAreaName() {
        return VillageTownLocalAreaName;
    }

    public void setVillageTownLocalAreaName(String villageTownLocalAreaName) {
        VillageTownLocalAreaName = villageTownLocalAreaName;
    }

    public int getPinCode() {
        return PinCode;
    }

    public void setPinCode(int pinCode) {
        PinCode = pinCode;
    }

    public int getFlag() {
        return Flag;
    }

    public void setFlag(int flag) {
        Flag = flag;
    }

    @Override
    public String toString() {
        return "VillageTown{" +
                "Id=" + Id +
                ", DistrictId=" + DistrictId +
                ", VillageTownLocalAreaName='" + VillageTownLocalAreaName + '\'' +
                ", VillageTownLocalAreaCode='" + VillageTownLocalAreaCode + '\'' +
                ", PinCode=" + PinCode +
                ", Flag=" + Flag +
                ", district=" + district +
                '}';
    }
}
