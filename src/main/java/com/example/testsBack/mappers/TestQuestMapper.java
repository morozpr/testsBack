package com.example.testsBack.mappers;

import com.example.testsBack.dtos.TestQuestDto;
import com.example.testsBack.entities.TestQuest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {QuestionMapper.class, TestMapper.class})
public interface TestQuestMapper {
    TestQuest toEntity(TestQuestDto testQuestDto);

    TestQuestDto toDto(TestQuest testQuest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TestQuest partialUpdate(TestQuestDto testQuestDto, @MappingTarget TestQuest testQuest);
}