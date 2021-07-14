package com.mlschool.mlschool.controller;

import com.mlschool.mlschool.dto.request.StudentDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class DiplomaController {

    @PostMapping("/analyzeNotes")
    public ResponseEntity<?> postDiploma(@RequestBody @Valid StudentDto student){

        return new ResponseEntity<>(student, HttpStatus.ACCEPTED);

    }

}
