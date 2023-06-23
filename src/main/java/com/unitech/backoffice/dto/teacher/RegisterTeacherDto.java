package com.unitech.backoffice.dto.teacher;

import jakarta.validation.constraints.*;

public record RegisterTeacherDto(
        @NotBlank
        String name,
        @NotBlank
        String login,
        @NotBlank
        @Size(min = 8, max = 30)
        String password) {
}