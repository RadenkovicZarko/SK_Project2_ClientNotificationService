package com.komponente.KorisnickiServis3.listener;

import com.komponente.KorisnickiServis3.domain.Notification;
import com.komponente.KorisnickiServis3.domain.NotificationType;
import com.komponente.KorisnickiServis3.dto.FirstEmailDto;
import com.komponente.KorisnickiServis3.dto.NotificationTypeDto;
import com.komponente.KorisnickiServis3.dto.UniversalEmailDto;
import com.komponente.KorisnickiServis3.listener.helper.MessageHelper;
import com.komponente.KorisnickiServis3.mapper.NotificationTypeMapper;
import com.komponente.KorisnickiServis3.service.EmailService;
import com.komponente.KorisnickiServis3.service.NotificationService;
import com.komponente.KorisnickiServis3.service.NotificationTypeService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import java.util.Date;

@Component
public class EmailListener {
    private MessageHelper messageHelper;
    private EmailService emailService;
    private NotificationTypeService notificationTypeService;
    private NotificationService notificationService;
    private NotificationTypeMapper notificationTypeMapper;

    //Ovaj listener slusa destination.registrationEmail i salje mejl ukoliko dodje do toga da se pojavi nesto na queue


    public EmailListener(MessageHelper messageHelper, EmailService emailService, NotificationTypeService notificationTypeService, NotificationService notificationService, NotificationTypeMapper notificationTypeMapper) {
        this.messageHelper = messageHelper;
        this.emailService = emailService;
        this.notificationTypeService = notificationTypeService;
        this.notificationService = notificationService;
        this.notificationTypeMapper = notificationTypeMapper;
    }

    @JmsListener(destination = "${destination.emailDestination}", concurrency = "5-10")
    public void addOrder(Message message) throws JMSException {
        UniversalEmailDto universalEmailDto = messageHelper.getMessage(message, UniversalEmailDto.class);
        System.out.println(universalEmailDto.getNameOfClass());
        NotificationTypeDto notificationTypeDto = notificationTypeService.findByNameOfClassOriginal(universalEmailDto.getNameOfClass());
        String emailText = notificationTypeDto.getText();
        Notification notification=new Notification();
        Notification notification1=new Notification();
        notification.setEmail(universalEmailDto.getEmailOfClient());
        //IF-ovi ukoliko je true u NotificationType treba da se doda u tekst
        if(notificationTypeDto.isName()) {
            emailText = emailText.replaceFirst("%name", universalEmailDto.getName());
            //notification.setName(universalEmailDto.getName());
        }
        if(notificationTypeDto.isLastName()) {
            emailText = emailText.replaceFirst("%lastName", universalEmailDto.getLastName());
            //notification.setLastName(universalEmailDto.getLastName());
        }
        if(notificationTypeDto.isLink()){
            emailText=emailText.replaceFirst("%link",universalEmailDto.getLink());
            //notification.setLink(universalEmailDto.getLink());
        }
        if(notificationTypeDto.isIdVehicle()) {
            emailText = emailText.replaceFirst("%idVehicle", String.valueOf(universalEmailDto.getIdVehicle()));
            //notification.setIdVehicle(universalEmailDto.getIdVehicle());
        }
        if(notificationTypeDto.isModel()){
            emailText=emailText.replaceFirst("%model",universalEmailDto.getModel());
            //notification.setModel(universalEmailDto.getModel());
        }
        if(notificationTypeDto.isTypeOfVehicle()) {
            emailText = emailText.replaceFirst("%type", universalEmailDto.getType());
            //notification.setTypeOfVehicle(universalEmailDto.getType());
        }
        if(notificationTypeDto.isDateFrom()) {
            emailText = emailText.replaceFirst("%dateFrom", String.valueOf(universalEmailDto.getFrom()));
            //notification.setDateFrom(universalEmailDto.getFrom());
        }
        if(notificationTypeDto.isDateTo()) {
            emailText = emailText.replaceFirst("%dateTo", String.valueOf(universalEmailDto.getTo()));
            //notification.setDateTo(universalEmailDto.getTo());
        }
        if(notificationTypeDto.isPassword()) {
            emailText = emailText.replaceFirst("%password", String.valueOf(universalEmailDto.getPassword()));
            //notification.setPassword(universalEmailDto.getPassword());
        }

        emailService.sendSimpleMessage(universalEmailDto.getEmailOfClient(), "Notification", emailText);
        notification.setText(emailText);
        notification1.setText(emailText);
        notification.setDateOfSending(new Date());
        notification1.setDateOfSending(new Date());
        notification.setNotificationType(notificationTypeMapper.notificationTypeDtoToNotificationType(notificationTypeDto));
        notification1.setNotificationType(notificationTypeMapper.notificationTypeDtoToNotificationType(notificationTypeDto));
        notificationService.addNotification(notification);
        if(notificationTypeDto.isEmailOfManager()) {
            notification1.setEmail(universalEmailDto.getEmailOfManager());
            System.out.println(universalEmailDto.getEmailOfManager());
            emailService.sendSimpleMessage(universalEmailDto.getEmailOfManager(), "Notification", emailText);
            notificationService.addNotification(notification1);
        }
    }

}
