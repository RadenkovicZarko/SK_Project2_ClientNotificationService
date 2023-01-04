package com.komponente.KorisnickiServis3.controller;

import com.komponente.KorisnickiServis3.dto.NotificationTypeChangeDto;
import com.komponente.KorisnickiServis3.dto.NotificationTypeCreateDto;
import com.komponente.KorisnickiServis3.dto.NotificationTypeDeleteDto;
import com.komponente.KorisnickiServis3.dto.NotificationTypeDto;
import com.komponente.KorisnickiServis3.mapper.NotificationTypeMapper;
import com.komponente.KorisnickiServis3.service.NotificationTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notificationType")
public class NotificationTypeController {

    private NotificationTypeService notificationTypeService;
    private NotificationTypeMapper notificationTypeMapper;

    public NotificationTypeController(NotificationTypeService notificationTypeService, NotificationTypeMapper notificationTypeMapper) {
        this.notificationTypeService = notificationTypeService;
        this.notificationTypeMapper = notificationTypeMapper;
    }

    @PostMapping("/add")
    public ResponseEntity<NotificationTypeDto> addNotificationType(@RequestBody() NotificationTypeCreateDto notificationTypeCreateDto) {
        return new ResponseEntity<>(notificationTypeService.createNotificationTypeDto(notificationTypeCreateDto), HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<NotificationTypeDto>> findAllNotificationType() {
        return new ResponseEntity<>(notificationTypeService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity< NotificationTypeDto> update(@RequestBody() NotificationTypeChangeDto notificationTypeChangeDto) {
        return new ResponseEntity<>(notificationTypeService.update(notificationTypeChangeDto), HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<NotificationTypeDto> delete(@RequestBody() NotificationTypeDeleteDto notificationTypeDeleteDto) {
        return new ResponseEntity<>(notificationTypeService.delete(notificationTypeDeleteDto), HttpStatus.OK);
    }

}
