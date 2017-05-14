package com.github.gpor89.kumuluzreact.rest.impl;

import com.github.gpor89.kumuluzreact.api.model.Employee;
import com.github.gpor89.kumuluzreact.api.service.EmployeeService;
import com.github.gpor89.kumuluzreact.rest.ResourceEmployee;
import com.github.gpor89.kumuluzreact.rest.model.EmployeeJson;
import com.kumuluz.ee.logs.LogManager;
import com.kumuluz.ee.logs.Logger;
import com.kumuluz.ee.logs.cdi.Log;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by gregor on 14/05/2017.
 */

@Log
@RequestScoped
public class ResourceEmployeeImpl implements ResourceEmployee {

    private static final Logger LOG = LogManager.getLogger(ResourceEmployeeImpl.class.getName());

    @Inject
    private EmployeeService employeeService;

    @Override
    public Response getAllEmployees(Integer page, Integer pageSize) {

        List<EmployeeJson> result = new LinkedList<>();

        final List<Employee> all = employeeService.getByPage(page, pageSize);

        for(Employee e : all) {
            result.add(new EmployeeJson(e));
        }

        return Response.ok(result).build();
    }

    @Override
    public Response getEmployeeById(Long employeeId) {

        final Employee employee = employeeService.getById(employeeId);

        if(employee == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(new EmployeeJson(employee)).build();
    }

    @Override
    public Response createEmployee(EmployeeJson employee) {
        //TODO: implement
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @Override
    public Response updateEmployee(Long employeeId, EmployeeJson employee) {
        //TODO: implement
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @Override
    public Response deleteEmployee(Long employeeId) {
        //TODO: implement
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
