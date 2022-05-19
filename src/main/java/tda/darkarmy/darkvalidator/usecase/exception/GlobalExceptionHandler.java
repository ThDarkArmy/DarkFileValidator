package tda.darkarmy.darkvalidator.usecase.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.status;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        var error = exception.getBindingResult().getAllErrors()
                .stream()
                .map(exc->
                        new BeanValidationException(Objects.requireNonNull(exc.getCodes())[1] , exc.getDefaultMessage())
                )
                .collect(Collectors.toList());
        return status(500).body(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "validation Error", error));

    }

    @ExceptionHandler({BindException.class})
    public ResponseEntity<?> handleBindException(BindException exception, HttpServletRequest request){
        var error = exception.getBindingResult().getAllErrors()
                .stream()
                .map(exc->
                        new BeanValidationException(Objects.requireNonNull(exc.getCodes())[1] , exc.getDefaultMessage())
                )
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Validation Error", error));
    }
}
