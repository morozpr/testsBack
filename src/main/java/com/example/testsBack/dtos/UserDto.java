package com.example.testsBack.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.testsBack.entities.User}
 */
@Value
@AllArgsConstructor
public class UserDto implements Serializable {
    @NotNull
    String fullName;
    String email;
    UniversityDto universityID;
    String telegramLogin;
    String phoneNumber;
    @NotNull
    RoleDto roleID;
    StudentsGroupDto studentsGroupID;

}