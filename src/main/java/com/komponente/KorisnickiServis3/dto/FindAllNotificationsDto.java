package com.komponente.KorisnickiServis3.dto;

public class FindAllNotificationsDto {
    private String email;
    private String  role;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
