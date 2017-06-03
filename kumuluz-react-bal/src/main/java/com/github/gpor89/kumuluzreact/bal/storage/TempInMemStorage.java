package com.github.gpor89.kumuluzreact.bal.storage;

import com.github.gpor89.kumuluzreact.api.model.Employee;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by gregor on 15/05/2017.
 */
public class TempInMemStorage {

    private static final Map<Long, Employee> EMPLOYEES = new ConcurrentHashMap<>();
    private static Long SEQUENCE = 1L;

    static {
        Employee e1 = new Employee();
        e1.setFirstName("John");
        e1.setLastName("Doe");

        Employee e2 = new Employee();
        e2.setFirstName("Lena");
        e2.setLastName("Söderberg");

        Employee e3 = new Employee();
        e3.setFirstName("Merlyn");
        e3.setLastName("Monroe");

        Employee e4 = new Employee();
        e4.setFirstName("John");
        e4.setLastName("Smith");

        Employee e5 = new Employee();
        e5.setFirstName("Peter");
        e5.setLastName("Doe");

        Employee e6 = new Employee();
        e6.setFirstName("Jack");
        e6.setLastName("Monroe");

        Employee e7 = new Employee();
        e7.setFirstName("Adolph");
        e7.setLastName("Black");

        addToMap(e1);
        addToMap(e2);
        addToMap(e3);
        addToMap(e4);
        addToMap(e5);
        addToMap(e6);
        addToMap(e7);

    }

    private static Object all;

    private static synchronized Long next() {
        return SEQUENCE++;
    }

    public static Employee addToMap(Employee employee) {

        final Long id = next();
        employee.setId(id);

        EMPLOYEES.put(id, employee);

        return employee;
    }

    public static Employee updateToMap(Employee employee) {

        if (null == employee.getId()) {
            throw new RuntimeException("Employee not found");
        }

        EMPLOYEES.put(employee.getId(), employee);

        return employee;
    }

    public static Employee get(Long employeeId) {
        return EMPLOYEES.get(employeeId);
    }

    public static void delete(Long employeeId) {
        EMPLOYEES.remove(employeeId);
    }

    public static List<Employee> getAll() {
        return new LinkedList<>(EMPLOYEES.values());
    }
}
