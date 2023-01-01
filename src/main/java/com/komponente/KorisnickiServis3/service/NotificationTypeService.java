package com.komponente.KorisnickiServis3.service;

import com.komponente.KorisnickiServis3.domain.NotificationType;
import com.komponente.KorisnickiServis3.dto.NotificationTypeDto;

public interface NotificationTypeService {

    NotificationTypeDto findByNameOfClassOriginal(String nameOfClass);
}
