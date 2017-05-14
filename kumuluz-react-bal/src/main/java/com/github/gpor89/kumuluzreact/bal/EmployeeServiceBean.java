package com.github.gpor89.kumuluzreact.bal;

import com.github.gpor89.kumuluzreact.api.model.Employee;
import com.github.gpor89.kumuluzreact.api.service.EmployeeService;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by gregor on 14/05/2017.
 */
@ApplicationScoped
public class EmployeeServiceBean implements EmployeeService {

    private static final Set<Employee> EMPLOYEES = new HashSet<>();

    static {
        Employee e1 = new Employee();
        e1.setId(1L);
        e1.setFirstName("John");
        e1.setLastName("Doe");

        Employee e2 = new Employee();
        e2.setId(2L);
        e2.setFirstName("Lena");
        e2.setLastName("Söderberg");

        Employee e3 = new Employee();
        e3.setId(3L);
        e3.setFirstName("Merlyn");
        e3.setLastName("Monroe");

        Employee e4 = new Employee();
        e4.setId(4L);
        e4.setFirstName("John");
        e4.setLastName("Smith");

        Employee e5 = new Employee();
        e5.setId(5L);
        e5.setFirstName("Peter");
        e5.setLastName("Doe");

        Employee e6 = new Employee();
        e6.setId(6L);
        e6.setFirstName("Jack");
        e6.setLastName("Monroe");

        Employee e7 = new Employee();
        e7.setId(7L);
        e7.setFirstName("Adolph");
        e7.setLastName("Black");

        EMPLOYEES.add(e1);
        EMPLOYEES.add(e2);
        EMPLOYEES.add(e3);
        EMPLOYEES.add(e4);
        EMPLOYEES.add(e5);
        EMPLOYEES.add(e6);
        EMPLOYEES.add(e7);

    }

    @Override
    public List<Employee> getAll() {

        return new LinkedList<>(EMPLOYEES);
    }

    @Override
    public List<Employee> getByPage(Integer page, Integer pageSize) {

        List<Employee> all = getAll();

        if(page == null || pageSize == null) {
            return all;
        }

        int from = (page - 1) * pageSize > 0 ? (page - 1) * pageSize : 0;
        int to = page * pageSize > all.size() ? all.size() : page * pageSize;

        return all.subList(from, to);
    }

    @Override
    public Employee getById(Long employeeId) {

        for (Employee e : EMPLOYEES) {
            if (e.getId().equals(employeeId)) {
                return e;
            }
        }

        return null;
    }
}
