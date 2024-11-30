package com.amarchanh.hexagonal_architecture.infraestructure.adapters.output.customizedexception;

import com.amarchanh.hexagonal_architecture.domain.exception.ProductNotFound;
import com.amarchanh.hexagonal_architecture.infraestructure.adapters.output.customizedexception.data.response.ExceptionResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@RestController
public class CustomizedExceptionAdapter extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(final Exception ex, final WebRequest request) {
        final ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(),
                List.of(request.getDescription(false)));

        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ProductNotFound.class)
    public final ResponseEntity<Object> handleUserNotFoundException(final ProductNotFound ex, final WebRequest request) {
        final ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(),
                List.of(request.getDescription(false)));

        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

}
