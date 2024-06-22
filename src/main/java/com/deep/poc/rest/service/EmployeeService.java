package com.deep.poc.rest.service;

import com.deep.poc.rest.data.Employee;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Log4j2
public class EmployeeService {

    @Autowired
    RestTemplate restTemplate;

    public ResponseEntity<Employee> findById(String id) {
        log.info("inside getEmployeeById service");
        ResponseEntity<Employee> responseEntity = restTemplate.exchange("https://dummy.restapiexample.com/api/v1/employee/"+id, HttpMethod.GET, null, Employee.class);
        log.info("Employee {}", responseEntity.getBody().toString());
        return responseEntity;
    }

}
