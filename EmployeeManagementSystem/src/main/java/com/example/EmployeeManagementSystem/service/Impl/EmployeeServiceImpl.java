package com.example.EmployeeManagementSystem.service.Impl;

import com.example.EmployeeManagementSystem.Exception.ResourceNotFoundException;
import com.example.EmployeeManagementSystem.dto.EmployeeDTO;
import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.mapper.EmployeeMapper;
import com.example.EmployeeManagementSystem.repo.EmployeeRepository;
import com.example.EmployeeManagementSystem.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public EmployeeDTO getEmployee(Long employeeid) {
        Employee employee=employeeRepository.findById(employeeid)
                .orElseThrow(()->new ResourceNotFoundException("Employee not exist given id"));
        return EmployeeMapper.JPAmaptoEmployeeDTO(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        List<Employee> employees=employeeRepository.findAll();
        return employees.stream()
                .map(EmployeeMapper::JPAmaptoEmployeeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO updateEmployeeDetails(Long employeeid, EmployeeDTO updatedEmployeeDTO) {
        Employee employee=employeeRepository.findById(employeeid)
                .orElseThrow(()->new ResourceNotFoundException("Employee not exist by given id "+employeeid));
        employee.setFirstname(updatedEmployeeDTO.getFirstname());
        employee.setLastname(updatedEmployeeDTO.getLastname());
        employee.setEmail(updatedEmployeeDTO.getEmail());
        Employee updatesemployee=employeeRepository.save(employee);
        return EmployeeMapper.JPAmaptoEmployeeDTO(updatesemployee);
    }

    @Override
    public void deleteEmployee(Long employeeid) {
        Employee employee=employeeRepository.findById(employeeid)
                .orElseThrow(()->new ResourceNotFoundException("Employee not exist by given id "+employeeid));
        employeeRepository.deleteById(employeeid);
    }
}
