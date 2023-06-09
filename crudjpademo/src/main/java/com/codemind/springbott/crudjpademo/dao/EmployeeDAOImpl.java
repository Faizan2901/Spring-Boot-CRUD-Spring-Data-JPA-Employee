package com.codemind.springbott.crudjpademo.dao;

import com.codemind.springbott.crudjpademo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getAllEmployee() {
        TypedQuery<Employee> myQuery=entityManager.createQuery("FROM Employee",Employee.class);
        return myQuery.getResultList();
    }

    @Override
    public Employee findById(Integer id) {
        Employee myEmployee=entityManager.find(Employee.class,id);
        return myEmployee;
    }

    @Override
    public Employee save(Employee employee) {
        Employee dbEmployee=entityManager.merge(employee);
        return dbEmployee;
    }

    @Override
    public void deleteById(Integer id) {
        Employee employee=entityManager.find(Employee.class,id);
        entityManager.remove(employee);
    }

}
