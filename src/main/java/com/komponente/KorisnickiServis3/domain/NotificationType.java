package com.komponente.KorisnickiServis3.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NotificationType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String nameOfClass;
    private boolean name;
    private boolean lastName;
    private boolean link;
    private boolean idVehicle;
    private boolean model;
    private boolean typeOfVehicle;
    private boolean dateFrom;
    private boolean dateTo;
    private boolean emailOfManager;
    private String text;
    private boolean password;

    public NotificationType() {
    }

    public NotificationType(Long id, String nameOfClass, boolean name, boolean lastName, boolean link, boolean idVehicle, boolean model, boolean typeOfVehicle, boolean dateFrom, boolean dateTo, boolean emailOfManager, String text, boolean password) {
        this.id = id;
        this.nameOfClass = nameOfClass;
        this.name = name;
        this.lastName = lastName;
        this.link = link;
        this.idVehicle = idVehicle;
        this.model = model;
        this.typeOfVehicle = typeOfVehicle;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.emailOfManager = emailOfManager;
        this.text = text;
        this.password = password;
    }

    public boolean isPassword() {
        return password;
    }

    public void setPassword(boolean password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameOfClass() {
        return nameOfClass;
    }

    public void setNameOfClass(String nameOfClass) {
        this.nameOfClass = nameOfClass;
    }

    public boolean isName() {
        return name;
    }

    public void setName(boolean name) {
        this.name = name;
    }

    public boolean isLastName() {
        return lastName;
    }

    public void setLastName(boolean lastName) {
        this.lastName = lastName;
    }

    public boolean isLink() {
        return link;
    }

    public void setLink(boolean link) {
        this.link = link;
    }

    public boolean isIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(boolean idVehicle) {
        this.idVehicle = idVehicle;
    }

    public boolean isModel() {
        return model;
    }

    public void setModel(boolean model) {
        this.model = model;
    }

    public boolean isTypeOfVehicle() {
        return typeOfVehicle;
    }

    public void setTypeOfVehicle(boolean typeOfVehicle) {
        this.typeOfVehicle = typeOfVehicle;
    }

    public boolean isDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(boolean dateFrom) {
        this.dateFrom = dateFrom;
    }

    public boolean isDateTo() {
        return dateTo;
    }

    public void setDateTo(boolean dateTo) {
        this.dateTo = dateTo;
    }

    public boolean isEmailOfManager() {
        return emailOfManager;
    }

    public void setEmailOfManager(boolean emailOfManager) {
        this.emailOfManager = emailOfManager;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
