package com.assignment.employeeperformance.dto;

import com.assignment.employeeperformance.model.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long id;
    private String name;
    private String email;
    private DepartmentDTO department;
    private LocalDate dateOfJoining;
    private Double salary;
    private Long managerId;
    private List<PerformanceReviewDTO> performanceReviews;
    private List<ProjectDTO> projects;
}
