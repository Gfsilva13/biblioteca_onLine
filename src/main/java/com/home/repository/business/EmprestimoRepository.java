package com.home.repository.business;

import com.home.entity.business.Emprestimo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EmprestimoRepository implements PanacheRepository<Emprestimo> {
}
