package com.home.dto.model;

import jakarta.validation.constraints.NotBlank;

public class LeitorRequest {

    @NotBlank(message = "O nome do leitor é obrigatório")
    public String nome;
    @NotBlank(message = "O telefone do leitor é obrigatório")
    public String fone;
    @NotBlank(message = "O endereço do leitor é obrigatório")
    public String endereco;
}
