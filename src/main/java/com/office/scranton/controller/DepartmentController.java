package com.office.scranton.controller;

import com.office.scranton.dto.DepartmentDTO;
import com.office.scranton.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments() {
        return new ResponseEntity<>(departmentService.getAllDepartments(), HttpStatus.OK);
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable(name = "departmentId") Long id) {
        return new ResponseEntity<>(departmentService.getDepartmentById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody @Valid DepartmentDTO newDepartmentDto) {
        return new ResponseEntity<>(departmentService.createNewDepartment(newDepartmentDto), HttpStatus.CREATED);
    }

    @PutMapping("/{departmentId}")
    public ResponseEntity<DepartmentDTO> updateDepartmentById(@RequestBody @Valid DepartmentDTO departmentDtoToBeUpdated, @PathVariable(name = "departmentId") Long id) {
        return new ResponseEntity<>(departmentService.updateDepartmentById(id,departmentDtoToBeUpdated), HttpStatus.OK);
    }

    @DeleteMapping("/{departmentId}")
    public ResponseEntity<HttpStatus> deleteDepartmentById(@PathVariable(name = "departmentId") Long id) {
        departmentService.deleteDepartmentById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
