package com.komponente.KorisnickiServis3.service.impl;

import com.komponente.KorisnickiServis3.domain.Notification;
import com.komponente.KorisnickiServis3.dto.FindAllNotificationsDto;
import com.komponente.KorisnickiServis3.dto.FindAllNotificationsForParametersDto;
import com.komponente.KorisnickiServis3.dto.NotificationDto;
import com.komponente.KorisnickiServis3.mapper.NotificationMapper;
import com.komponente.KorisnickiServis3.repository.NotificationRepository;
import com.komponente.KorisnickiServis3.service.NotificationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {
    private  NotificationRepository notificationRepository;
    private NotificationMapper notificationMapper;

    public NotificationServiceImpl(NotificationRepository notificationRepository, NotificationMapper notificationMapper) {
        this.notificationRepository = notificationRepository;
        this.notificationMapper = notificationMapper;
    }

    @Override
    public void addNotification(Notification notification) {
        notificationRepository.save(notification);
    }

    @Override
    public List<NotificationDto> findAll(FindAllNotificationsDto findAllNotificationsDto) {
        List<Notification> notifications=notificationRepository.findAll();

        List<NotificationDto> list=new ArrayList<>();
        if(findAllNotificationsDto.getRole().equalsIgnoreCase("ROLE_ADMIN"))
        {
            for(Notification n:notifications)
                list.add(notificationMapper.notificationToNotificationDto(n));
        }
        else
        {
            for(Notification n:notifications)
                if(n.getEmail().equalsIgnoreCase(findAllNotificationsDto.getEmail()))
                    list.add(notificationMapper.notificationToNotificationDto(n));
        }
        return list;
    }

    @Override
    public List<NotificationDto> findAllForParameter(FindAllNotificationsForParametersDto findAllNotificationsForParametersDto) {
        List<Notification> notifications=notificationRepository.findAll();
        System.out.println(findAllNotificationsForParametersDto.toString());
        List<NotificationDto> list=new ArrayList<>();
        if(findAllNotificationsForParametersDto.getRole().equalsIgnoreCase("ROLE_ADMIN"))
        {
            for(Notification n:notifications) {
                if(!findAllNotificationsForParametersDto.getEmailParameter().isEmpty() && !findAllNotificationsForParametersDto.getEmailParameter().equalsIgnoreCase(n.getEmail()))
                    continue;
                if(!findAllNotificationsForParametersDto.getNotificationTypeName().isEmpty() && !findAllNotificationsForParametersDto.getNotificationTypeName().equalsIgnoreCase(n.getNotificationType().getNameOfClass()))
                    continue;
                if(findAllNotificationsForParametersDto.getFromDate()!=null && findAllNotificationsForParametersDto.getFromDate().getTime()>n.getDateOfSending().getTime())
                    continue;
                if(findAllNotificationsForParametersDto.getToDate()!=null && findAllNotificationsForParametersDto.getToDate().getTime()<n.getDateOfSending().getTime())
                    continue;

                list.add(notificationMapper.notificationToNotificationDto(n));

            }
        }
        else
        {
            for(Notification n:notifications) {
                if (!n.getEmail().equalsIgnoreCase(findAllNotificationsForParametersDto.getEmail()))
                    continue;
                if(!findAllNotificationsForParametersDto.getEmailParameter().isEmpty() && !findAllNotificationsForParametersDto.getEmailParameter().equalsIgnoreCase(n.getEmail()))
                    continue;
                if(!findAllNotificationsForParametersDto.getNotificationTypeName().isEmpty() && !findAllNotificationsForParametersDto.getNotificationTypeName().equalsIgnoreCase(n.getNotificationType().getNameOfClass()))
                    continue;
                if(findAllNotificationsForParametersDto.getFromDate()!=null && findAllNotificationsForParametersDto.getFromDate().getTime()>n.getDateOfSending().getTime())
                    continue;
                if(findAllNotificationsForParametersDto.getToDate()!=null && findAllNotificationsForParametersDto.getToDate().getTime()<n.getDateOfSending().getTime())
                    continue;

                list.add(notificationMapper.notificationToNotificationDto(n));
            }
        }
        return list;
    }


}
