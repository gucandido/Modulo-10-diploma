package com.mlschool.mlschool.unit;

import com.mlschool.mlschool.dto.request.StudentDto;
import com.mlschool.mlschool.dto.request.SubjectDto;
import com.mlschool.mlschool.dto.response.DiplomaDto;
import com.mlschool.mlschool.service.DiplomaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CertificateServiceImplTest {

    @Autowired
    private DiplomaService diplomaService;
    private List<SubjectDto> list = new ArrayList<>();
    private StudentDto student1;

    @BeforeEach
    public void init(){

        diplomaService.resetDb();
        list = new ArrayList<>();
        student1 = null;

        list.add(new SubjectDto("matematica",10.0));
        list.add(new SubjectDto("fisicaquantica",6.5));
        list.add(new SubjectDto("nanoquimica",5.6));

        student1 = new StudentDto("kamillah", list);

    }

    @Test
    public void shouldSaveNewDiploma(){
       DiplomaDto result =  diplomaService.writeDiploma(student1),
                  expected = new DiplomaDto(student1, diplomaService.withHonors(student1));

        assertEquals(expected.getStudent(),result.getStudent());

    }

    @Test
    public void shouldCalculateAverage(){
        DiplomaDto result =  diplomaService.writeDiploma(student1),
                expected = new DiplomaDto(student1, diplomaService.withHonors(student1));

        double avg = list.stream().mapToDouble(SubjectDto::getNote).average().orElse(0.0);

        assertEquals(avg,result.getAverage());

    }

    @Test
    public void shouldAnalyzeNotes(){
        diplomaService.writeDiploma(student1);

        DiplomaDto expected = new DiplomaDto(student1, diplomaService.withHonors(student1)),
                   result = diplomaService.analyzeNotes(student1);

        assertEquals(expected.getStudent(),result.getStudent());
    }

    @Test
    public void shouldGenerateHonorMessage(){
        assertEquals("Parabens por se formar!",diplomaService.withHonors(student1));
    }

}
