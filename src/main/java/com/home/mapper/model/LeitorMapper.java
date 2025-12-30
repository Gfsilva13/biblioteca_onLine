package com.home.mapper.model;

import com.home.dto.model.LeitorRequest;
import com.home.dto.model.LeitorResponse;
import com.home.entity.model.Leitor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "cdi")
public interface LeitorMapper {

    @Mapping(target = "id", ignore = true)
    Leitor toEntity(LeitorRequest request);

    LeitorResponse toResponse(Leitor leitor);

    @Mapping(target = "id", ignore = true)
    void updateEntity(LeitorRequest request, @MappingTarget Leitor leitor);

}
