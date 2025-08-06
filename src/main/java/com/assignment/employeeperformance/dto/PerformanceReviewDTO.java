package com.assignment.employeeperformance.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class PerformanceReviewDTO {
    private Long id;
    private LocalDate reviewDate;
    private Integer score;
    private String reviewComments;
}
