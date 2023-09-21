package net.javaguides.ems.service;

import net.javaguides.ems.dto.DepartmentDto;
import java.util.List;

public interface DepartmentService {
    DepartmentDto createDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentById(Long departmentId);
    List<DepartmentDto> getAllDepartment();

    DepartmentDto updateDepartMent(Long departmentId,DepartmentDto updateDepartment);
    void deleteDepartment(Long departmentid);
}
