package com.javaproject.javaspring.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaproject.javaspring.models.Employee;
import com.javaproject.javaspring.service.EmployeeService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/employee")
/**
 * Controller class for Employee entity. This controller defines the API routes for performing CRUD operations on the Employee entity. 
 */
public class EmployeeController {

    // Logger for logging the events
    private static final Logger logger = LoggerFactory.getLogger(SpringApplication.class);
    
    @Autowired
    // Constructor injection
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    private EmployeeService employeeService;


    // GET method to get all employees from the database
    @GetMapping(value = "/getEmployees")
    public List < Employee > getEmployees() {
        logger.info("Get all employees...");
        return employeeService.getAllEmployees();
    }

    // GET method to get an employee by id from the database
    @GetMapping(value = "/getEmployee/{empId}")
    public Employee getEmployee(@PathVariable int empId) {
        logger.info("Get employee by id...");
        return employeeService.getEmployeeById(empId);
    }

    // POST method to add an employee to the database
    @PostMapping(value="/addEmployee")
    public  ResponseEntity<String> addEmployee(@Validated @NonNull @RequestBody Employee newEmployee) {
        logger.info("Insert employee...");
        employeeService.addEmployee(newEmployee);
        return new ResponseEntity<String>("Employee has successfully been added!", HttpStatus.CREATED);
    }
    
    // PUT method to update an employee by id in the database
    @PutMapping(value="/updateEmployee/{empId}")
    public ResponseEntity<String> updateEmployee(@PathVariable int empId, @Validated @NonNull @RequestBody Employee updateEmployee) {
        logger.info("Update employee by id...");
        employeeService.updateEmployee(empId, updateEmployee);
        return new ResponseEntity<>("Employee with id " + empId +" has been updated", HttpStatus.OK);
    }

    // DELETE method to delete an employee by id from the database
    @DeleteMapping(value="/deleteEmployee/{empId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int empId) {
        logger.info("Delete employee by id...");
        employeeService.deleteEmployee(empId);
        return new ResponseEntity<String>("Employee with id " + empId + " has been deleted", HttpStatus.OK);
    }

}
