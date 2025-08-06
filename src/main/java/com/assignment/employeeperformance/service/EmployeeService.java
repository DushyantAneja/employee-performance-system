package com.assignment.employeeperformance.service;

import com.assignment.employeeperformance.dto.EmployeeDTO;
import com.assignment.employeeperformance.mapper.DtoMapper;
import com.assignment.employeeperformance.model.Employee;
import com.assignment.employeeperformance.repo.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DtoMapper dtoMapper;

    public List<EmployeeDTO> getFilteredEmployees(Integer score, String reviewDate,
                                                  List<String> departmentNames, List<String> projectNames) {
        LocalDate parsedReviewDate = reviewDate != null ? LocalDate.parse(reviewDate) : null;

        return employeeRepository.findFilteredEmployees(parsedReviewDate, score, departmentNames, projectNames)
                .stream()
                .map(dtoMapper::convertToDTO)
                .collect(Collectors.toList());
    }

    public EmployeeDTO getEmployeeDetails(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + id));
        return dtoMapper.convertToDTO(employee);
    }
}
