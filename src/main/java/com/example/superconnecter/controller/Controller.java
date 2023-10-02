package com.example.superconnecter.controller;


import com.example.superconnecter.service.Services;
import com.example.superconnecter.tables.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.ldap.Control;
import java.util.List;

@RestController
@RequestMapping("/basicPath")
public class Controller {

    @Autowired
    private final Services services;

    public Controller (Services services) {
        this.services = services;
    }


    @GetMapping("/inPath")
    public ResponseEntity <List <Employee>> hammaHaridorlar() {
        return services.getAllEmployees();
    }

    @GetMapping("/inPath/{ids}")
    public ResponseEntity <Employee> idBilanOlish(@PathVariable long ids) {
        return services.getByIdEmployee(ids);
    }

    @PostMapping("/inPath")
    public String mijozlarniSaqlash (@RequestBody Employee employee) {
        return services.saveEmployees(employee);
    }


    @PutMapping("/inPath/{ids}")
    public String mijozniUzgartirish(@PathVariable long ids, @RequestBody Employee employee) {
        return services.updateEmployee(ids, employee);
    }

    @DeleteMapping("/inPath/{ids}")
    public String mijozniUchirish(@PathVariable long ids) {
        return services.deleteEmployee(ids);
    }

    @DeleteMapping("/inPath")
    public String hammaMijozniUchirish() {
        return services.deleteAllEmployees();
    }
}
