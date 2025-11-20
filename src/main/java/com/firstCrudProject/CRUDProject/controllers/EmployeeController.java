package com.firstCrudProject.CRUDProject.controllers;

import com.firstCrudProject.CRUDProject.dto.EmployeeDTO;
import com.firstCrudProject.CRUDProject.entity.Employee;
import com.firstCrudProject.CRUDProject.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public List<EmployeeDTO> save(@RequestBody @Valid List<EmployeeDTO> emp) {
        return employeeService.saveData(emp);
    }

    @GetMapping
    public List<EmployeeDTO> findData() {
        return employeeService.getData();
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        return employeeService.deleteById(id);
    }

    @PutMapping("/{empId}")
    public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO emp, @PathVariable Long empId) {
        return employeeService.updateData(empId,emp);
    }

}
