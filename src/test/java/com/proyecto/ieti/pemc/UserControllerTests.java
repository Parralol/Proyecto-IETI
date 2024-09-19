package com.proyecto.ieti.pemc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.proyecto.ieti.pemc.entity.User;
import com.proyecto.ieti.pemc.entity.UserDto;

import static org.junit.jupiter.api.Assertions.*;


public class UserControllerTests {

    private User user;
    private UserDto userDto;

    @BeforeEach
    public void setUp() {
        userDto = new UserDto("John", "Doe", "john.doe@example.com", "password123", "companyId123");
        user = new User(userDto);
    }

    @Test
    public void testUserCreation() {
        assertNotNull(user.getId());
        assertEquals("John", user.getName());
        assertEquals("Doe", user.getLastName());
        assertEquals("john.doe@example.com", user.getEmail());
        assertNotNull(user.getCreatedAt());
        assertEquals("companyId123", user.getCompanyId());
    }


    @Test
    public void testUpdateUserWithEmptyPassword() {
        UserDto updateDto = new UserDto("Jane", "Smith", "jane.smith@example.com", "", "newCompanyId");
        user.update(updateDto);

        assertEquals("Jane", user.getName());
        assertEquals("Smith", user.getLastName());
        assertEquals("jane.smith@example.com", user.getEmail());
    }

    @Test
    public void testSettersAndGetters() {
        user.setName("Michael");
        user.setLastName("Jordan");
        user.setEmail("michael.jordan@example.com");
        
        assertEquals("Michael", user.getName());
        assertEquals("Jordan", user.getLastName());
        assertEquals("michael.jordan@example.com", user.getEmail());
    }
}
