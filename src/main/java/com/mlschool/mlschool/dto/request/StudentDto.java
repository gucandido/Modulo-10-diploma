package com.mlschool.mlschool.dto.request;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class StudentDto {

    @NotNull
    @NotEmpty
    @Pattern(regexp = "[a-z]+")
    @Size(min=8,max=50,message = "O nome deve ter entre 8 e 50 caracteres")
    private String name;

    @NotNull
    @Valid
    private List<SubjectDto> subjects;

    public StudentDto(String name, List<SubjectDto> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubjectDto> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectDto> subjects) {
        this.subjects = subjects;
    }

}
