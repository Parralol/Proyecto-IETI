package com.proyecto.ieti.pemc;

import org.junit.jupiter.api.Test;

import com.proyecto.ieti.pemc.entity.CompanyDTO;

import static org.junit.jupiter.api.Assertions.*;


public class CompanyControllerTests {

    @Test
    public void testDefaultConstructor() {
        CompanyDTO dto = new CompanyDTO();
        assertEquals("", dto.getName());
        assertEquals("", dto.getNit());
        assertEquals("", dto.getAddress());
        assertEquals("", dto.getPhone());
        assertEquals("", dto.getEmail());
        assertEquals("", dto.getContactName());
        assertEquals("", dto.getContactPhone());
        assertEquals("", dto.getContactEmail());
    }

    @Test
    public void testParameterizedConstructor() {
        CompanyDTO dto = new CompanyDTO("ABC Corp", "123456789", "123 Main St", "555-5555", "contact@abc.com", "John Doe", "555-1234", "john.doe@abc.com");
        assertEquals("ABC Corp", dto.getName());
        assertEquals("123456789", dto.getNit());
        assertEquals("123 Main St", dto.getAddress());
        assertEquals("555-5555", dto.getPhone());
        assertEquals("contact@abc.com", dto.getEmail());
        assertEquals("John Doe", dto.getContactName());
        assertEquals("555-1234", dto.getContactPhone());
        assertEquals("john.doe@abc.com", dto.getContactEmail());
    }

}
