package com.komponente.KorisnickiServis3.service;

import com.komponente.KorisnickiServis3.domain.NotificationType;
import com.komponente.KorisnickiServis3.dto.NotificationTypeChangeDto;
import com.komponente.KorisnickiServis3.dto.NotificationTypeCreateDto;
import com.komponente.KorisnickiServis3.dto.NotificationTypeDeleteDto;
import com.komponente.KorisnickiServis3.dto.NotificationTypeDto;

import java.util.List;

public interface NotificationTypeService {

    NotificationTypeDto findByNameOfClassOriginal(String nameOfClass);

    NotificationTypeDto createNotificationTypeDto(NotificationTypeCreateDto notificationTypeCreateDto);

    List<NotificationTypeDto> findAll();

    NotificationTypeDto update(NotificationTypeChangeDto notificationTypeChangeDto);

    NotificationTypeDto delete(NotificationTypeDeleteDto notificationTypeDeleteDto);

}
