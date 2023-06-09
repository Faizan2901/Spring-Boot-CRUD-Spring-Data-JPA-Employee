package com.codemind.springbott.crudjpademo.service;

import com.codemind.springbott.crudjpademo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee findById(Integer id);

    Employee save(Employee employee);

    void deleteById(Integer id);
}
