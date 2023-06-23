package com.unitech.backoffice.dto.classes;

import com.unitech.backoffice.model.Classes;

public record DetailsClassesDto(Long id, String title, String descrition, String expectedClassDate) {
    public DetailsClassesDto(Classes classes) {
        this(classes.getId(), classes.getTitle(), classes.getDescrition(), classes.getExpectedClassDate());
    }
}
