package com.unitech.backoffice.dto;

import jakarta.validation.constraints.*;

public record DataRegisterTeacher(
        @NotBlank
        String name,
        @NotBlank
        String login,
        @NotBlank
        @Size(min = 8, max = 30)
        String password) {
}
