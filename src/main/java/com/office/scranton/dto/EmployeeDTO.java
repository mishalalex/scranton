package com.office.scranton.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private Double salary;
    @JsonProperty("isActive")
    private boolean active;
}
