package com.example.testsBack.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.testsBack.entities.TestResult}
 */
@Value
public class TestResultDto implements Serializable {
    String correctPercent;
    String skippedPercent;
    @NotNull
    TestDto testID;
    @NotNull
    UserDto userID;
    @NotNull
    TestResultUserAnswerDto testResultUserAnswerID;
}