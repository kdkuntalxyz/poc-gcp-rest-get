package com.deep.poc.rest.controller;

import com.deep.poc.rest.data.Employee;
import com.deep.poc.rest.service.EmployeeService;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Log4j2
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") String id) {
        log.info("inside getEmployeeById controller");
        ResponseEntity<Employee> responseEntity = employeeService.findById(id);
        log.info("invoking rest call done");

        if (responseEntity.getStatusCode()== HttpStatus.OK) {
            return new ResponseEntity<>(responseEntity.getBody(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(responseEntity.getStatusCode());
        }
    }
}
