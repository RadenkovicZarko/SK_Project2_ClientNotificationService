package com.komponente.KorisnickiServis3.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private NotificationType notificationType;

    private String emailOfClient;
    private String name;
    private String lastName;
    private String link;
    private Long idVehicle;
    private String model;
    private String typeOfVehicle;
    private Date dateFrom;
    private Date dateTo;
    private String emailOfManager;
    private String password;
    private String text;

    public Notification() {
    }

    public Notification(Long id, NotificationType notificationType, String emailOfClient, String name, String lastName, String link, Long idVehicle, String model, String typeOfVehicle, Date dateFrom, Date dateTo, String emailOfManager, String password, String text) {
        this.id = id;
        this.notificationType = notificationType;
        this.emailOfClient = emailOfClient;
        this.name = name;
        this.lastName = lastName;
        this.link = link;
        this.idVehicle = idVehicle;
        this.model = model;
        this.typeOfVehicle = typeOfVehicle;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.emailOfManager = emailOfManager;
        this.password = password;
        this.text = text;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailOfClient() {
        return emailOfClient;
    }

    public void setEmailOfClient(String emailOfClient) {
        this.emailOfClient = emailOfClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Long getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(Long idVehicle) {
        this.idVehicle = idVehicle;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTypeOfVehicle() {
        return typeOfVehicle;
    }

    public void setTypeOfVehicle(String typeOfVehicle) {
        this.typeOfVehicle = typeOfVehicle;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public String getEmailOfManager() {
        return emailOfManager;
    }

    public void setEmailOfManager(String emailOfManager) {
        this.emailOfManager = emailOfManager;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
