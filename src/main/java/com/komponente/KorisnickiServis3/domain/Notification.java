package com.komponente.KorisnickiServis3.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String emailOfClient;
    private String nameOfClass;
    private String name;
    private String lastName;
    private String link;
    private Long idVehicle;
    private String model;
    private String typeOfVehicle;
    private Date dateFrom;
    private Date dateTo;
    private String emailOfManager;
    private String text;

    public Notification() {
    }

    public Notification(String emailOfClient, String nameOfClass, String name, String lastName, String link, Long idVehicle, String model, String typeOfVehicle, Date from, Date to, String emailOfManager, String text) {
        this.emailOfClient = emailOfClient;
        this.nameOfClass = nameOfClass;
        this.name = name;
        this.lastName = lastName;
        this.link = link;
        this.idVehicle = idVehicle;
        this.model = model;
        this.typeOfVehicle = typeOfVehicle;
        this.dateFrom = from;
        this.dateTo = to;
        this.emailOfManager = emailOfManager;
        this.text = text;
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

    public String getNameOfClass() {
        return nameOfClass;
    }

    public void setNameOfClass(String nameOfClass) {
        this.nameOfClass = nameOfClass;
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
