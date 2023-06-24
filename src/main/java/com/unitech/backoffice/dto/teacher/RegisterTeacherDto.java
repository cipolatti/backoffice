package com.unitech.backoffice.dto.teacher;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterTeacherDto(
        @NotBlank
        String name,
        @NotBlank
        String login,
        @NotBlank
        @Size(min = 8, max = 100)
        String password) {
}
