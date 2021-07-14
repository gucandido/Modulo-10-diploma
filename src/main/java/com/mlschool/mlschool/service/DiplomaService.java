package com.mlschool.mlschool.service;

import com.mlschool.mlschool.dto.request.StudentDto;
import com.mlschool.mlschool.dto.response.DiplomaDto;
import com.mlschool.mlschool.entities.Student;
import com.mlschool.mlschool.repository.DiplomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DiplomaService {

    @Autowired
    private DiplomaRepository diplomaRepo;

    public DiplomaService(DiplomaRepository diplomaRepo) {

        this.diplomaRepo = diplomaRepo;

    }

    public DiplomaDto analyzeNotes(StudentDto dto){

        return this.diplomaRepo.findByStudent(dto);

    }

    public DiplomaDto writeDiploma(StudentDto dto){

        return this.diplomaRepo.save(dto, withHonors(dto));

    }

    public String withHonors(StudentDto dto){

        Student std = new Student(dto);
        double avg = std.calcAverage();

        if(avg > 9)
             return "Parabens por se formar com louvor em nossa instutuição!";
        else if(avg >= 6)
            return "Parabens por se formar!";
        else
            return "Até semestre que vem! =D";

    }

    public void resetDb(){
        diplomaRepo.resetDb();
    }

}
