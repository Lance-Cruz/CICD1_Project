package ie.atu.project.service;

import ie.atu.project.errorhandling.PaymentNotFound;
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

    public Optional<Payment> findByPaymentId(Long id) {
        Optional<Payment> maybe = repo.findByPaymentId(id);
        if (maybe.isPresent()) {
            return maybe;
        } else {
            throw new PaymentNotFound("The paymentID of " + id + " can not be found");
        }
    }

    public Optional<Payment> update(Long id, Payment p) {
        Optional<Payment> maybe = repo.findByPaymentId(id);
        if (maybe.isPresent()) {
            Payment existing = maybe.get();
            existing.setPaymentId(p.getPaymentId());
            existing.setBookID(p.getBookID());
            existing.setAmount(p.getAmount());
            existing.setPaymentMethod(p.getPaymentMethod());
            existing.setCurrency(p.getCurrency());
            repo.save(existing);
            return Optional.of(existing);
        } else {
            throw new PaymentNotFound("The paymentID of " + id + " can not be found");
        }
    }

    public Optional<Payment> delete(Long id) {
        Optional<Payment> maybe = repo.findByPaymentId(id);
        if (maybe.isPresent()) {
            repo.delete(maybe.get());
            return maybe;
        } else {
            throw new PaymentNotFound("The paymentID of " + id + " can not be found");
        }
    }
}
