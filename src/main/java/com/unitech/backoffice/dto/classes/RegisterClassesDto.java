package com.unitech.backoffice.dto.classes;

import jakarta.validation.constraints.NotBlank;

public record RegisterClassesDto(
        @NotBlank
        String title,
        @NotBlank
        String descrition,
        @NotBlank
        String expectedClassDate) {
}
