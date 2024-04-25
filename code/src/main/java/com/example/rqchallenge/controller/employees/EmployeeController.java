package com.example.rqchallenge.controller.employees;

import com.example.rqchallenge.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

/**
 * This is the Employee controller
 * All methods declared here
 * @author Varun Kulkarni
 */
@RestController
@RequestMapping
public interface EmployeeController {

    @GetMapping("/employees")
    ResponseEntity<Map<String, Object>> getAllEmployees() throws Exception;

    @GetMapping("/search/{searchString}")
    ResponseEntity<Map<String, Object>> getEmployeesByNameSearch(@PathVariable String searchString) throws Exception;

    @GetMapping("/{id}")
    ResponseEntity<Map<String, Object>> getEmployeeById(@PathVariable Integer id) throws Exception;

    @GetMapping("/highestSalary")
    ResponseEntity<Map<String, Object>> getHighestSalaryOfEmployees() throws Exception;

    @GetMapping("/topTenHighestEarningEmployees")
    ResponseEntity<Map<String, Object>> getTopTenHighestEarningEmployees() throws Exception;

    @PostMapping("/employees")
    ResponseEntity<Map<String, Object>> createEmployee(@RequestBody Employee employeeInput) throws Exception;

    @DeleteMapping("/{id}")
    ResponseEntity<Integer> deleteEmployeeById(@PathVariable Integer id) throws Exception;

}
