package com.komponente.KorisnickiServis3.listener;

import com.komponente.KorisnickiServis3.domain.NotificationType;
import com.komponente.KorisnickiServis3.dto.FirstEmailDto;
import com.komponente.KorisnickiServis3.dto.NotificationTypeDto;
import com.komponente.KorisnickiServis3.dto.UniversalEmailDto;
import com.komponente.KorisnickiServis3.listener.helper.MessageHelper;
import com.komponente.KorisnickiServis3.service.EmailService;
import com.komponente.KorisnickiServis3.service.NotificationTypeService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;

@Component
public class EmailListener {
    private MessageHelper messageHelper;
    private EmailService emailService;
    private NotificationTypeService notificationTypeService;

    //Ovaj listener slusa destination.registrationEmail i salje mejl ukoliko dodje do toga da se pojavi nesto na queue


    public EmailListener(MessageHelper messageHelper, EmailService emailService, NotificationTypeService notificationTypeService) {
        this.messageHelper = messageHelper;
        this.emailService = emailService;
        this.notificationTypeService = notificationTypeService;
    }

    @JmsListener(destination = "${destination.emailDestination}", concurrency = "5-10")
    public void addOrder(Message message) throws JMSException {
        UniversalEmailDto universalEmailDto = messageHelper.getMessage(message, UniversalEmailDto.class);
        System.out.println(universalEmailDto.getNameOfClass());
        NotificationTypeDto notificationTypeDto = notificationTypeService.findByNameOfClassOriginal(universalEmailDto.getNameOfClass());
        String emailText = notificationTypeDto.getText();

        //IF-ovi ukoliko je true u NotificationType treba da se doda u tekst
        if(notificationTypeDto.isName())
            emailText=emailText.replaceFirst("%name",universalEmailDto.getName());
        if(notificationTypeDto.isLastName())
            emailText=emailText.replaceFirst("%lastName",universalEmailDto.getLastName());
        if(notificationTypeDto.isLink())
            emailText=emailText.replaceFirst("%link",universalEmailDto.getLink());
        if(notificationTypeDto.isIdVehicle())
            emailText=emailText.replaceFirst("%idVehicle",String.valueOf(universalEmailDto.getIdVehicle()));
        if(notificationTypeDto.isModel())
            emailText=emailText.replaceFirst("%model",universalEmailDto.getModel());
        if(notificationTypeDto.isTypeOfVehicle())
            emailText=emailText.replaceFirst("%type",universalEmailDto.getType());
        if(notificationTypeDto.isDateFrom())
            emailText=emailText.replaceFirst("%dateFrom",String.valueOf(universalEmailDto.getFrom()));
        if(notificationTypeDto.isDateTo())
            emailText=emailText.replaceFirst("%dateTo",String.valueOf(universalEmailDto.getTo()));

        System.out.println(emailText+" "+universalEmailDto.getEmailOfClient());
        emailService.sendSimpleMessage(universalEmailDto.getEmailOfClient(), "subject", emailText);
        if(notificationTypeDto.isEmailOfManager())
            emailService.sendSimpleMessage(universalEmailDto.getEmailOfManager(), "subject", emailText);
    }

}
