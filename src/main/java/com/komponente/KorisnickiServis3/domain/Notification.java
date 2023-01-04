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

    private String email;
    //private String name;
    //private String lastName;
    //private String link;
    //private Long idVehicle;
    //private String model;
    //private String typeOfVehicle;
    //private Date dateFrom;
    //private Date dateTo;
    //private String emailOfManager;
    //private String password;
    private String text;
    private Date dateOfSending;

    public Notification() {
    }

    public Date getDateOfSending() {
        return dateOfSending;
    }

    public void setDateOfSending(Date dateOfSending) {
        this.dateOfSending = dateOfSending;
    }

    public Notification(Long id, NotificationType notificationType, String email, String text) {
        this.id = id;
        this.notificationType = notificationType;
        this.email = email;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
