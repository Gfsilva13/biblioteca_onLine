package com.home.service.model;

import com.home.repository.model.LeitorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class LeitorService {

    @Inject
    LeitorRepository leitorRepository;
}
