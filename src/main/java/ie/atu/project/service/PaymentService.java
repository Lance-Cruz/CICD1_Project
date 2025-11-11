package ie.atu.project.service;

import ie.atu.project.model.Payment;
import ie.atu.project.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Payment> update(Long id, Payment p) {
        Optional<Payment> maybe = repo.findByPaymentId(id);
        if (maybe.isPresent()) {
            Payment existing = maybe.get();
            existing.setPaymentId(p.getPaymentId());
            existing.setUserID(p.getUserID());
            existing.setAmount(p.getAmount());
            existing.setPaymentMethod(p.getPaymentMethod());
            existing.setCurrency(p.getCurrency());
            repo.save(existing);
            return Optional.of(existing);
        } else {
            return Optional.empty();
        }
    }

    public Payment delete(Long id) {
        Payment payment = repo.findByPaymentId(id)
                .orElseThrow(() -> new IllegalArgumentException("Payment ID not found"));
        repo.delete(payment);
        return payment;
    }
}
