package com.proyecto.ieti.pemc.controller;


import com.proyecto.ieti.pemc.entity.Company;
import com.proyecto.ieti.pemc.entity.CompanyDTO;
import com.proyecto.ieti.pemc.entity.User;
import com.proyecto.ieti.pemc.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
@CrossOrigin
@RestController
@RequestMapping("/v1/companies/")
public class CompanyController {
    private final CompanyService companyService;
    public CompanyController(@Autowired CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody CompanyDTO dto) {
        Company company = new Company(
                dto.getName(),
                dto.getNit(),
                dto.getAddress(),
                dto.getPhone(),
                dto.getEmail(),
                dto.getContactName(),
                dto.getContactPhone(),
                dto.getContactEmail());
        companyService.save(company);

        return ResponseEntity.created(URI.create("")).body(null);
    }

    @GetMapping("{id}")
    public ResponseEntity<Company> findById(@PathVariable String id) {
        System.out.println(id);
        return ResponseEntity.ok(companyService.findById(id).get());
    }

    @PutMapping
    public ResponseEntity<User> updateCompany(@PathVariable("id") String id, @RequestBody CompanyDTO dto) {
        Company company = companyService.findById(id).get();
        company.setEmail(dto.getEmail());
        company.setContactName(dto.getContactName());
        company.setName(dto.getName());
        company.setNit(dto.getNit());
        company.setPhone(dto.getPhone());
        company.setContactEmail(dto.getContactEmail());
        company.setContactPhone(dto.getContactPhone());
        companyService.save(company);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCompany(@PathVariable("id") String id) {
        companyService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
