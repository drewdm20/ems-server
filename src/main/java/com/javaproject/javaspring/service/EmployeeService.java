package com.javaproject.javaspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaproject.javaspring.repo.EmployeeRepo;
import com.javaproject.javaspring.models.Employee;

import java.util.List;

@Service
@Transactional
/**
 * <p> This is the Employee Service class which contains the business logic for performing CRUD operations on the Employee entity. </p>
 */
public class EmployeeService {
    
    private final EmployeeRepo employeeRepo;
    
    @Autowired
    // Constructor injection
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    // Method to get all employees from the repository
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    // Method to get individual employee by their id
    public Employee getEmployeeById(int empId) {
        return employeeRepo.findById(empId).orElseThrow(() -> new IllegalStateException("Employee with id " + empId + " does not exist"));
    }

    // Method to add an employee to the database
    public void addEmployee(Employee newEmployee) {
        employeeRepo.save(newEmployee);
    }

    // Method to update an employee from the database
    public void updateEmployee(int empId, Employee updateEmployee) {

        Employee employee = getEmployeeById(empId);
        employee.setEmpName(updateEmployee.getEmpName());
        employee.setEmpLastName(updateEmployee.getEmpLastName());
        employee.setCellNumber(updateEmployee.getCellNumber());
        employee.setEmail(updateEmployee.getEmail());
        employee.setRole(updateEmployee.getRole());
        employee.setSalary(updateEmployee.getSalary());
        employeeRepo.save(employee);
    }

    // Method to delete an employee from the database
    public void deleteEmployee(int empId) {
        employeeRepo.deleteById(empId);
    }
}
