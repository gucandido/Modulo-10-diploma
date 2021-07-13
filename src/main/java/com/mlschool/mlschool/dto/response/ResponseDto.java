package com.mlschool.mlschool.dto.response;

import com.mlschool.mlschool.dto.request.StudentDto;

public class ResponseDto {

    private String message;
    private double average;
    private StudentDto student;

    public ResponseDto(String message, double average, StudentDto student) {
        this.message = message;
        this.average = average;
        this.student = student;
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

}
