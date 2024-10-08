package br.com.vbruno.travelassistant.controller;

import br.com.vbruno.travelassistant.DTO.ErrorResponse;
import br.com.vbruno.travelassistant.exception.DateInvalidException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class AdviceController {

    @ExceptionHandler(DateInvalidException.class)
    public ResponseEntity<ErrorResponse> handleDateInvalidException(DateInvalidException ex, HttpServletRequest request) {

        HttpStatus status = BAD_REQUEST;

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setTimeStamp(LocalDateTime.now());
        errorResponse.setStatus(status.value());
        errorResponse.setReasonPhrase(status.getReasonPhrase());
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setPath(request.getServletPath());

        return new ResponseEntity<>(errorResponse, status);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex, HttpServletRequest request) {

        HttpStatus status = BAD_REQUEST;

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setTimeStamp(LocalDateTime.now());
        errorResponse.setStatus(status.value());
        errorResponse.setReasonPhrase(status.getReasonPhrase());
        errorResponse.setMessage("O tipo do argumento " + ex.getPropertyName() + " é inválido");
        errorResponse.setPath(request.getServletPath());

        return new ResponseEntity<>(errorResponse, status);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorResponse> handleMissingServletRequestParameterException(MissingServletRequestParameterException ex, HttpServletRequest request) {

        HttpStatus status = BAD_REQUEST;

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setTimeStamp(LocalDateTime.now());
        errorResponse.setStatus(status.value());
        errorResponse.setReasonPhrase(status.getReasonPhrase());
        errorResponse.setMessage("O parâmetro " + ex.getParameterName() + " não foi definido");
        errorResponse.setPath(request.getServletPath());

        return new ResponseEntity<>(errorResponse, status);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoResourceFoundException(NoResourceFoundException ex, HttpServletRequest request) {

        HttpStatus status = NOT_FOUND;

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setTimeStamp(LocalDateTime.now());
        errorResponse.setStatus(status.value());
        errorResponse.setReasonPhrase(status.getReasonPhrase());
        errorResponse.setMessage("Rota não encontrada");
        errorResponse.setPath(request.getServletPath());

        return new ResponseEntity<>(errorResponse, status);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex, HttpServletRequest request) {

        HttpStatus status = INTERNAL_SERVER_ERROR;

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setTimeStamp(LocalDateTime.now());
        errorResponse.setStatus(status.value());
        errorResponse.setReasonPhrase(status.getReasonPhrase());
        errorResponse.setMessage("Ocorreu algum problema interno no servidor");
        errorResponse.setPath(request.getServletPath());

        return new ResponseEntity<>(errorResponse, status);
    }
}
