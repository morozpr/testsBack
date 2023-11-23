package com.example.testsBack.mappers;

import com.example.testsBack.dtos.UniversityDto;
import com.example.testsBack.entities.University;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UniversityMapper {
    University toEntity(UniversityDto universityDto);

    UniversityDto toDto(University university);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    University partialUpdate(UniversityDto universityDto, @MappingTarget University university);
}