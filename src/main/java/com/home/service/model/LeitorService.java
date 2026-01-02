package com.home.service.model;

import com.home.dto.model.request.LeitorRequest;
import com.home.dto.model.response.LeitorResponse;
import com.home.entity.model.Leitor;
import com.home.mapper.model.LeitorMapper;
import com.home.repository.model.LeitorRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.util.List;

@ApplicationScoped
public class LeitorService {

    @Inject
    LeitorRepository leitorRepository;

    @Inject
    LeitorMapper mapper;

    @Transactional
    public LeitorResponse cadastraLeitor(LeitorRequest request) {
        Leitor leitor = mapper.toEntity(request);
        leitorRepository.persist(leitor);
        return mapper.toResponse(leitor);
    }

    public LeitorResponse buscarPorId(Long id){
        Leitor leitor = leitorRepository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Leitor não encontrado"));
        return mapper.toResponse(leitor);
    }

    public List<LeitorResponse> listarAll(int page, int size){
        return leitorRepository.listAll(Sort.by("nome").ascending())
                .stream()
                .skip((long)(page - 1) * size)
                .limit(size)
                .map(mapper::toResponse)
                .toList();
    }

    @Transactional
    public void excluirLeitor(Long id) {
        Leitor leitor = leitorRepository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Leitor não encontrado"));
        leitorRepository.delete(leitor);
    }

    @Transactional
    public LeitorResponse atualizarLeitor(Long id, LeitorRequest request) {
        Leitor leitor = leitorRepository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Leitor não encontrado"));
        mapper.updateEntity(request, leitor);
        return mapper.toResponse(leitor);
    }

}
