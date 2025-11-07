package ie.atu.project.controller;

import ie.atu.project.model.Payment;
import ie.atu.project.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Payment update(@PathVariable Long paymentId, @Valid @RequestBody Payment payment) {
        return service.update(paymentId, payment);
    }

    @DeleteMapping("/{paymentId}")
    public Payment delete(@PathVariable Long paymentId) {
        return service.delete(paymentId);
    }
}
