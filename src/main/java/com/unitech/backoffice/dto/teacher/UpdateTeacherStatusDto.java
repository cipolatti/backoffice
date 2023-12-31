package com.unitech.backoffice.dto.teacher;

import com.unitech.backoffice.model.enums.Status;
import jakarta.validation.constraints.NotNull;

public record UpdateTeacherStatusDto(
        @NotNull
        Long id,
        Status status) {
}
