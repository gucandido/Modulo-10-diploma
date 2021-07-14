package com.mlschool.mlschool.entities;

import com.mlschool.mlschool.dto.request.SubjectDto;

public class Subject {

    private String subject;
    private double note;

    public Subject(SubjectDto dto) {
        this.subject = dto.getSubject();
        this.note = dto.getNote();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }
}
