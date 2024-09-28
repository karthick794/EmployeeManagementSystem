package com.example.EmployeeManagementSystem.controller;

import com.example.EmployeeManagementSystem.dto.EmployeeDTO;
import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.service.Impl.EmployeeServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    public EmployeeServiceImpl employeeService;

    @PostMapping()
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO savedemployeeDTO = employeeService.createEmployee(employeeDTO);
        return new ResponseEntity<>(savedemployeeDTO, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{employeeID}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable  Long employeeID) {
        EmployeeDTO getemployeeDTO = employeeService.getEmployee(employeeID);
        return ResponseEntity.ok(getemployeeDTO);
    }

    @GetMapping()
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee() {
        List<EmployeeDTO> employeeDTOList = employeeService.getAllEmployee();
        return ResponseEntity.ok(employeeDTOList);
    }

    @PutMapping(params = "employeeID")
    public ResponseEntity<EmployeeDTO> updateEmployee(@RequestParam Long employeeID,@RequestBody EmployeeDTO employeeDTO) {
       EmployeeDTO employeeDTOList= employeeService.updateEmployeeDetails(employeeID,employeeDTO);
        return ResponseEntity.ok(employeeDTOList);
    }

    @DeleteMapping(params = "employeeID")
    public ResponseEntity updateEmployee(@RequestParam Long employeeID) {
       employeeService.deleteEmployee(employeeID);
        return ResponseEntity.ok("Employeedetails delete successfully");
    }
}
