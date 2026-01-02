package com.home.dto.model.response;

import com.home.entity.model.Autor;
import com.home.entity.model.Categoria;
import com.home.entity.model.Editora;

public record LivroResponse(Long id, String titulo,
                            Boolean isRead, Boolean isEmprestado,
                            Autor autor, Editora editora, Categoria categoria) {
}
