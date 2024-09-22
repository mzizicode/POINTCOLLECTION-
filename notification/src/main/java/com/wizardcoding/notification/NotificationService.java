package com.wizardcoding.notification;



import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;


    public void     send(NotificationRequest notificationRequest) {
        Notification wizardCode = notificationRepository.save(
                Notification.builder()
                        .toCustomerId(notificationRequest.toCustomerId())
                        .toCustomerEmail(notificationRequest.toCustomerEmail())
                        .sender("wizardcode")
                        .message(notificationRequest.message())
                        .sentAt(LocalDateTime.now())
                        .build()




        );

    }
}
