package com.github.gpor89.kumuluzreact.rest;

import com.github.gpor89.kumuluzreact.rest.model.EmployeeJson;
import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by gregor on 14/05/2017.
 */
@Api(value = "/employees", description = "Provides basic http methods to manage employees", tags = "employees")
@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ResourceEmployee {

    /**
     *
     * @param page
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "Find all employees",
            notes = "Returns all employees found. When no employees found, empty result is returned.",
            response = EmployeeJson.class, responseContainer = "List"
    )
    @ApiResponses(value = {})
    @GET
    Response getAllEmployees(@QueryParam("page") Integer page, @QueryParam("pageSize") Integer pageSize);

    /**
     * @param employeeId
     * @return
     */
    @ApiOperation(value = "Find employee by employee identifier",
            notes = "Returns employee data object.",
            response = EmployeeJson.class
    )
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Invalid ID supplied"),
            @ApiResponse(code = 404, message = "Employee not found")})
    @GET
    @Path("/{employeeId}")
    Response getEmployeeById(@ApiParam(name = "employeeId", required = true) @PathParam("employeeId") Long employeeId);

    /**
     * @param employee
     * @return
     */
    @ApiOperation(value = "Create new employee",
            notes = "Creates new employee by provided data in POST body payload."
    )
    @POST
    Response createEmployee(@ApiParam(name = "employee", required = true) EmployeeJson employee);

    /**
     * @param employeeId
     * @param employee
     * @return
     */
    @ApiOperation(value = "Update employee",
            notes = "Updates existing employee identified by provided id with provided data in POST body payload."
    )
    @PUT
    @Path("/{employeeId}")
    Response updateEmployee(@ApiParam(name = "employeeId", required = true) @PathParam("employeeId") Long employeeId, @ApiParam(name = "material",
            required = true) EmployeeJson employee);

    /**
     * @param employeeId
     * @return
     */
    @ApiOperation(value = "Delete existing employee",
            notes = "Deletes an employee identified by provided id."
    )
    @ApiResponses({})
    @DELETE
    @Path("/{employeeId}")
    Response deleteEmployee(@ApiParam(name = "employeeId", required = true) @PathParam("employeeId") Long employeeId);


}
