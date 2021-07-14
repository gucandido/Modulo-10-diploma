package com.mlschool.mlschool.controller;

import com.mlschool.mlschool.dto.request.StudentDto;
import com.mlschool.mlschool.dto.response.DiplomaDto;
import com.mlschool.mlschool.service.DiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class DiplomaController {

    @Autowired
    private DiplomaService diplomaService;

    @PostMapping("/analyzeNotes")
    public ResponseEntity<?> postAnalyze(@RequestBody @Valid StudentDto student){

        return new ResponseEntity<>(diplomaService.analyzeNotes(student), HttpStatus.ACCEPTED);

    }

    @PostMapping("/writeDiploma")
    public ResponseEntity<?> postDiploma(@RequestBody @Valid StudentDto student){

        return new ResponseEntity<>(diplomaService.writeDiploma(student), HttpStatus.ACCEPTED);

    }

}
