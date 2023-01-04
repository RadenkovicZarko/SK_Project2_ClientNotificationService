package com.komponente.KorisnickiServis3.service;

import com.komponente.KorisnickiServis3.domain.Notification;
import com.komponente.KorisnickiServis3.dto.FindAllNotificationsDto;
import com.komponente.KorisnickiServis3.dto.FindAllNotificationsForParametersDto;
import com.komponente.KorisnickiServis3.dto.NotificationDto;

import java.util.List;

public interface NotificationService {

    void addNotification(Notification notification);

    List<NotificationDto> findAll(FindAllNotificationsDto findAllNotificationsDto);

    List<NotificationDto> findAllForParameter(FindAllNotificationsForParametersDto findAllNotificationsForParametersDto);
}
