package ie.atu.project.feignclient;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
        name = "notification-service",
        url = "${notification.service.base-url}"
)
public interface NotificationClient {
    //Add post request
}
