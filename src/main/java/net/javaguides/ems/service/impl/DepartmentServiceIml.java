package net.javaguides.ems.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.DepartmentDto;
import net.javaguides.ems.entity.Department;
import net.javaguides.ems.exception.ResourceNotFound;
import net.javaguides.ems.mapper.DepartmentMapper;
import net.javaguides.ems.repository.DepartmentRepository;
import net.javaguides.ems.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class DepartmentServiceIml implements DepartmentService {
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department saveDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(saveDepartment);
    }

    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {
      Department department = departmentRepository.findById(departmentId)
              .orElseThrow(()-> new ResourceNotFound("Resource not found this"+ departmentId));
        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartment() {
       List<Department> departments = departmentRepository.findAll();
        return departments.stream().map((department)->DepartmentMapper.mapToDepartmentDto(department))
                .collect(Collectors.toList()) ;
    }

    @Override
    public DepartmentDto updateDepartMent(Long departmentId, DepartmentDto updateDepartment) {
     Department department = departmentRepository.findById(departmentId)
             .orElseThrow(()->new ResourceNotFound("Resouce not found"+departmentId));
             department.setDepartmentName(updateDepartment.getDepartmentName());
             department.setDepartmentCode(updateDepartment.getDepartmentCode());
             department.setDepartmentCity(updateDepartment.getDepartmentCity());
            Department department1 =  departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(department1);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        departmentRepository.findById(departmentId)
                .orElseThrow(()->new ResourceNotFound("Department not found by"+ departmentId));
        departmentRepository.deleteById(departmentId);
    }
}
