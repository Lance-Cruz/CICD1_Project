package ie.atu.project.dataloader;

import ie.atu.project.model.Payment;
import ie.atu.project.repository.PaymentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Dataloader implements CommandLineRunner {
    private final PaymentRepository paymentRepository;

    public Dataloader(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Payment testData1 = new Payment(1L, "50", "Cash", "Euro");

        paymentRepository.save(testData1);
    }
}
