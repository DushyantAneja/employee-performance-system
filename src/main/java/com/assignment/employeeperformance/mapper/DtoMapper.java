package com.assignment.employeeperformance.mapper;

import com.assignment.employeeperformance.dto.DepartmentDTO;
import com.assignment.employeeperformance.dto.EmployeeDTO;
import com.assignment.employeeperformance.dto.PerformanceReviewDTO;
import com.assignment.employeeperformance.dto.ProjectDTO;
import com.assignment.employeeperformance.model.Employee;
import com.assignment.employeeperformance.model.PerformanceReview;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class DtoMapper {

    private final ModelMapper modelMapper;

    public DtoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO convertToDTO(Employee employee) {
        EmployeeDTO dto = modelMapper.map(employee, EmployeeDTO.class);

        dto.setManagerId(Optional.ofNullable(employee.getManager()).map(m -> m.getId()).orElse(null));

        DepartmentDTO departmentDTO = modelMapper.map(employee.getDepartment(),DepartmentDTO.class);
        dto.setDepartment(departmentDTO);

        if (employee.getEmployeeProjects() != null) {
            List<ProjectDTO> projectDTOs = employee.getEmployeeProjects().stream()
                    .map(ep -> {
                        ProjectDTO projectDTO = modelMapper.map(ep.getProject(), ProjectDTO.class);
                        projectDTO.setRole(ep.getRole());
                        return projectDTO;
                    })
                    .collect(Collectors.toList());
            dto.setProjects(projectDTOs);
        }

        if (employee.getPerformanceReviews() != null) {
            List<PerformanceReviewDTO> top3Reviews = employee.getPerformanceReviews().stream()
                    .sorted(Comparator.comparing(PerformanceReview::getReviewDate).reversed())
                    .limit(3)
                    .map(review -> modelMapper.map(review, PerformanceReviewDTO.class))
                    .collect(Collectors.toList());
            dto.setPerformanceReviews(top3Reviews);
        }

        return dto;
    }
}

