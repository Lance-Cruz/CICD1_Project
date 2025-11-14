package ie.atu.project.errorhandling;

public class PaymentNotFound extends RuntimeException {

    private String message;
    private String field;

    public PaymentNotFound(String field, String message) {
        this.field = field;
    }

    public PaymentNotFound(String message) {
        super(message);
    }
}
