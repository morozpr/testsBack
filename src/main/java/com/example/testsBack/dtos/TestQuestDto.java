package com.example.testsBack.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.testsBack.entities.TestQuest}
 */
@Value
public class TestQuestDto implements Serializable {
    @NotNull
    QuestionDto questionID;
    @NotNull
    TestDto testID;
}