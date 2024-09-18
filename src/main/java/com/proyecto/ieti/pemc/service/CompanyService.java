package com.proyecto.ieti.pemc.service;

import com.proyecto.ieti.pemc.entity.Company;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyService extends MongoRepository<Company, String> {


}
