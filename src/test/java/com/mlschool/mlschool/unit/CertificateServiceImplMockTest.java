package com.mlschool.mlschool.unit;

import com.mlschool.mlschool.dto.request.StudentDto;
import com.mlschool.mlschool.dto.request.SubjectDto;
import com.mlschool.mlschool.dto.response.DiplomaDto;
import com.mlschool.mlschool.repository.DiplomaRepository;
import com.mlschool.mlschool.service.DiplomaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CertificateServiceImplMockTest {

    private DiplomaService diplomaService;

    private List<SubjectDto> list = new ArrayList<>();
    private StudentDto student1;

    private DiplomaRepository repository;

    @BeforeEach
    public void init() {
        repository = Mockito.mock(DiplomaRepository.class);
        diplomaService = new DiplomaService(repository);

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

        Mockito.when(repository.findByStudent(student1)).thenReturn(expected);

        // check
        Mockito.verify(repository).save(student1, diplomaService.withHonors(student1));

        DiplomaDto std = repository.findByStudent(student1);
        assertTrue(std.getStudent().equals(expected.getStudent()));

    }

    @Test
    public void shouldCalculateAverage(){

        double avg = list.stream().mapToDouble(SubjectDto::getNote).average().orElse(0.0);

        diplomaService.writeDiploma(student1);
        DiplomaDto expected = new DiplomaDto(student1, diplomaService.withHonors(student1));
        Mockito.when(repository.findByStudent(student1)).thenReturn(expected);


        assertEquals(avg,expected.getAverage());

    }

    @Test
    public void shouldAnalyzeNotes(){
        diplomaService.writeDiploma(student1);

        DiplomaDto expected = new DiplomaDto(student1, diplomaService.withHonors(student1));

        Mockito.when(repository.findByStudent(student1)).thenReturn(expected);

        // check
        Mockito.verify(repository).save(student1, diplomaService.withHonors(student1));

        DiplomaDto std = repository.findByStudent(student1);

        assertEquals(expected.getStudent(),std.getStudent());
    }

    @Test
    public void shouldGenerateHonorMessage(){
        assertEquals("Parabens por se formar!",diplomaService.withHonors(student1));
    }

}
