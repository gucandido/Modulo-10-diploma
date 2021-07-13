package com.mlschool.mlschool.dto.request;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.*;

public class SubjectDto {

    @NotNull
    @NotEmpty
    @Pattern(regexp = "[a-z]+")
    @Size(min=8,max=50,message = "Este campo deve ter entre 8 e 50 caracteres")
    private String subject;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = true, message = "O campo deve ser no mínimo 0")
    @DecimalMax(value = "10.0", inclusive = true, message = "O campo deve ser no máximo 10")
    @Digits(integer = 2,fraction = 1, message = "O campo deve ter dois digitos inteiros e um decimal")
    private double note;

    public SubjectDto(String subject, double note) {
        this.subject = subject;
        this.note = note;
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
