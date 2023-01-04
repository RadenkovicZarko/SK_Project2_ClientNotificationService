package com.komponente.KorisnickiServis3.mapper;

import com.komponente.KorisnickiServis3.domain.Notification;
import com.komponente.KorisnickiServis3.dto.NotificationDto;
import org.springframework.stereotype.Component;

@Component
public class NotificationMapper {

    public NotificationDto notificationToNotificationDto(Notification notification)
    {
        NotificationDto notificationDto=new NotificationDto();
        notificationDto.setId(notification.getId());
        notificationDto.setIdNotificationType(notification.getNotificationType().getId());
        notificationDto.setEmail(notification.getEmail());
        notificationDto.setText(notification.getText());
        notificationDto.setDateOfSending(notification.getDateOfSending());
        return notificationDto;
    }

}
