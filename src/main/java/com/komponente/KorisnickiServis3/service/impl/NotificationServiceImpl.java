package com.komponente.KorisnickiServis3.service.impl;

import com.komponente.KorisnickiServis3.domain.Notification;
import com.komponente.KorisnickiServis3.repository.NotificationRepository;
import com.komponente.KorisnickiServis3.service.NotificationService;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {
    private  NotificationRepository notificationRepository;

    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public void addNotification(Notification notification) {
        notificationRepository.save(notification);
    }
}
