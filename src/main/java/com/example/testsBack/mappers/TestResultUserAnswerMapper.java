package com.example.testsBack.mappers;

import com.example.testsBack.dtos.TestResultUserAnswerDto;
import com.example.testsBack.entities.TestResultUserAnswer;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TestResultUserAnswerMapper {
    TestResultUserAnswer toEntity(TestResultUserAnswerDto testResultUserAnswerDto);

    TestResultUserAnswerDto toDto(TestResultUserAnswer testResultUserAnswer);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TestResultUserAnswer partialUpdate(TestResultUserAnswerDto testResultUserAnswerDto, @MappingTarget TestResultUserAnswer testResultUserAnswer);
}