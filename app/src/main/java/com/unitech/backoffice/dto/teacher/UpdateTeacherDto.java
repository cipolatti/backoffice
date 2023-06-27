package com.unitech.backoffice.dto.teacher;

import jakarta.validation.constraints.NotNull;

public record UpdateTeacherDto(
        @NotNull
        Long id,
        String name,
        String login) {
}
