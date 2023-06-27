package com.unitech.backoffice.dto.classes;

import com.unitech.backoffice.model.ClassesModel;
import jakarta.validation.constraints.NotNull;

public record LinkClassTeacherDto(
        @NotNull
        Long id,
        @NotNull
        Long idTeacher) {
    public LinkClassTeacherDto(ClassesModel classesModel) {
        this(classesModel.getId(), classesModel.getIdTeacher());
    }
}
