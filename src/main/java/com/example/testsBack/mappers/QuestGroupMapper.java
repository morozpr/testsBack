package com.example.testsBack.mappers;

import com.example.testsBack.dtos.QuestGroupDto;
import com.example.testsBack.entities.QuestGroup;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface QuestGroupMapper {
    QuestGroup toEntity(QuestGroupDto questGroupDto);

    @AfterMapping
    default void linkQuestions(@MappingTarget QuestGroup questGroup) {
        questGroup.getQuestions().forEach(question -> question.setQuestGroupID(questGroup));
    }

    QuestGroupDto toDto(QuestGroup questGroup);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    QuestGroup partialUpdate(QuestGroupDto questGroupDto, @MappingTarget QuestGroup questGroup);
}