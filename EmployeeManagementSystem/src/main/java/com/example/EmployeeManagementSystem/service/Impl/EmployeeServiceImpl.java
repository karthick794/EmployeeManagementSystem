package com.example.EmployeeManagementSystem.service.Impl;

import com.example.EmployeeManagementSystem.dto.EmployeeDTO;
import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.mapper.EmployeeMapper;
import com.example.EmployeeManagementSystem.repo.EmployeeRepository;
import com.example.EmployeeManagementSystem.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee= EmployeeMapper.EmployeeDTOmaptoEmployeeJPA(employeeDTO);
        Employee savedEmployee= employeeRepository.save(employee);
        return EmployeeMapper.JPAmaptoEmployeeDTO(savedEmployee);
    }
}
