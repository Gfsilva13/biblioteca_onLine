package com.home.repository.model;

import com.home.entity.model.Leitor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LeitorRepository implements PanacheRepository<Leitor> {
}
