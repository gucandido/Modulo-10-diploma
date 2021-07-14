package com.mlschool.mlschool.exception;

import com.mlschool.mlschool.dto.exception.ValidationError;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ApiExceptionControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationError>> defaultHandler(MethodArgumentNotValidException e){
        BindingResult result = e.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        List<ValidationError> processFieldErrors = processFieldErrors(fieldErrors);
        return ResponseEntity.badRequest().body(processFieldErrors);
    }

    private List<ValidationError> processFieldErrors(List<FieldError> fieldErrors) {
        List<ValidationError> listaDtos = new ArrayList<>();
        for (FieldError fieldError: fieldErrors) {
            listaDtos.add(new ValidationError(fieldError.getField(), fieldError.getDefaultMessage()));

        }
        return listaDtos;
    }

}
