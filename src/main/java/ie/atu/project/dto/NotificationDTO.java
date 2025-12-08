package ie.atu.project.dto;

public class NotificationDTO {

    private Long id;
    private String toEmail;
    private String subject;
    private String message;

    public NotificationDTO() {
    }

    public NotificationDTO(Long id, String toEmail, String subject, String message) {
        this.id = id;
        this.toEmail = toEmail;
        this.subject = subject;
        this.message = message;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
