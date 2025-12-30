package com.home.entity.model;

import jakarta.persistence.*;

@Entity
public class Livro {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private Boolean isRead;
    private Boolean isEmprestado;

    @ManyToOne
    private Autor autor;
    @ManyToOne
    private Editora editora;
    @ManyToOne
    private Categoria categoria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }

    public Boolean getEmprestado() {
        return isEmprestado;
    }

    public void setEmprestado(Boolean emprestado) {
        isEmprestado = emprestado;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
