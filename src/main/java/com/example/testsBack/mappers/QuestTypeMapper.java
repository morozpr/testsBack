package com.example.testsBack.mappers;

import com.example.testsBack.dtos.QuestTypeDto;
import com.example.testsBack.entities.QuestType;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface QuestTypeMapper {
    QuestType toEntity(QuestTypeDto questTypeDto);

    QuestTypeDto toDto(QuestType questType);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    QuestType partialUpdate(QuestTypeDto questTypeDto, @MappingTarget QuestType questType);
}