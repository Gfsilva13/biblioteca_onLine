package com.home.mapper.model;

import com.home.dto.model.AutorRequest;
import com.home.dto.model.AutorResponse;
import com.home.entity.model.Autor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "cdi")
public interface AutorMapper {

    @Mapping(target = "id", ignore = true)
    Autor toEntity(AutorRequest request);

    AutorResponse toResponse(Autor autor);

    @Mapping(target = "id", ignore = true)
    void updateEntity(AutorRequest request, @MappingTarget Autor autor);

}
