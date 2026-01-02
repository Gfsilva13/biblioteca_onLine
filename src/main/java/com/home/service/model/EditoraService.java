package com.home.service.model;

import com.home.dto.model.request.EditoraRequest;
import com.home.dto.model.response.EditoraResponse;
import com.home.entity.model.Editora;
import com.home.mapper.model.EditoraMapper;
import com.home.repository.model.EditoraRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.util.List;

@ApplicationScoped
public class EditoraService {

    @Inject
    EditoraRepository editoraRepository;

    @Inject
    EditoraMapper mapper;

    @Transactional
    public EditoraResponse cadastrarEditora(EditoraRequest request) {
        Editora editora = mapper.toEntity(request);
        editoraRepository.persist(editora);
        return mapper.toResponse(editora);
    }

    public EditoraResponse buscarPorId(Long id){
        Editora editora = editoraRepository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Editora não encontrada"));
        return mapper.toResponse(editora);
    }

    public List<EditoraResponse> listarAll(int page, int size){
        return editoraRepository.listAll(Sort.by("nomeEditora").ascending())
                .stream()
                .skip((long)(page - 1) * size)
                .limit(size)
                .map(mapper::toResponse)
                .toList();
    }

    @Transactional
    public void excluirEditora(Long id) {
        Editora editora = editoraRepository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Editora não encontrada"));
        editoraRepository.delete(editora);
    }

    @Transactional
    public EditoraResponse atualizarEditora(Long id, EditoraRequest request) {
        Editora editora = editoraRepository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Editora não encontrada"));
        mapper.updateEntity(request, editora);
        return mapper.toResponse(editora);
    }
}
