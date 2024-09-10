package com.proyecto.ieti.pemc.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.proyecto.ieti.pemc.entity.User;

public interface UserService extends MongoRepository<User, String>{
    
    public User findByName(String name);

}