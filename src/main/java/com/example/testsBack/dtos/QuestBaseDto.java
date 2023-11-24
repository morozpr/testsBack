package com.example.testsBack.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link com.example.testsBack.entities.QuestBase}
 */
@Value
public class QuestBaseDto implements Serializable {
    @NotNull
    DisciplineDto disciplineID;
    @NotNull
    String questBaseName;
    Set<QuestGroupDto> questGroups;
}