package com.komponente.KorisnickiServis3.controller;

import com.komponente.KorisnickiServis3.dto.*;
import com.komponente.KorisnickiServis3.repository.NotificationRepository;
import com.komponente.KorisnickiServis3.service.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    private NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/findAll")
    public ResponseEntity<List<NotificationDto>> findAll(@RequestBody()FindAllNotificationsDto findAllNotificationsDto) {
        return new ResponseEntity<>(notificationService.findAll(findAllNotificationsDto), HttpStatus.OK);
    }

    @PostMapping("/findAllForParameters")
    public ResponseEntity<List<NotificationDto>> findAllForParameters(@RequestBody()FindAllNotificationsForParametersDto findAllNotificationsForParametersDto) {
        return new ResponseEntity<>(notificationService.findAllForParameter(findAllNotificationsForParametersDto), HttpStatus.OK);
    }
}
