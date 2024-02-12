package com.exampled.corporatesocialmedia.enums;

public enum UserRoleEnum {
    Admin("admin"),
    Manager("manager"),
    Employee("employee");

    private String role;

     UserRoleEnum(String role){
        this.role = role;
    }

    public String getRole(){
         return role;
    }
}
