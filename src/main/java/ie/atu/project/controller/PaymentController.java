package ie.atu.project.controller;

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

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Payment create(@Valid @RequestBody Payment payment){
        return service.create(payment);
    }

    @GetMapping
    public List<Payment> all() {
        return service.findAll();
    }

    @GetMapping("/{paymentId}")
    public Payment byPaymentId(@PathVariable Long paymentId) {
        return service.findByPaymentId(paymentId);
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
}
