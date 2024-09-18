package com.proyecto.ieti.pemc.entity;

import java.util.List;

public class CompanyDTO {
    private final String name;
    private final String nit;
    private final String address;
    private final String phone;
    private final String email;
    private final String contactName;
    private final String contactPhone;
    private final String contactEmail;
    private List<User> usuariosIds;


    public CompanyDTO() {
        this.name = "";
        this.nit = "";
        this.address = "";
        this.phone = "";
        this.email = "";
        this.contactName = "";
        this.contactPhone = "";
        this.contactEmail = "";
    }


    public CompanyDTO(String name, String nit, String address, String phone, String email, String contactName, String contactPhone, String contactEmail) {
        this.name = name;
        this.nit = nit;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.contactName = contactName;
        this.contactPhone = contactPhone;
        this.contactEmail = contactEmail;
    }

    public String getContactName() {
        return contactName;
    }

    public String getName() {
        return name;
    }

    public String getNit() {
        return nit;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public List<User> getUsuariosIds() {
        return usuariosIds;
    }

    public void setUsuariosIds(List<User> usuariosIds) {
        this.usuariosIds = usuariosIds;
    }
}
