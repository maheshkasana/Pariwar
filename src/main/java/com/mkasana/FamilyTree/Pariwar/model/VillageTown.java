package com.mkasana.FamilyTree.Pariwar.model;

public class VillageTown {
    int Id;
    int DistrictId;
    String VillageTownLocalAreaName;
    int PinCode;
    int Flag;

    public VillageTown(int id, int districtId, String villageTownLocalAreaName, int pinCode, int flag) {
        Id = id;
        DistrictId = districtId;
        VillageTownLocalAreaName = villageTownLocalAreaName;
        PinCode = pinCode;
        Flag = flag;
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
                ", PinCode=" + PinCode +
                ", Flag=" + Flag +
                '}';
    }
}
