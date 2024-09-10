package com.example.EmployeeManagementSystem.mapper;

import com.example.EmployeeManagementSystem.dto.EmployeeDTO;
import com.example.EmployeeManagementSystem.entity.Employee;
import org.modelmapper.ModelMapper;

public class EmployeeMapper {
    private static ModelMapper modelMapper = new ModelMapper();
    public static EmployeeDTO JPAmaptoEmployeeDTO(Employee employee)
    {
        return modelMapper.map(employee,EmployeeDTO.class);    //Automatically mapping
        /*return new EmployeeDTO(                //Manually mapping
          employee.getId(),
          employee.getFirstname(),
          employee.getLastname(),
          employee.getEmail()
        );*/
    }

    public static  Employee EmployeeDTOmaptoEmployeeJPA(EmployeeDTO employeeDTO)
    {
        return modelMapper.map(employeeDTO,Employee.class);     //Automatically mapping
       /* return new Employee(
                employeeDTO.getId(),
                employeeDTO.getFirstname(),
                employeeDTO.getLastname(),
                employeeDTO.getEmail()
        );*/
    }
}
