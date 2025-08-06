package com.assignment.employeeperformance.controller;

import com.assignment.employeeperformance.dto.EmployeeDTO;
import com.assignment.employeeperformance.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getFilteredEmployees(
            @RequestParam Integer score,
            @RequestParam String reviewDate,
            @RequestParam List<String> departments,
            @RequestParam List<String> projects) {
        return ResponseEntity.ok(employeeService.getFilteredEmployees(score, reviewDate, departments, projects));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeDetails(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeDetails(id));
    }
}
