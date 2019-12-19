package com.mkasana.FamilyTree.Pariwar.model;

public class VillageTown {
    int Id;
    int TehsilId;
    String VillageTownLocalAreaName;
    String VillageTownLocalAreaCode;
    int PinCode;
    int Flag;
    Tehsil tehsil;


    public VillageTown(int id, int tehsilId, String villageTownLocalAreaName, int pinCode, int flag, Tehsil tehsilIn, String VillageTownLocalAreaCodeIn) {
        Id = id;
        TehsilId = tehsilId;
        VillageTownLocalAreaName = villageTownLocalAreaName;
        PinCode = pinCode;
        Flag = flag;
        tehsil = tehsilIn;
        VillageTownLocalAreaCode = VillageTownLocalAreaCodeIn;
    }

    public String getVillageTownLocalAreaCode() {
        return VillageTownLocalAreaCode;
    }

    public void setVillageTownLocalAreaCode(String villageTownLocalAreaCode) {
        VillageTownLocalAreaCode = villageTownLocalAreaCode;
    }


    public VillageTown() {
    }

    public int getId() {
        return Id;
    }

    public int getTehsilId() {
        return TehsilId;
    }

    public void setTehsilId(int tehsilId) {
        TehsilId = tehsilId;
    }

    public Tehsil getTehsil() {
        return tehsil;
    }

    public void setTehsil(Tehsil tehsil) {
        this.tehsil = tehsil;
    }

    public void setId(int id) {
        Id = id;
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
                ", TehsilId=" + TehsilId +
                ", VillageTownLocalAreaName='" + VillageTownLocalAreaName + '\'' +
                ", VillageTownLocalAreaCode='" + VillageTownLocalAreaCode + '\'' +
                ", PinCode=" + PinCode +
                ", Flag=" + Flag +
                ", tehsil=" + tehsil +
                '}';
    }
}
