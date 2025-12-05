package ie.atu.project.feignclient;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
        name = "book-service",
        url = "${book.service.base-url}"
)
public interface BookClient {
    //add get request for just one book
}
