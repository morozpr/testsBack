package com.example.testsBack.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link com.example.testsBack.entities.QuestGroup}
 */
@Value
public class QuestGroupDto implements Serializable {
    @NotNull
    String questGroupName;
    Set<QuestionDto> questions;
}