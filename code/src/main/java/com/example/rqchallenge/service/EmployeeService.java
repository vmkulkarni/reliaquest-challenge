package com.example.rqchallenge.service;

import com.example.rqchallenge.model.Employee;
import com.example.rqchallenge.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * This is a service class to make the calls to repository
 * @author Varun Kulkarni
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public List<Employee> getEmployeesByName(String name) {
        return employeeRepository.findByName(name);
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public int getHighestSalaryOfEmployees() {
        return employeeRepository.getHighestSalaryOfEmployees();
    }

    public List<Employee> getTopTenHighestEarningEmployees() {
        return employeeRepository.findAllByOrderBySalaryDesc();
    }

    public void deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
    }


}
