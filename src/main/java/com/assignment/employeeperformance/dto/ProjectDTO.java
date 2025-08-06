package com.assignment.employeeperformance.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProjectDTO {
    private Long id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private String role;
}
