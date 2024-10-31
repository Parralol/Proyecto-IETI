package com.proyecto.ieti.pemc;
import static org.junit.jupiter.api.Assertions.*;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.util.ReflectionTestUtils;

import com.proyecto.ieti.pemc.security.JwtUtil;


public class JwtTest {
    private JwtUtil jwtUtil;

    @Value("${jwt.secret}")
    private String secret = "testSecret";

    @BeforeEach
    public void setUp() {
        jwtUtil = new JwtUtil();
        ReflectionTestUtils.setField(jwtUtil, "secret", secret); 
    }

    @Test
    public void testGenerateToken() {
        String username = "testUser";
        String token = jwtUtil.generateToken(username);
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        assertEquals(username, claims.getSubject());
    }

    @Test
    public void testExtractUsername() {
        String username = "testUser";
        String token = jwtUtil.generateToken(username);
        String extractedUsername = jwtUtil.extractUsername(token);
        assertEquals(username, extractedUsername);
    }

    @Test
    public void testValidateToken() {
        String username = "testUser";
        String token = jwtUtil.generateToken(username);
        assertTrue(jwtUtil.validateToken(token, username));
    }
    
    @Test
    public void testValidateTokenForDifferentUser() {
        String username = "testUser";
        String token = jwtUtil.generateToken(username);

        assertFalse(jwtUtil.validateToken(token, "differentUser")); 
    }

    @Test
    public void testExtractUsernameFromMalformedToken() {
        String malformedToken = "invalidTokenWithoutSignature";

        Exception exception = assertThrows(Exception.class, () -> jwtUtil.extractUsername(malformedToken));
        assertTrue(exception instanceof io.jsonwebtoken.JwtException);
    }

    
}
