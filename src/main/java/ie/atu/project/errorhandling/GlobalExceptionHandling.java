package ie.atu.project.errorhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandling {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ExceptionDetails>> showErrorDetails(MethodArgumentNotValidException mae)
    {
        List<ExceptionDetails> errorList = new ArrayList<>();
        for (FieldError fieldError : mae.getBindingResult().getFieldErrors())
        {
            ExceptionDetails exceptionDetails = new ExceptionDetails();
            exceptionDetails.setFieldName(fieldError.getDefaultMessage());
            exceptionDetails.setFieldValue(fieldError.getField());
            errorList.add(exceptionDetails);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList);
    }

    @ExceptionHandler(PaymentNotFound.class)
    public ResponseEntity<ExceptionDetails> showDupError(PaymentNotFound de)
    {
        ExceptionDetails exceptionDetails = new ExceptionDetails();
        exceptionDetails.setFieldName("Payment ID");
        exceptionDetails.setFieldValue(de.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionDetails);
    }
}
