package com.office.scranton.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.office.scranton.annotation.PrimeNumberValidation;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
    private Long id;

    @NotBlank(message = "Department title cannot be blank")
    @Size(min = 1, max = 10, message = "Department name should be min 1 char and max 10 char long")
    private String title;

    @NotNull(message = "Prime number cannot be null")
    @PrimeNumberValidation
    private Integer primeNumber;

    @NotNull(message = "Number of employees in the department cannot be blank")
    @PositiveOrZero(message = "Number of employees in the department cannot be a negative number")
    private Integer numberOfEmployees;

    @AssertTrue(message = "Department should be active")
    @JsonProperty("isActive")
    private Boolean isActive;

    @AssertFalse(message = "Department cannot be archived upon creation")
    private Boolean isArchived;

    @PastOrPresent(message = "Department cannot be created for a future date")
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
