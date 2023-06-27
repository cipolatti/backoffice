package com.unitech.backoffice.dto.classes;

import jakarta.validation.constraints.NotNull;

public record UpdateClassesDto(
        @NotNull
        Long id,
        String title,
        String descrition,
        String expectedClassDate) {
}
