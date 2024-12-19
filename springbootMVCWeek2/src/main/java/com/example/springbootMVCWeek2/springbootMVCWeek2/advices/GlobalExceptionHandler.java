package com.example.springbootMVCWeek2.springbootMVCWeek2.advices;


import com.example.springbootMVCWeek2.springbootMVCWeek2.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> handleResourceNotFound(ResourceNotFoundException exception){
       APIError error =  APIError.builder()
               .status(HttpStatus.NOT_FOUND)
               .message(exception.getMessage())
               .build();
       return buildErrorResponseEntity(error);
    }

    private ResponseEntity<ApiResponse<?>> buildErrorResponseEntity(APIError error){
        return new ResponseEntity<>(new ApiResponse<>(error), error.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleOtherErrors(Exception exception){
        APIError error =  APIError.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .message(exception.getMessage())
                .build();
        return buildErrorResponseEntity(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleInputValidationErrors(MethodArgumentNotValidException exception){
        List<String> errors = exception.getBindingResult()
                .getAllErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());

        APIError error =  APIError.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message("Input Validation failed")
                .suberros(errors)
                .build();
        return buildErrorResponseEntity(error);
    }



}
