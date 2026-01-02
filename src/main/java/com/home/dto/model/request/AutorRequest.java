package com.home.dto.model.request;

import jakarta.validation.constraints.NotBlank;

public class AutorRequest {

    @NotBlank(message = "O nome do autor é obrigatório")
    public String nomeAutor;
}
