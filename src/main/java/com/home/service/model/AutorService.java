package com.home.service.model;

import com.home.dto.model.request.AutorRequest;
import com.home.dto.model.response.AutorResponse;
import com.home.entity.model.Autor;
import com.home.mapper.model.AutorMapper;
import com.home.repository.model.AutorRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.util.List;

@ApplicationScoped
public class AutorService {

    @Inject
    AutorRepository autorRepository;

    @Inject
    AutorMapper mapper;

    @Transactional
    public AutorResponse cadastraAutor(AutorRequest request) {
        Autor autor = mapper.toEntity(request);
        autorRepository.persist(autor);
        return mapper.toResponse(autor);
    }

    public AutorResponse buscarPorId(Long id){
        Autor autor = autorRepository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Autor não encontrado"));
        return mapper.toResponse(autor);
    }

    public List<AutorResponse> listarAll(int page, int size){
        return autorRepository.listAll(Sort.by("nomeAutor").ascending())
                .stream()
                .skip((long)(page - 1) * size)
                .limit(size)
                .map(mapper::toResponse)
                .toList();
    }

    @Transactional
    public void excluirAutor(Long id) {
        Autor autor = autorRepository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Autor não encontrado"));
        autorRepository.delete(autor);
    }

    @Transactional
    public AutorResponse atualizarAutor(Long id, AutorRequest request) {
        Autor autor = autorRepository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Autor não encontrado"));
        mapper.updateEntity(request, autor);
        return mapper.toResponse(autor);
    }
}
