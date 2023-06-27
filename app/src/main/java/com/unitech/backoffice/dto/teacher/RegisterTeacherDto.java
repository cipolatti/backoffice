package com.unitech.backoffice.dto.teacher;

import jakarta.validation.constraints.NotBlank;

public record RegisterTeacherDto(
        @NotBlank
        String name,
        @NotBlank
        String login) {
}
