package com.home.repository.business;

import com.home.entity.business.Leitura;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LeituraRepository implements PanacheRepository<Leitura> {
}
