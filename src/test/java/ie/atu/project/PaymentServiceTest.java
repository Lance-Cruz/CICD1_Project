package ie.atu.project;

import ie.atu.project.model.Payment;
import ie.atu.project.repository.PaymentRepository;
import ie.atu.project.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceTest {

    @Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private PaymentService paymentService;

    @Test
    void createPayment() {
        Payment payment = new Payment(null, 1L, "10", "Cash", "Euro");
        Payment savedPayment = new Payment(1L, 1L, "10", "Cash", "Euro");

        when(paymentRepository.save(payment)).thenReturn(savedPayment);

        Payment result = paymentService.create(payment);

        assertNotNull(result.getPaymentId());
        assertEquals("10", result.getAmount());

        verify(paymentRepository, times(1)).save(payment);
    }

    @Test
    void getPayment() {
        Payment savedPayment = new Payment(1L, 1L, "10", "Cash", "Euro");

        when(paymentRepository.findByPaymentId(1L)).thenReturn(Optional.of(savedPayment));

        Optional<Payment> result = paymentService.findByPaymentId(1L);

        assertTrue(result.isPresent());
        assertEquals("10", result.get().getAmount());

        verify(paymentRepository, times(1)).findByPaymentId(1L);
    }

    @Test
    void updatePayment() {

    }

    @Test
    void deletePayment() {

    }
}
