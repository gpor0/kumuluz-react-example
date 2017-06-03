package com.github.gpor89.kumuluzreact.rest.impl;

import com.github.gpor89.kumuluzreact.api.model.Employee;
import com.github.gpor89.kumuluzreact.api.service.EmployeeService;
import com.github.gpor89.kumuluzreact.rest.ResourceEmployee;
import com.github.gpor89.kumuluzreact.rest.model.EmployeeJson;
import com.github.gpor89.kumuluzreact.rest.util.RestUtil;
import com.kumuluz.ee.logs.LogManager;
import com.kumuluz.ee.logs.Logger;
import com.kumuluz.ee.logs.cdi.Log;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by gregor on 14/05/2017.
 */

@Log
@RequestScoped
public class ResourceEmployeeImpl implements ResourceEmployee {

    private static final Logger LOG = LogManager.getLogger(ResourceEmployeeImpl.class.getName());

    @Context
    private UriInfo uri;

    @Inject
    private EmployeeService employeeService;

    @Override
    public Response getAllEmployees(Integer page, Integer pageSize) {

        List<EmployeeJson> result = new LinkedList<>();

        final List<Employee> all = employeeService.getByPage(page, pageSize);

        for (Employee e : all) {
            result.add(new EmployeeJson(e));
        }

        return Response.ok(result).build();
    }

    @Override
    public Response getEmployeeById(Long employeeId) {

        final Employee employee = employeeService.getById(employeeId);

        if (employee == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(new EmployeeJson(employee)).build();
    }

    @Override
    public Response createEmployee(final EmployeeJson employee) {

        final Employee e = employeeService.create(employee.toEmployee());

        final EmployeeJson result = new EmployeeJson(e);

        return Response.created(RestUtil.buildCreatedLink(uri, e)).entity(result).build();
    }

    @Override
    public Response updateEmployee(Long employeeId, EmployeeJson employee) {

        employee.setId(employeeId);

        final Employee e = employeeService.update(employee.toEmployee());

        final EmployeeJson result = new EmployeeJson(e);

        return Response.created(RestUtil.buildCreatedLink(uri, e)).entity(result).build();
    }

    @Override
    public Response deleteEmployee(Long employeeId) {

        employeeService.delete(employeeId);

        return Response.noContent().build();
    }
}
