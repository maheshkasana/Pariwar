package com.mkasana.FamilyTree.Pariwar.model;

public class Religion {
    int Id;
    String ReligionName;

    public Religion(int id, String religionName) {
        Id = id;
        ReligionName = religionName;
    }

    public Religion() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getReligionName() {
        return ReligionName;
    }

    public void setReligionName(String religionName) {
        ReligionName = religionName;
    }

    @Override
    public String toString() {
        return "Religion{" +
                "Id=" + Id +
                ", ReligionName=" + ReligionName +
                '}';
    }
}
