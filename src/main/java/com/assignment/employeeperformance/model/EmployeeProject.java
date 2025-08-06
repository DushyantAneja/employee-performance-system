package com.assignment.employeeperformance.model;

import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "employee_project")
@Data
public class EmployeeProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @NotNull
    private LocalDate assignedDate;

    private String role;
}
