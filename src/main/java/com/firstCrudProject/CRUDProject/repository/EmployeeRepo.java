package com.firstCrudProject.CRUDProject.repository;

import com.firstCrudProject.CRUDProject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {

    List<Employee> findTop5HighestPaidEmp(Long salary);
}
