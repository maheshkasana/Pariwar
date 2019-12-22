package com.mkasana.FamilyTree.Pariwar.model;

public enum  usernameStatus {
    INVALID(0),
    VALID(1),
    AVAILABLE(2),
    ALREADYUSED(3),
    FAILED(4);

    private final int value;

    usernameStatus(int val) {
        this.value = val;
    }

    public int getValue() {
        return this.value;
    }
}
