package com.fullstack.controller;

import com.fullstack.dto.LogInRequest;
import com.fullstack.entity.Employee;
import com.fullstack.service.EmployeeService;
import com.fullstack.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
@Slf4j
public class EmployeeController {

    private final IEmployeeService employeeService;

    @PostMapping("/signup")
    public ResponseEntity<Employee> signUp(@RequestBody Employee employee) {

        log.info("@@@@@@@@@Trying to signup for Employee: " + employee.getEmpName());
        return new ResponseEntity<>(employeeService.signUp(employee), HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public ResponseEntity<Boolean> signIn(@RequestBody LogInRequest logInRequest) {

        return new ResponseEntity<>(employeeService.signIn(logInRequest.empEmailId(), logInRequest.empPassword()), HttpStatus.OK);
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Employee>> findAll() {

        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }
}
