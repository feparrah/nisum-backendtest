package co.test.nisum.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import co.test.nisum.dto.ErrorResponse;
import co.test.nisum.exception.BadRequestException;

@ControllerAdvice
public class ControllerExceptionHandler {


	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationErrors(MethodArgumentNotValidException ex) {
        String error = ex.getFieldError().getDefaultMessage();
        ErrorResponse response = new ErrorResponse(error);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleValidationErrors(BadRequestException ex) {
        String error = ex.getMessage();
        ErrorResponse response = new ErrorResponse(error);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}