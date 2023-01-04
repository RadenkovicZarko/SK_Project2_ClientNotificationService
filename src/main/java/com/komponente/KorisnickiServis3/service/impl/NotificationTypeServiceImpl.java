package com.komponente.KorisnickiServis3.service.impl;

import com.komponente.KorisnickiServis3.domain.NotificationType;
import com.komponente.KorisnickiServis3.dto.NotificationTypeChangeDto;
import com.komponente.KorisnickiServis3.dto.NotificationTypeCreateDto;
import com.komponente.KorisnickiServis3.dto.NotificationTypeDeleteDto;
import com.komponente.KorisnickiServis3.dto.NotificationTypeDto;
import com.komponente.KorisnickiServis3.exception.NotFoundException;
import com.komponente.KorisnickiServis3.mapper.NotificationTypeMapper;
import com.komponente.KorisnickiServis3.repository.NotificationTypeRepository;
import com.komponente.KorisnickiServis3.service.NotificationTypeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public NotificationTypeDto createNotificationTypeDto(NotificationTypeCreateDto notificationTypeCreateDto) {
        NotificationType notificationType=notificationTypeMapper.notificationTypeCreateDtoToNotificationType(notificationTypeCreateDto);
        notificationTypeRepository.save(notificationType);
        return notificationTypeMapper.notificationTypeToNotificationTypeDto(notificationType);
    }

    @Override
    public List<NotificationTypeDto> findAll()
    {
        List<NotificationTypeDto> notificationTypeDtos=new ArrayList<>();
        for(NotificationType nt:notificationTypeRepository.findAll())
            notificationTypeDtos.add(notificationTypeMapper.notificationTypeToNotificationTypeDto(nt));
        return notificationTypeDtos;
    }

    @Override
    public NotificationTypeDto update(NotificationTypeChangeDto notificationTypeChangeDto)
    {
        NotificationType notificationType=notificationTypeRepository.findById(notificationTypeChangeDto.getId()).orElseThrow(() -> new NotFoundException(String
                .format("Cant find notificationType")));
        notificationType.setName(notificationTypeChangeDto.isName());
        notificationType.setLastName(notificationTypeChangeDto.isLastName());
        notificationType.setLink(notificationTypeChangeDto.isLink());
        notificationType.setIdVehicle(notificationTypeChangeDto.isIdVehicle());
        notificationType.setModel(notificationTypeChangeDto.isModel());
        notificationType.setTypeOfVehicle(notificationTypeChangeDto.isTypeOfVehicle());
        notificationType.setDateFrom(notificationTypeChangeDto.isDateFrom());
        notificationType.setDateTo(notificationTypeChangeDto.isDateTo());
        notificationType.setEmailOfManager(notificationTypeChangeDto.isEmailOfManager());
        notificationType.setPassword(notificationTypeChangeDto.isPassword());
        notificationType.setText(notificationTypeChangeDto.getText());
        notificationTypeRepository.save(notificationType);
        return notificationTypeMapper.notificationTypeToNotificationTypeDto(notificationType);
    }

    @Override
    public  NotificationTypeDto delete(NotificationTypeDeleteDto notificationTypeDeleteDto) {
        NotificationType notificationType=notificationTypeRepository.findById(notificationTypeDeleteDto.getId()).orElseThrow(() -> new NotFoundException(String
                .format("Cant find notificationType")));
        NotificationTypeDto notificationTypeDto=notificationTypeMapper.notificationTypeToNotificationTypeDto(notificationType);
        notificationTypeRepository.delete(notificationType);
        return notificationTypeDto;
    }
}
