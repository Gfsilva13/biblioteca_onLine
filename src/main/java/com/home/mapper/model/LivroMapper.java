package com.home.mapper.model;

import com.home.dto.model.LivroRequest;
import com.home.dto.model.LivroResponse;
import com.home.entity.model.Livro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "cdi")
public interface LivroMapper {

    @Mapping(target = "id", ignore = true)
    Livro toEntity(LivroRequest request);

    LivroResponse toResponse(Livro livro);

    @Mapping(target = "id", ignore = true)
    void updateEntity(LivroRequest request, @MappingTarget Livro livro);

}
