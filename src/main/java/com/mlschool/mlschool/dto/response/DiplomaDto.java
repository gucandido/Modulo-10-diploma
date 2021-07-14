package com.mlschool.mlschool.dto.response;

import com.mlschool.mlschool.dto.request.StudentDto;
import com.mlschool.mlschool.entities.Student;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class DiplomaDto {

    private String message;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = true, message = "O campo deve ser no mínimo 0")
    @DecimalMax(value = "10.0", inclusive = true, message = "O campo deve ser no máximo 10")
    @Digits(integer = 2,fraction = 1, message = "O campo deve ter dois digitos inteiros e um decimal")
    private double average;

    @Valid
    private StudentDto student;

    public DiplomaDto(StudentDto dto, String message) {

        this.student = dto;
        Student std = StudentDto.dtoToClass(dto);

        this.average = std.calcAverage();

        this.message = message;

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public StudentDto getStudent() {
        return student;
    }

    public void setStudent(StudentDto student) {
        this.student = student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDto thatStudent = (StudentDto) o;
        return Objects.equals(student, thatStudent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student);
    }
}
