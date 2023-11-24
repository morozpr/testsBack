package com.example.testsBack.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.testsBack.entities.Answer}
 */
@Value
public class AnswerDto implements Serializable {
    @NotNull
    String answerValue;
    @NotNull
    Boolean isRight;
}