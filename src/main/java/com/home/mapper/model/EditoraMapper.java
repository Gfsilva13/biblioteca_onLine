package com.home.mapper.model;

import com.home.dto.model.request.EditoraRequest;
import com.home.dto.model.response.EditoraResponse;
import com.home.entity.model.Editora;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "cdi")
public interface EditoraMapper {

    @Mapping(target = "id", ignore = true)
    Editora toEntity(EditoraRequest request);

    EditoraResponse toResponse(Editora editora);

    @Mapping(target = "id", ignore = true)
    void updateEntity(EditoraRequest request, @MappingTarget Editora editora);

}
