package com.unitech.backoffice.dto.classes;

import com.unitech.backoffice.model.ClassesModel;

public record DetailsClassesDto(Long id, String title, String descrition, String expectedClassDate) {
    public DetailsClassesDto(ClassesModel classesModel) {
        this(classesModel.getId(), classesModel.getTitle(), classesModel.getDescrition(), classesModel.getExpectedClassDate());
    }
}
