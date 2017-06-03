package com.github.gpor89.kumuluzreact.api.service;

import com.github.gpor89.kumuluzreact.api.model.Employee;

import java.util.List;

/**
 * Created by gregor on 14/05/2017.
 */
public interface EmployeeService {

    List<Employee> getAll();

    List<Employee> getByPage(Integer page, Integer pageSize);

    Employee getById(Long employeeId);

    Employee create(Employee employee);

    Employee update(Employee employee);

    void delete(Long employeeId);

}
