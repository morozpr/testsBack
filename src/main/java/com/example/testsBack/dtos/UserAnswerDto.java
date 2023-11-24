package com.example.testsBack.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link com.example.testsBack.entities.UserAnswer}
 */
@Value
public class UserAnswerDto implements Serializable {
    @NotNull
    QuestionDto questionID;
    @NotNull
    AnswerDto answerID;
    String userAnswer;
    Instant timestamp;
    @NotNull
    Boolean isSkipped;
    @NotNull
    Boolean isCorrect;
}