package com.arheco.apialu.model;

import jakarta.validation.constraints.NotBlank;

public record DatosAutenticacionUsuario(
        @NotBlank String login,
        @NotBlank String clave
) {
}