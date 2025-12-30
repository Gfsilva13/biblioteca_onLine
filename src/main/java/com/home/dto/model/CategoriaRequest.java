package com.home.dto.model;

import jakarta.validation.constraints.NotBlank;

public class CategoriaRequest {

    @NotBlank(message = "Categoria é obrigatória")
    public String categoria;
}
