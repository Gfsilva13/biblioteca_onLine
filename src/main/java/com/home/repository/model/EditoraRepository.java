package com.home.repository.model;

import com.home.entity.model.Editora;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EditoraRepository implements PanacheRepository<Editora> {
}
