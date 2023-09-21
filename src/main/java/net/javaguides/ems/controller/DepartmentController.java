package net.javaguides.ems.controller;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.DepartmentDto;
import net.javaguides.ems.entity.Department;
import net.javaguides.ems.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

  private   DepartmentService departmentService;

  //Build add department REST API
    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto saveDepartment =  departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(saveDepartment, HttpStatus.CREATED);
    }
    //get department by id
    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getDepartmentByid(@PathVariable("id") Long departmentId){
      DepartmentDto departmentDto =  departmentService.getDepartmentById(departmentId);
       return ResponseEntity.ok(departmentDto);
    }
    //get all department
    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getallDepartments(){
      List<DepartmentDto> departmentDtos =   departmentService.getAllDepartment();
        return ResponseEntity.ok(departmentDtos);
    }
    @PutMapping("{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("id") Long departmentId,
    @RequestBody DepartmentDto updatedDepartment){
     DepartmentDto departmentDto =  departmentService.updateDepartMent(departmentId,updatedDepartment);
      return ResponseEntity.ok(departmentDto);
    }
    @DeleteMapping("{id}")
  public ResponseEntity<String> deleteDepart(@PathVariable("id") Long departmentId){
      departmentService.deleteDepartment(departmentId);
      return ResponseEntity.ok("Department Deleted successfully");
    }

}
