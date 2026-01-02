package com.home.dto.model.request;

import jakarta.validation.constraints.NotBlank;

public class EditoraRequest {

    @NotBlank(message = "O nome da editora é obrigatório")
    public String nomeEditora;
    @NotBlank(message = "UF da editora é obrigatório")
    public String uf;
}
