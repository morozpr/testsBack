package com.example.testsBack.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.testsBack.entities.QuestType}
 */
@Value
public class QuestTypeDto implements Serializable {
    @NotNull
    String questTypeName;
}