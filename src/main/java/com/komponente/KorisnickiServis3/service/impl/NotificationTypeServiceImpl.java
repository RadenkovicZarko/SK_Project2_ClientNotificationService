package com.komponente.KorisnickiServis3.service.impl;

import com.komponente.KorisnickiServis3.domain.NotificationType;
import com.komponente.KorisnickiServis3.dto.NotificationTypeDto;
import com.komponente.KorisnickiServis3.exception.NotFoundException;
import com.komponente.KorisnickiServis3.mapper.NotificationTypeMapper;
import com.komponente.KorisnickiServis3.repository.NotificationTypeRepository;
import com.komponente.KorisnickiServis3.service.NotificationTypeService;
import org.springframework.stereotype.Service;

@Service
public class NotificationTypeServiceImpl implements NotificationTypeService {

    private NotificationTypeRepository notificationTypeRepository;
    private NotificationTypeMapper notificationTypeMapper;

    public NotificationTypeServiceImpl(NotificationTypeRepository notificationTypeRepository, NotificationTypeMapper notificationTypeMapper) {
        this.notificationTypeRepository = notificationTypeRepository;
        this.notificationTypeMapper = notificationTypeMapper;
    }

    @Override
    public NotificationTypeDto findByNameOfClassOriginal(String nameOfClass) {
        NotificationType notificationType=notificationTypeRepository.findByNameOfClassOriginal(nameOfClass).orElseThrow(() -> new NotFoundException(String
                .format("Cant find notificationType")));
        return notificationTypeMapper.notificationTypeToNotificationTypeDto(notificationType);
    }
}
