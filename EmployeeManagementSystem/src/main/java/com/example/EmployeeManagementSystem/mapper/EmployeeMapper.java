package com.example.EmployeeManagementSystem.mapper;

import com.example.EmployeeManagementSystem.dto.EmployeeDTO;
import com.example.EmployeeManagementSystem.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDTO JPAmaptoEmployeeDTO(Employee employee)
    {
        return new EmployeeDTO(
          employee.getId(),
          employee.getFirstname(),
          employee.getLastname(),
          employee.getEmail()
        );
    }

    public static  Employee EmployeeDTOmaptoEmployeeJPA(EmployeeDTO employeeDTO)
    {
        return new Employee(
                employeeDTO.getId(),
                employeeDTO.getFirstname(),
                employeeDTO.getLastname(),
                employeeDTO.getEmail()
        );
    }
}
