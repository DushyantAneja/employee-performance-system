package com.assignment.employeeperformance.repo;

import com.assignment.employeeperformance.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT DISTINCT e FROM Employee e " +
            "LEFT JOIN e.performanceReviews pr " +
            "LEFT JOIN e.employeeProjects ep " +
            "WHERE (:reviewDate IS NULL OR pr.reviewDate = :reviewDate) " +
            "AND (:score IS NULL OR pr.score >= :score) " +
            "AND (:departmentNames IS NULL OR e.department.name IN :departmentNames) " +
            "AND (:projectNames IS NULL OR ep.project.name IN :projectNames)")
    List<Employee> findFilteredEmployees(LocalDate reviewDate, Integer score,
                                         List<String> departmentNames, List<String> projectNames);
}
