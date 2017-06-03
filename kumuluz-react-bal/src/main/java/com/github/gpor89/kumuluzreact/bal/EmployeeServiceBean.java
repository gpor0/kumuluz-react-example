package com.github.gpor89.kumuluzreact.bal;

import com.github.gpor89.kumuluzreact.api.model.Employee;
import com.github.gpor89.kumuluzreact.api.service.EmployeeService;
import com.github.gpor89.kumuluzreact.bal.storage.TempInMemStorage;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

/**
 * Created by gregor on 14/05/2017.
 */
@ApplicationScoped
public class EmployeeServiceBean implements EmployeeService {

    @Override
    public List<Employee> getAll() {

        return com.github.gpor89.kumuluzreact.bal.storage.TempInMemStorage.getAll();
    }

    @Override
    public List<Employee> getByPage(Integer page, Integer pageSize) {

        List<Employee> all = getAll();

        if (page == null || pageSize == null) {
            return all;
        }

        int from = (page - 1) * pageSize > 0 ? (page - 1) * pageSize : 0;
        int to = page * pageSize > all.size() ? all.size() : page * pageSize;

        return all.subList(from, to);
    }

    @Override
    public Employee getById(Long employeeId) {

        return TempInMemStorage.get(employeeId);
    }

    @Override
    public Employee create(Employee employee) {

        Employee created = TempInMemStorage.addToMap(employee);

        return created;
    }

    @Override
    public Employee update(Employee employee) {

        Employee updated = TempInMemStorage.updateToMap(employee);

        return updated;
    }

    @Override
    public void delete(Long employeeId) {
        TempInMemStorage.delete(employeeId);
    }

}
