package com.home.repository.model;

import com.home.entity.model.Categoria;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CategoriaRepository implements PanacheRepository<Categoria> {
}
