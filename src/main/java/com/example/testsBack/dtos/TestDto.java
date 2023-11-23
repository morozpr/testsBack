package com.example.testsBack.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.testsBack.entities.Test}
 */
@Value
@AllArgsConstructor
public class TestDto implements Serializable {
    Long id;
    @NotNull
    String name;
    String description;
    DisciplineDto disciplineID;
    String link;
}