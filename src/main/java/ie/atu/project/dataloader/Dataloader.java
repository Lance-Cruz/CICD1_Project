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
        Payment testData1 = new Payment(1L, "5", "Cash", "Euro");
        Payment testData2 = new Payment(2L, "21", "Debit", "Pound");
        Payment testData3 = new Payment(3L, "10", "Card", "Dollar");
        Payment testData4 = new Payment(4L, "18", "Cash", "Euro");

        paymentRepository.save(testData1);
        paymentRepository.save(testData2);
        paymentRepository.save(testData3);
        paymentRepository.save(testData4);
    }
}
