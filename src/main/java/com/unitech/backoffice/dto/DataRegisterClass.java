package com.unitech.backoffice.dto;

import jakarta.validation.constraints.NotBlank;

public record DataRegisterClass(
        @NotBlank
        String title,
        @NotBlank
        String descrition,
        @NotBlank
        String expectedClassDate) {
}
