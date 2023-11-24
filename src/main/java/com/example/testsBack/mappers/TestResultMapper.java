package com.example.testsBack.mappers;

import com.example.testsBack.dtos.TestResultDto;
import com.example.testsBack.entities.TestResult;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {TestMapper.class, UserMapper.class})
public interface TestResultMapper {
    TestResult toEntity(TestResultDto testResultDto);

    TestResultDto toDto(TestResult testResult);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TestResult partialUpdate(TestResultDto testResultDto, @MappingTarget TestResult testResult);
}