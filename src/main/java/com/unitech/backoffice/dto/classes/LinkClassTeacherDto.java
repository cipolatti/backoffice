package com.unitech.backoffice.dto.classes;

import com.unitech.backoffice.model.Classes;
import jakarta.validation.constraints.NotNull;

public record LinkClassTeacherDto(
        @NotNull
        Long id,
        @NotNull
        Long idTeacher) {
    public LinkClassTeacherDto(Classes classes) {
        this(classes.getId(), classes.getIdTeacher());
    }
}
