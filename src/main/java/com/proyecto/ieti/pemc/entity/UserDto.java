package com.proyecto.ieti.pemc.entity;

public class UserDto {
    private final String name;
    private final String lastName;
    private final String email;
    private final String password;
    private final String companyId;

    public UserDto() {
        this.name = "";
        this.lastName = "";
        this.email = "";
        this.password = "";
        this.companyId = "";
    }

    public UserDto(String name, String lastName, String email, String password, String companyId) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.companyId = companyId;
    }



    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCompanyId() {return companyId;}
}
