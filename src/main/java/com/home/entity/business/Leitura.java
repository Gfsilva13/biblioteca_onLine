package com.home.entity.business;

import com.home.entity.model.Livro;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Leitura {

     @Id
     @GeneratedValue (strategy = GenerationType.IDENTITY)
     private Long id;

     private LocalDateTime inicio;
     private LocalDateTime fim;
     @ManyToOne
     private Livro livro;
}
