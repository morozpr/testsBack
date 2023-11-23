package com.example.testsBack.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.testsBack.entities.Discipline}
 */
@Value
public class DisciplineDto implements Serializable {
    Long id;
    @NotNull
    String disciplineName;
}