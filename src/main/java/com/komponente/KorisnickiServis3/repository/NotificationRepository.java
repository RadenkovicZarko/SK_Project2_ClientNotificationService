package com.komponente.KorisnickiServis3.repository;

import com.komponente.KorisnickiServis3.domain.Notification;
import com.komponente.KorisnickiServis3.domain.NotificationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification,Long> {
}
