package com.komponente.KorisnickiServis3.mapper;


import com.komponente.KorisnickiServis3.domain.NotificationType;
import com.komponente.KorisnickiServis3.dto.NotificationTypeCreateDto;
import com.komponente.KorisnickiServis3.dto.NotificationTypeDto;
import com.komponente.KorisnickiServis3.repository.NotificationRepository;
import com.komponente.KorisnickiServis3.service.NotificationTypeService;
import org.springframework.stereotype.Component;

@Component
public class NotificationTypeMapper {

    public NotificationTypeDto notificationTypeToNotificationTypeDto(NotificationType notificationType)
    {
        NotificationTypeDto notificationTypeDto=new NotificationTypeDto();
        notificationTypeDto.setId(notificationType.getId());
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
        notificationTypeDto.setPassword(notificationType.isPassword());
        return notificationTypeDto;
    }
    public NotificationType notificationTypeDtoToNotificationType(NotificationTypeDto notificationTypeDto)
    {
        NotificationType notificationType=new NotificationType();
        notificationType.setId(notificationTypeDto.getId());
        notificationType.setNameOfClass(notificationTypeDto.getNameOfClass());
        notificationType.setName(notificationTypeDto.isName());
        notificationType.setLastName(notificationTypeDto.isLastName());
        notificationType.setLink(notificationTypeDto.isLink());
        notificationType.setIdVehicle(notificationTypeDto.isIdVehicle());
        notificationType.setModel(notificationTypeDto.isModel());
        notificationType.setTypeOfVehicle(notificationTypeDto.isTypeOfVehicle());
        notificationType.setDateFrom(notificationTypeDto.isDateFrom());
        notificationType.setDateTo(notificationTypeDto.isDateTo());
        notificationType.setEmailOfManager(notificationTypeDto.isEmailOfManager());
        notificationType.setText(notificationTypeDto.getText());
        notificationType.setPassword(notificationTypeDto.isPassword());
        return notificationType;
    }
    public NotificationType notificationTypeCreateDtoToNotificationType(NotificationTypeCreateDto notificationTypeCreateDto)
    {
        NotificationType notificationType=new NotificationType();
        notificationType.setNameOfClass(notificationTypeCreateDto.getNameOfClass());
        notificationType.setName(notificationTypeCreateDto.isName());
        notificationType.setLastName(notificationTypeCreateDto.isLastName());
        notificationType.setLink(notificationTypeCreateDto.isLink());
        notificationType.setIdVehicle(notificationTypeCreateDto.isIdVehicle());
        notificationType.setModel(notificationTypeCreateDto.isModel());
        notificationType.setTypeOfVehicle(notificationTypeCreateDto.isTypeOfVehicle());
        notificationType.setDateFrom(notificationTypeCreateDto.isDateFrom());
        notificationType.setDateTo(notificationTypeCreateDto.isDateTo());
        notificationType.setEmailOfManager(notificationTypeCreateDto.isEmailOfManager());
        notificationType.setText(notificationTypeCreateDto.getText());
        notificationType.setPassword(notificationTypeCreateDto.isPassword());
        return notificationType;
    }



}
