package com.komponente.KorisnickiServis3.mapper;


import com.komponente.KorisnickiServis3.domain.NotificationType;
import com.komponente.KorisnickiServis3.dto.NotificationTypeDto;
import com.komponente.KorisnickiServis3.service.NotificationTypeService;
import org.springframework.stereotype.Component;

@Component
public class NotificationTypeMapper {

    public NotificationTypeDto notificationTypeToNotificationTypeDto(NotificationType notificationType)
    {
        NotificationTypeDto notificationTypeDto=new NotificationTypeDto();

        notificationTypeDto.setNameOfClass(notificationType.getNameOfClass());
        notificationTypeDto.setName(notificationType.isName());
        notificationTypeDto.setLastName(notificationType.isLastName());
        notificationTypeDto.setLink(notificationType.isLink());
        notificationTypeDto.setIdVehicle(notificationType.isIdVehicle());
        notificationTypeDto.setModel(notificationType.isModel());
        notificationTypeDto.setTypeOfVehicle(notificationType.isTypeOfVehicle());
        notificationTypeDto.setDateFrom(notificationType.isDateFrom());
        notificationTypeDto.setDateTo(notificationType.isDateTo());
        notificationTypeDto.setEmailOfManager(notificationType.isEmailOfManager());
        notificationTypeDto.setText(notificationType.getText());
        return notificationTypeDto;
    }

}
