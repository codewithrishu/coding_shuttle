package com.example.springbootMVCWeek2.springbootMVCWeek2.dto;

import com.example.springbootMVCWeek2.springbootMVCWeek2.annotations.EmployeeRoleValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private Long id;

    @NotNull(message = "Required Field: name is missing")
    private String name;

    @Email
    private String email;

    private Integer age;
    private LocalDate dateOfJoinig;

    @JsonProperty("isActive")
    private Boolean isActive;

   // @Pattern(regexp = "^(USER|ADMIN)$")
    @EmployeeRoleValidation
    private String role;




}
