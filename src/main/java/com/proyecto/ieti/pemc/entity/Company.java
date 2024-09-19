package com.proyecto.ieti.pemc.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;


@Document("companies")
public class Company implements Serializable {
    @Id

    private  String id;
    private String name;
    private String nit;
    private String address;
    private String phone;
    private String email;
    private String contactName;
    private String contactPhone;
    private String contactEmail;
    private List<User> usuariosIds;

    public Company(String name, String nit, String address, String phone, String email, String contactName, String contactPhone, String contactEmail) {
        this.name = name;
        this.nit = nit;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.contactName = contactName;
        this.contactPhone = contactPhone;
        this.contactEmail = contactEmail;
    }

    public Company(){

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

    public String getContactName() {
        return contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }


    public List<User> getUsuariosIds() {
        return usuariosIds;
    }

    public void setUsuariosIds(List<User> usuariosIds) {
        this.usuariosIds = usuariosIds;
    }
}
