package com.proyecto.ieti.pemc.service;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.proyecto.ieti.pemc.entity.User;

public interface UserService extends MongoRepository<User, String>{
    
    public User findByName(String name);

    @Query("{ }")
    List<User> findAllUsersOrderByScoreDesc(Sort sort);
}