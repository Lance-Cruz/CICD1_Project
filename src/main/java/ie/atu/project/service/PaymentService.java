package ie.atu.project.service;

import ie.atu.project.model.Payment;
import ie.atu.project.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    private final PaymentRepository repo;

    public PaymentService (PaymentRepository repo) {
        this.repo = repo;
    }

    public Payment create(Payment p) {
        return repo.save(p);
    }

    public List<Payment> findAll() {
        return repo.findAll();
    }

    public Payment findByPaymentId(Long id) {
        return repo.findByPaymentId(id)
                .orElseThrow(() -> new IllegalArgumentException("Payment ID not found"));
    }
}
