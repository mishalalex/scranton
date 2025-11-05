package com.office.scranton.service;

import com.office.scranton.dto.DepartmentDTO;
import com.office.scranton.entity.DepartmentEntity;
import com.office.scranton.exception.ResourceNotFoundException;
import com.office.scranton.repository.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    public List<DepartmentDTO> getAllDepartments() {
        List<DepartmentEntity> allDepartments = departmentRepository.findAll();
        return allDepartments
                .stream()
                .map(department -> modelMapper.map(department, DepartmentDTO.class))
                .collect(Collectors.toList());

    }

    public DepartmentDTO getDepartmentById(Long id) {
        doesDepartmentExist(id);
        DepartmentEntity departmentEntity = departmentRepository.findById(id).get();
        return modelMapper.map(departmentEntity, DepartmentDTO.class);
    }

    public DepartmentDTO createNewDepartment(DepartmentDTO newDepartmentDto) {
        DepartmentEntity newDepartmentEntity = modelMapper.map(newDepartmentDto, DepartmentEntity.class);
        return modelMapper.map(departmentRepository.save(newDepartmentEntity), DepartmentDTO.class);
    }

    public DepartmentDTO updateDepartmentById(Long id, DepartmentDTO newDepartmentDto) {
        doesDepartmentExist(id);
        DepartmentEntity departmentEntity = modelMapper.map(newDepartmentDto, DepartmentEntity.class);
        departmentEntity.setId(id);
        return modelMapper.map(departmentRepository.save(departmentEntity), DepartmentDTO.class);
    }

    public void deleteDepartmentById(Long id) {
        doesDepartmentExist(id);
        departmentRepository.deleteById(id);
    }

    public void doesDepartmentExist(Long id) {
        if(!departmentRepository.existsById(id)) throw new ResourceNotFoundException("Department with id " + id + " does not exist");
    }
}
