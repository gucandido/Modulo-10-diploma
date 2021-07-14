package com.mlschool.mlschool.repository;

import com.mlschool.mlschool.dto.request.StudentDto;
import com.mlschool.mlschool.dto.response.DiplomaDto;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DiplomaRepository {

    public static HashMap<Integer, DiplomaDto> diplomas = new HashMap<>();


    public DiplomaRepository() {
    }

    public DiplomaDto save(StudentDto std, String message){

        int key = 0;

        if(!diplomas.isEmpty())
            key = diplomas.entrySet().stream().max(Comparator.comparing(Map.Entry::getKey)).get().getKey()+1;

        diplomas.put(key, new DiplomaDto(std,message));

        return diplomas.get(key);

    }

    public DiplomaDto findByStudent(StudentDto dto){

        return diplomas.entrySet().stream().filter(x->x.getValue().getStudent().equals(dto)).findFirst().orElse(null).getValue();

    }

    public void resetDb(){
        diplomas = new HashMap<>();
    }


}
