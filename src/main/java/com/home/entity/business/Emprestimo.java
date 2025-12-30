package com.home.entity.business;

import com.home.entity.model.Leitor;
import com.home.entity.model.Livro;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Emprestimo {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private LocalDateTime dataDevolucao;
    @ManyToOne
    private Livro livro;
    @ManyToOne
    private Leitor leitor;
}
