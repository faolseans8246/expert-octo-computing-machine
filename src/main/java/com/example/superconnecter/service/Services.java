package com.example.superconnecter.service;

import com.example.superconnecter.tables.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface Services {

    public ResponseEntity <List<Employee>> getAllEmployees();

    public ResponseEntity <Employee>  getByIdEmployee(long ids);

    public String saveEmployees(Employee employee);

    public String updateEmployee(long ids, Employee employee);

    public String deleteEmployee(long ids);

    public String deleteAllEmployees();

}
