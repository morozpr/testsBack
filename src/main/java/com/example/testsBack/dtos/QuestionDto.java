package com.example.testsBack.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link com.example.testsBack.entities.Question}
 */
@Value
public class QuestionDto implements Serializable {
    @NotNull
    String questionText;
    String correctComment;
    String incorrectComment;
    @NotNull
    QuestTypeDto questTypeID;
    @NotNull
    Float score;
    Set<AnswerDto> answers;
}