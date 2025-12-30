package com.home.service.model;

import com.home.repository.model.LivroRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class LivroService {

    @Inject
    LivroRepository livroRepository;
}
