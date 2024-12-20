package com.proyecto.ieti.pemc.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Document("users")
public class User implements Serializable{

    @Id
    private  String id;

    private Date createdAt;
    private String name;
    private String lastName;
    private String email;
    private String passwordHash;
    private String companyId;

    public User(){
        this.createdAt = new Date();
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public User(String id, String name, String lastName, String email, String password, String companyId) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.companyId = companyId;
        this.passwordHash = new BCryptPasswordEncoder().encode(password);
        this.createdAt = new Date();
    }


    public User(UserDto userDto) {
        this.id = UUID.randomUUID().toString();
        this.name = userDto.getName();
        this.lastName = userDto.getLastName();
        this.email = userDto.getEmail();
        this.passwordHash = new BCryptPasswordEncoder().encode(userDto.getPassword());
        this.createdAt = new Date();
        this.companyId = userDto.getCompanyId();
    }

    
    public void setCreatedAt(Date createdAt) {
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", createdAt=" + createdAt + ", name=" + name + ", lastName=" + lastName + ", email="
                + email + ", companyId=" + companyId + "]";
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void update(UserDto userDto) {
        this.name = userDto.getName();
        this.lastName = userDto.getLastName();
        this.email = userDto.getEmail();
        if (!userDto.getPassword().isEmpty()) {
            this.passwordHash = new BCryptPasswordEncoder().encode(userDto.getPassword());
        }
    }

    public String getCompanyId() {
        return companyId;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

}
