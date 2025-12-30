package com.home.dto.model;

import jakarta.validation.constraints.NotBlank;

public class AutorRequest {

    @NotBlank(message = "O nome do autor é obrigatório")
    public String nomeAutor;
}
