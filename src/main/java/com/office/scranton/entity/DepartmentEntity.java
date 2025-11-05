package com.office.scranton.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "department")
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer numberOfEmployees;
    @JsonProperty("isArchived")
    private Boolean isArchived;
    @JsonProperty("isActive")
    private Boolean isActive;
    private Integer primeNumber;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
