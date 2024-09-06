package com.acejsaul.ApiLibrary.entities.enums;

public enum UserRole {
    ADMIN(1),
    USER(2);

    private int role;

    UserRole(int role){
        this.role = role;
    }

    public int getRole() {
        return role;
    }
}
