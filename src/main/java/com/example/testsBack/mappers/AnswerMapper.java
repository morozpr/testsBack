package com.example.testsBack.mappers;

import com.example.testsBack.dtos.AnswerDto;
import com.example.testsBack.entities.Answer;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AnswerMapper {
    Answer toEntity(AnswerDto answerDto);

    AnswerDto toDto(Answer answer);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Answer partialUpdate(AnswerDto answerDto, @MappingTarget Answer answer);
}