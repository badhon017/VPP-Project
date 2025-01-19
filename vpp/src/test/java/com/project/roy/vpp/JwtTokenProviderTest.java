package com.project.roy.vpp;

import com.project.roy.vpp.config.JwtTokenProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.User;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class JwtTokenProviderTest {

    @InjectMocks
    private JwtTokenProvider jwtTokenProvider;

    @Test
    void testGenerateAndValidateToken() {
        String token = jwtTokenProvider.generateTokenFromUsername(User.withUsername("testUser").build());

        assertNotNull(token);
        assertTrue(jwtTokenProvider.validateJwtToken(token));

        String username = jwtTokenProvider.getUserNameFromJwtToken(token);
        assertEquals("testUser", username);
    }

    @Test
    void testInvalidToken() {
        String invalidToken = "invalid.token.here";

        assertFalse(jwtTokenProvider.validateJwtToken(invalidToken));
    }
}