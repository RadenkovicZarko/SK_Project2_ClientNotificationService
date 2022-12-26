package com.komponente.KorisnickiServis3.listener;

import com.komponente.KorisnickiServis3.listener.helper.MessageHelper;
import com.komponente.KorisnickiServis3.service.EmailService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;

@Component
public class EmailListener {
    private MessageHelper messageHelper;
    private EmailService emailService;
    //Ovaj listener slusa destination.registrationEmail i salje mejl ukoliko dodje do toga da se pojavi nesto na queue
    public EmailListener(MessageHelper messageHelper, EmailService emailService) {
        this.messageHelper = messageHelper;
        this.emailService = emailService;
    }

    @JmsListener(destination = "${destination.registrationEmail}", concurrency = "5-10")
    public void addOrder(Message message) throws JMSException {
        //MatchesDto matchesDto = messageHelper.getMessage(message, MatchesDto.class);
        //emailService.sendSimpleMessage("mradovic01011111@gmail.com", "subject", matchesDto.toString());
    }

}
