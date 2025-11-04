package com.office.scranton.controller;

import com.office.scranton.dto.EmployeeDTO;
import com.office.scranton.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employee) {
        return employeeService.createNewEmployee(employee);
    }

    @GetMapping(path = "/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable Long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @PutMapping(path = "/{employeeId}")
    public String updateEmployeeById(@PathVariable Long employeeId, @RequestBody EmployeeDTO employeeDto) {
        return "Updated Employee";
    }

    @DeleteMapping(path = "/{employeeId}")
    public String deleteEmployeeById(@PathVariable Long employeeId) {
        return "Deleted Employee";
    }
}
