package com.home.dto.model.request;

import jakarta.validation.constraints.NotBlank;

public class CategoriaRequest {

    @NotBlank(message = "Categoria é obrigatória")
    public String categoria;
}
