package net.javaguides.ems.mapper;

import net.javaguides.ems.dto.DepartmentDto;
import net.javaguides.ems.entity.Department;

public class DepartmentMapper {
    public static DepartmentDto mapToDepartmentDto(Department department){
        return new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentCode(),
                department.getDepartmentCity()
        );
    }

    public static Department mapToDepartment(DepartmentDto departmentDto){
        return new Department(
           departmentDto.getId(),
           departmentDto.getDepartmentName(),
           departmentDto.getDepartmentCode(),
           departmentDto.getDepartmentCity()
        );
    }
}
