package com.home.service.business;

import com.home.repository.business.LeituraRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class LeituraService {

    @Inject
    LeituraRepository leituraRepository;
}
