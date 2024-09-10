package com.example.EmployeeManagementSystem.service;

import com.example.EmployeeManagementSystem.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO getEmployee(Long employeeid);
    List<EmployeeDTO> getAllEmployee();

    EmployeeDTO updateEmployeeDetails(Long employeeid, EmployeeDTO employeeDTO);
    void deleteEmployee(Long employeeid);
}
