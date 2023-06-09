package com.codemind.springbott.crudjpademo.dao;

import com.codemind.springbott.crudjpademo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

   List<Employee> getAllEmployee();

    Employee findById(Integer id);

    Employee save(Employee employee);

    void deleteById(Integer id);
}
