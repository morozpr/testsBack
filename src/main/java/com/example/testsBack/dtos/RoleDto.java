package com.example.testsBack.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.testsBack.entities.Role}
 */
@Value
@AllArgsConstructor
public class RoleDto implements Serializable {
    Long id;
    @NotNull
    String roleName;
}