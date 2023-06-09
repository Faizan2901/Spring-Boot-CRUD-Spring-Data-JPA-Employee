package com.codemind.springbott.crudjpademo.rest;

import com.codemind.springbott.crudjpademo.entity.Employee;
import com.codemind.springbott.crudjpademo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {


    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findByEmployeeId(@PathVariable Integer employeeId){
        Employee myEmployee=employeeService.findById(employeeId);

        if (myEmployee == null){
            throw new RuntimeException("Employee id not found - "+employeeId);
        }
        return myEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){

        // also just in case they pass an id in json ... set id to 0
        // this is to force a save of new item ... instead of update

        employee.setId(0);

        Employee dbEmployee=employeeService.save(employee);

        return dbEmployee;

    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){

        Employee dbEmployee=employeeService.save(employee);
        return  dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable Integer employeeId){
        Employee tempEmployee=employeeService.findById(employeeId);

        if (tempEmployee == null){
            throw new RuntimeException("Employee id not found - "+employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Delete Employee Id - "+employeeId;
    }
}
