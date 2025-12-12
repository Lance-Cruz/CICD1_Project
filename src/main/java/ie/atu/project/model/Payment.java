package ie.atu.project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "payment")
@Builder
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;
    @NotNull(message = "bookID is required")
    private Long bookID;
    @NotBlank(message = "Amount is required")
    private String amount;
    @NotBlank(message = "Payment method is required")
    private String paymentMethod;
    @NotBlank(message = "Currency is required")
    private String currency;

    public Payment() {
    }

    public Payment(Long bookID, String amount, String paymentMethod, String currency) {
        this.bookID = bookID;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.currency = currency;
    }

    public Payment(Long paymentId, Long bookID, String amount, String paymentMethod, String currency) {
        this.paymentId = paymentId;
        this.bookID = bookID;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.currency = currency;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Long getBookID() {
        return bookID;
    }

    public void setBookID(Long bookID) {
        this.bookID = bookID;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
