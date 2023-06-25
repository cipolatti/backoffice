package com.unitech.backoffice.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterUserDto(
    @NotBlank
    String name,
    @NotBlank
    String login,
    @NotBlank
    @Size(min = 8, max = 100)
    String password) {
}
