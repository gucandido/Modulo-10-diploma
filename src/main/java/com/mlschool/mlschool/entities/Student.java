package com.mlschool.mlschool.entities;

import com.mlschool.mlschool.dto.request.StudentDto;
import com.mlschool.mlschool.dto.request.SubjectDto;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;

    private List<Subject> subjects = new ArrayList<>();

    public Student(StudentDto s) {
        this.name = s.getName();
        s.getSubjects().forEach(x-> this.subjects.add(SubjectDto.dtoToClass(x)));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public double calcAverage(){

        if(subjects.size() == 0)
            throw new ArithmeticException("Não é possivel dividir por zero");

        return subjects.stream().mapToDouble(Subject::getNote).average().orElse(0.0);

    }

}
