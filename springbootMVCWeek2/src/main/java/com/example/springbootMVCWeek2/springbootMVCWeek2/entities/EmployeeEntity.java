package com.example.springbootMVCWeek2.springbootMVCWeek2.entities;


import com.example.springbootMVCWeek2.springbootMVCWeek2.annotations.EmployeeRoleValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDate;


@Entity
@Table(name = "employees")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Email
    private String email;
    private Integer age;
    private LocalDate dateOfJoinig;

    @JsonProperty("isActive")
    private Boolean isActive;

    @EmployeeRoleValidation
    private String role;

    }
