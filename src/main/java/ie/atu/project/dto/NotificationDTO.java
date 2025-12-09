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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
