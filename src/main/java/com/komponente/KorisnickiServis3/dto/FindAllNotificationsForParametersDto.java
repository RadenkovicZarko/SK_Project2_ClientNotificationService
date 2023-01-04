package com.komponente.KorisnickiServis3.dto;

import java.util.Date;

public class FindAllNotificationsForParametersDto {
    private String email;
    private String  role;
    private String emailParameter;
    private String notificationTypeName;
    private Date fromDate;
    private Date toDate;

    @Override
    public String toString() {
        return "FindAllNotificationsForParametersDto{" +
                "email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", emailParameter='" + emailParameter + '\'' +
                ", notificationTypeName='" + notificationTypeName + '\'' +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                '}';
    }

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

    public String getEmailParameter() {
        return emailParameter;
    }

    public void setEmailParameter(String emailParameter) {
        this.emailParameter = emailParameter;
    }

    public String getNotificationTypeName() {
        return notificationTypeName;
    }

    public void setNotificationTypeName(String notificationTypeName) {
        this.notificationTypeName = notificationTypeName;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
}
