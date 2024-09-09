package com.example.EmployeeManagementSystem.controller;

import com.example.EmployeeManagementSystem.dto.EmployeeDTO;
import com.example.EmployeeManagementSystem.service.Impl.EmployeeServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    public EmployeeServiceImpl employeeService;
    @PostMapping(path = "/createEmployee")
    public ResponseEntity<EmployeeDTO>createEmployee(@RequestBody EmployeeDTO employeeDTO)
    {
        EmployeeDTO savedemployeeDTO=employeeService.createEmployee(employeeDTO);
        return new ResponseEntity<>(savedemployeeDTO, HttpStatus.CREATED);
    }
}
