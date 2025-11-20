package com.firstCrudProject.CRUDProject.services;

import com.firstCrudProject.CRUDProject.dto.EmployeeDTO;
import com.firstCrudProject.CRUDProject.entity.Employee;
import com.firstCrudProject.CRUDProject.repository.EmployeeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<EmployeeDTO> saveData(List<EmployeeDTO> empDtos) {
        // 1️⃣ Convert List<EmployeeDTO> → List<Employee>
        List<Employee> employees = empDtos.stream()
                .map(dto -> modelMapper.map(dto, Employee.class))
                .toList();

        // 2️⃣ Save all records in one goDD
        List<Employee> savedEmployees = employeeRepo.saveAll(employees);

        // 3️⃣ Convert back List<Employee> → List<EmployeeDTO>
        return savedEmployees.stream()
                .map(emp -> modelMapper.map(emp, EmployeeDTO.class))
                .toList();
    }


    public List<EmployeeDTO> getData() {
        return employeeRepo.findAll()
                .stream()
                .map(emp -> modelMapper.map(emp, EmployeeDTO.class)).collect(Collectors.toList());
    }

    public String deleteById(Long id) {
        employeeRepo.deleteById(id);
        return "Record Deleted Successfully";
    }

    public EmployeeDTO updateData(Long id, EmployeeDTO empDto) {
        Employee employee = employeeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee id not found"));

        // Make sure the DTO id is ignored
        empDto.setEmpId(null);
        modelMapper.map(empDto, employee); // safely copy values
        Employee updated = employeeRepo.save(employee);
        return modelMapper.map(updated, EmployeeDTO.class);
    }

    public List<Employee> findHighestPaidEmp(Long salary){
        if(salary>5000){

        }
        return employeeRepo.findTop5HighestPaidEmp(salary);
    }



}
