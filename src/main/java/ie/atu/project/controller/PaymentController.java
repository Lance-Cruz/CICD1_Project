package ie.atu.project.controller;

import ie.atu.project.dto.NotificationDTO;
import ie.atu.project.feignclient.NotificationClient;
import ie.atu.project.model.Payment;
import ie.atu.project.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final PaymentService service;
    private final NotificationClient notificationClient;

    public PaymentController(PaymentService service, NotificationClient notificationClient) {
        this.service = service;
        this.notificationClient = notificationClient;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Payment create(@Valid @RequestBody Payment payment){
        return service.create(payment);
    }

    @GetMapping
    public ResponseEntity<List<Payment>> all() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<Payment> byPaymentId(@PathVariable Long paymentId) {
        Optional<Payment> maybe = service.findByPaymentId(paymentId);
        if (maybe.isPresent()) {
            return ResponseEntity.ok(maybe.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{paymentId}")
    public ResponseEntity<Payment> update(@PathVariable Long paymentId, @Valid @RequestBody Payment payment) {
        Optional<Payment> maybeUpdated = service.update(paymentId,payment);
        if (maybeUpdated.isPresent()) {
            return ResponseEntity.ok(maybeUpdated.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{paymentId}")
    public ResponseEntity<Payment> delete(@PathVariable Long paymentId) {
        Optional<Payment> maybeDelete = service.delete(paymentId);
        if (maybeDelete.isPresent()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/createNotification")
    public ResponseEntity<NotificationDTO> createNotification(@RequestBody NotificationDTO notificationDTO) {
        return notificationClient.createNotification(notificationDTO);
    }

    @GetMapping("/getNotification/{id}")
    public ResponseEntity<NotificationDTO> getNotificationID(@PathVariable Long id) {
        return notificationClient.getNotificationID(id);
    }
}
