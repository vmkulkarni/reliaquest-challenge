package com.example.rqchallenge.repository;

import com.example.rqchallenge.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * This is a employee repository from which we make actual calls to Model
 * @author Varun Kulkarni
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByName(String name);

    @Query("SELECT max(salary) FROM Employee ")
    int getHighestSalaryOfEmployees();

    @Query(nativeQuery = true, value = "SELECT * FROM Employee ORDER BY salary DESC LIMIT 10")
    List<Employee> findAllByOrderBySalaryDesc();

}
