package com.javaproject.javaspring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaproject.javaspring.models.Employee;

@Repository
/**
 * <p> This is a repository interface that is used to access the database </p>
 */
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    
}
