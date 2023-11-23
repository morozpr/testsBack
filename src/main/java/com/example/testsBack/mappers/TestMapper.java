package com.example.testsBack.mappers;

import com.example.testsBack.dtos.TestDto;
import com.example.testsBack.entities.Test;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TestMapper {
    Test toEntity(TestDto testDto);

    TestDto toDto(Test test);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Test partialUpdate(TestDto testDto, @MappingTarget Test test);
}

