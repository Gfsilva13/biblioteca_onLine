package com.home.service.model;

import com.home.dto.model.CategoriaRequest;
import com.home.dto.model.CategoriaResponse;
import com.home.entity.model.Categoria;
import com.home.mapper.model.CategoriaMapper;
import com.home.repository.model.CategoriaRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.util.List;

@ApplicationScoped
public class CategoriaService {

    @Inject
    CategoriaRepository categoriaRepository;

    @Inject
    CategoriaMapper mapper;

    @Transactional
    public CategoriaResponse cadastraCategoria(CategoriaRequest request) {
        Categoria categoria = mapper.toEntity(request);
        categoriaRepository.persist(categoria);
        return mapper.toResponse(categoria);
    }

    public CategoriaResponse buscarPorId(Long id){
        Categoria categoria = categoriaRepository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Categoria não encontrada"));
        return mapper.toResponse(categoria);
    }

    public List<CategoriaResponse> listarAll(int page, int size){
        return categoriaRepository.listAll(Sort.by("categoria").ascending())
                .stream()
                .skip((long)(page - 1) * size)
                .limit(size)
                .map(mapper::toResponse)
                .toList();
    }

    @Transactional
    public void excluirCategoria(Long id) {
        Categoria categoria = categoriaRepository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Categoria não encontrada"));
        categoriaRepository.delete(categoria);
    }

    @Transactional
    public CategoriaResponse atualizarCategoria(Long id, CategoriaRequest request) {
        Categoria categoria = categoriaRepository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Categoria não encontrada"));
        mapper.updateEntity(request, categoria);
        return mapper.toResponse(categoria);
    }
}
