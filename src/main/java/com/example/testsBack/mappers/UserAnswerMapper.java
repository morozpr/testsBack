package com.example.testsBack.mappers;

import com.example.testsBack.dtos.UserAnswerDto;
import com.example.testsBack.entities.UserAnswer;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserAnswerMapper {
    UserAnswer toEntity(UserAnswerDto userAnswerDto);

    UserAnswerDto toDto(UserAnswer userAnswer);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    UserAnswer partialUpdate(UserAnswerDto userAnswerDto, @MappingTarget UserAnswer userAnswer);
}