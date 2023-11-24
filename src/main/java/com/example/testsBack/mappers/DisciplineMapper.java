package com.example.testsBack.mappers;

import com.example.testsBack.dtos.DisciplineDto;
import com.example.testsBack.entities.Discipline;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DisciplineMapper {
    Discipline toEntity(DisciplineDto disciplineDto);

    DisciplineDto toDto(Discipline discipline);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Discipline partialUpdate(DisciplineDto disciplineDto, @MappingTarget Discipline discipline);
}