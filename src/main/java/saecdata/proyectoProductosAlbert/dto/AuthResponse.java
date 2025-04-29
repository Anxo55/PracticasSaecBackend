package saecdata.proyectoProductosAlbert.dto;

import java.util.List;

public class AuthResponse {

    private String jwt;
    private String username;
    private List<String> roles;

    public AuthResponse(String jwt, String username, List<String> roles) {
        this.jwt = jwt;
        this.username = username;
        this.roles = roles;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
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
