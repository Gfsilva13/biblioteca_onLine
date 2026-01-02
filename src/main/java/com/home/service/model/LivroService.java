package com.home.service.model;

import com.home.dto.model.request.LivroRequest;
import com.home.dto.model.response.LivroResponse;
import com.home.entity.model.Livro;
import com.home.mapper.model.LivroMapper;
import com.home.repository.model.LivroRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.util.List;

@ApplicationScoped
public class LivroService {

    @Inject
    LivroRepository livroRepository;

    @Inject
    LivroMapper mapper;

    @Transactional
    public LivroResponse cadastraLivro(LivroRequest request) {
        Livro livro = mapper.toEntity(request);
        livroRepository.persist(livro);
        return mapper.toResponse(livro);
    }

    public LivroResponse buscarPorId(Long id){
        Livro livro = livroRepository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Livro não encontrado"));
        return mapper.toResponse(livro);
    }

    public List<LivroResponse> listarAll(int page, int size){
        return livroRepository.listAll(Sort.by("titulo").ascending())
                .stream()
                .skip((long)(page - 1) * size)
                .limit(size)
                .map(mapper::toResponse)
                .toList();
    }

    @Transactional
    public void excluirLivro(Long id) {
        Livro livro = livroRepository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Livro não encontrado"));
        livroRepository.delete(livro);
    }

    @Transactional
    public LivroResponse atualizarLivro(Long id, LivroRequest request) {
        Livro livro = livroRepository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Livro não encontrado"));
        mapper.updateEntity(request, livro);
        return mapper.toResponse(livro);
    }
}
