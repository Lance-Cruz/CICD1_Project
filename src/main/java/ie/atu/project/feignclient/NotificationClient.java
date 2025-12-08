package ie.atu.project.feignclient;

import ie.atu.project.dto.NotificationDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "notification-service",
        url = "${notification.service.base-url}"
)
public interface NotificationClient {
    @PostMapping("/api/notification")
    ResponseEntity<NotificationDTO> createNotification(@RequestBody NotificationDTO notificationDTO);

    @GetMapping("/api/notification/{id}")
    ResponseEntity<NotificationDTO> getNotificationID(@PathVariable Long id);
}
