package com.komponente.KorisnickiServis3.repository;

import com.komponente.KorisnickiServis3.domain.NotificationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface NotificationTypeRepository extends JpaRepository<NotificationType,Long> {


    @Query(value="select * FROM notification_type nt WHERE nt.name_of_class = ?1",nativeQuery = true)
    Optional<NotificationType> findByNameOfClassOriginal(String nameOfClass);


}
