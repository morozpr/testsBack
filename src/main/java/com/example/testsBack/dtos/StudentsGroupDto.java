package com.example.testsBack.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.testsBack.entities.StudentsGroup}
 */
@Value
@AllArgsConstructor
public class StudentsGroupDto implements Serializable {
    @NotNull
    String studentsGroupName;
}