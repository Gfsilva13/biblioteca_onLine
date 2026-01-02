package com.home.dto.model.request;

import jakarta.validation.constraints.NotBlank;

public class LivroRequest {

    @NotBlank(message = "O titulo do livro é obrigatório")
    public String titulo;

}
