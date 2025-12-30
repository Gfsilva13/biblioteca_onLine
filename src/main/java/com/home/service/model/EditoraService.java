package com.home.service.model;

import com.home.repository.model.EditoraRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class EditoraService {

    @Inject
    EditoraRepository editoraRepository;
}
