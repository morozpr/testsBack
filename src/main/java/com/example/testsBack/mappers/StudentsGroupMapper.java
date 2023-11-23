package com.example.testsBack.mappers;

import com.example.testsBack.dtos.StudentsGroupDto;
import com.example.testsBack.entities.StudentsGroup;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface StudentsGroupMapper {
    StudentsGroup toEntity(StudentsGroupDto studentsGroupDto);

    StudentsGroupDto toDto(StudentsGroup studentsGroup);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    StudentsGroup partialUpdate(StudentsGroupDto studentsGroupDto, @MappingTarget StudentsGroup studentsGroup);
}