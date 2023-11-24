package com.example.testsBack.mappers;

import com.example.testsBack.dtos.QuestionDto;
import com.example.testsBack.entities.Question;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface QuestionMapper {
    Question toEntity(QuestionDto questionDto);

    @AfterMapping
    default void linkAnswers(@MappingTarget Question question) {
        question.getAnswers().forEach(answer -> answer.setQuestionID(question));
    }

    QuestionDto toDto(Question question);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Question partialUpdate(QuestionDto questionDto, @MappingTarget Question question);
}