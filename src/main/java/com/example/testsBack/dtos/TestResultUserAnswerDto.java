package com.example.testsBack.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link com.example.testsBack.entities.TestResultUserAnswer}
 */
@Value
public class TestResultUserAnswerDto implements Serializable {
    @NotNull
    UserAnswerDto userAnswerID;
    @NotNull
    TestResultDto testResultID;
    Set<TestResultDto> testResults;
}