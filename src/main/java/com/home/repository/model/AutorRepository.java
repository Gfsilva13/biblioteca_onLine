package com.home.repository.model;

import com.home.entity.model.Autor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AutorRepository implements PanacheRepository<Autor> {
}
