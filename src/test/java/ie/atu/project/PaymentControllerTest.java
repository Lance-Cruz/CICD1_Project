package ie.atu.project;

import ie.atu.project.controller.PaymentController;
import ie.atu.project.feignclient.BookClient;
import ie.atu.project.feignclient.NotificationClient;
import ie.atu.project.model.Payment;
import ie.atu.project.service.PaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// For building the HTTP requests
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
// For checking the results of the requests
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
// For converting objects to JSON and vice versa
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.awt.print.Book;
import java.util.Optional;

@WebMvcTest(PaymentController.class)
public class  PaymentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PaymentService paymentService;

    @MockitoBean
    private NotificationClient notificationClient;

    @MockitoBean
    private BookClient bookClient;

    @BeforeEach
    void setUp() {

    }

    @Test
    void getAllPayments() {

    }

    @Test
    void getPaymentById() throws Exception {
        Payment p = new Payment(1L, 1L, "10","Cash", "Euro");
        when(paymentService.findByPaymentId(1L)).thenReturn(Optional.of(p));

        mockMvc.perform(get("/api/payment/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.amount").value("10"));
    }

    @Test
    void createPayment() throws Exception {
        Payment p = new Payment(1L, 1L, "10","Cash", "Euro");
        when(paymentService.create(any(Payment.class))).thenReturn(p);

        ObjectMapper mapper = new ObjectMapper();
        String JsonValue = mapper.writeValueAsString(p);
        mockMvc.perform(post("/api/payment").contentType(MediaType.APPLICATION_JSON).content(JsonValue))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.amount").value("10"));

    }

    @Test
    void updatePayment() {

    }

    @Test
    void deletePayment() {

    }
}
