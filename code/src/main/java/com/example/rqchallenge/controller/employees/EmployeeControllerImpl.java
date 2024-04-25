package com.example.rqchallenge.controller.employees;

import com.example.rqchallenge.Static;
import com.example.rqchallenge.Utility.Utils;
import com.example.rqchallenge.model.Employee;
import com.example.rqchallenge.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

/**
 * This is implementation of Employee controller
 * All the request responses are handled here
 * @author Varun Kulkarni
 */
@RestController
public class EmployeeControllerImpl implements EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Override
    public ResponseEntity<Map<String, Object>> getAllEmployees() {
        try {
            if (employeeService.getAllEmployees() == null) {
                return null;
            } else {
                Map<String, Object> response = new HashMap<>();
                response.put("status", "success");
                response.put("data", employeeService.getAllEmployees());
                ResponseEntity.status(HttpStatus.OK);
                return ResponseEntity.accepted().body(response);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

    @Override
    public ResponseEntity<Map<String, Object>> getEmployeesByNameSearch(String searchString) {
        try {
            Map<String, Object> response = new HashMap<>();
            response.put("status", "success");
            response.put("data", employeeService.getEmployeesByName(searchString));
            ResponseEntity.status(HttpStatus.OK);
            return ResponseEntity.accepted().body(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Override
    public ResponseEntity<Map<String, Object>> getEmployeeById(Integer id) {
        try {
            Map<String, Object> response = new HashMap<>();
            response.put("status", "success");
            response.put("data", employeeService.getEmployeeById(id));
            ResponseEntity.status(HttpStatus.OK);
            return ResponseEntity.accepted().body(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Override
    public ResponseEntity<Map<String, Object>> getHighestSalaryOfEmployees() {
        try {
            Map<String, Object> response = new HashMap<>();
            Map<String, Integer> salaryResponse = new HashMap<>();
            salaryResponse.put("highestSalary", employeeService.getHighestSalaryOfEmployees());
            response.put("data", salaryResponse);
            response.put("status", "success");
            ResponseEntity.status(HttpStatus.OK);
            return ResponseEntity.accepted().body(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Override
    public ResponseEntity<Map<String, Object>> getTopTenHighestEarningEmployees() {
        try {
            Map<String, Object> response = new HashMap<>();
            response.put("status", "success");
            response.put("data", employeeService.getTopTenHighestEarningEmployees());
            ResponseEntity.status(HttpStatus.OK);
            return ResponseEntity.accepted().body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Override
    public ResponseEntity<Map<String, Object>> createEmployee(Employee employeeInput) {
        try {
            if (Utils.patternMatches(employeeInput.getEmail(), Static.EMAIL_REGEX)) {
                Map<String, Object> response = new HashMap<>();
                response.put("status", "success");
                response.put("data", employeeService.saveEmployee(employeeInput));
                ResponseEntity.status(HttpStatus.OK);
                return ResponseEntity.accepted().body(response);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Override
    public ResponseEntity<Integer> deleteEmployeeById(Integer id) {
        try {
            employeeService.deleteEmployeeById(id);
            return ResponseEntity.accepted().body(id);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
