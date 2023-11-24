package com.example.testsBack.mappers;

import com.example.testsBack.dtos.QuestBaseDto;
import com.example.testsBack.entities.QuestBase;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {DisciplineMapper.class})
public interface QuestBaseMapper {
    QuestBase toEntity(QuestBaseDto questBaseDto);

    @AfterMapping
    default void linkQuestGroups(@MappingTarget QuestBase questBase) {
        questBase.getQuestGroups().forEach(questGroup -> questGroup.setQuestBaseID(questBase));
    }

    QuestBaseDto toDto(QuestBase questBase);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    QuestBase partialUpdate(QuestBaseDto questBaseDto, @MappingTarget QuestBase questBase);
}