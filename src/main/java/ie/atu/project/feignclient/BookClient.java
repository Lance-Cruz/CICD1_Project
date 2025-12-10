package ie.atu.project.feignclient;

import ie.atu.project.dto.BookDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "book-service",
        url = "${book.service.base-url}"
)
public interface BookClient {
    @GetMapping("/api/book/{id}")
    BookDTO getBookID(@PathVariable Long id);
}
