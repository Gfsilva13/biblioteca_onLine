package com.home.mapper.model;

import com.home.dto.model.CategoriaRequest;
import com.home.dto.model.CategoriaResponse;
import com.home.entity.model.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "cdi")
public interface CategoriaMapper {

    @Mapping(target = "id", ignore = true)
    Categoria toEntity(CategoriaRequest request);

    CategoriaResponse toResponse(Categoria categoria);

    @Mapping(target = "id", ignore = true)
    void updateEntity(CategoriaRequest request, @MappingTarget Categoria categoria);

}
