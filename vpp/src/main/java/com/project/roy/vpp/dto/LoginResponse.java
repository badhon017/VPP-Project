package com.project.roy.vpp.dto;

import java.util.List;

public class LoginResponse {
    private String jwtToken;
    private String username;
    private List<String> roles;

    public LoginResponse(String jwtToken, String username, List<String> roles) {
        this.jwtToken = jwtToken;
        this.username = username;
        this.roles = roles;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
    public String getJwtToken() {
        return jwtToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
