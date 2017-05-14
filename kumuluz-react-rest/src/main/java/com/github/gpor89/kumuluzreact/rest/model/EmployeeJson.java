package com.github.gpor89.kumuluzreact.rest.model;

import com.github.gpor89.kumuluzreact.api.model.Employee;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by gregor on 14/05/2017.
 */

@Data
public class EmployeeJson implements Serializable {

    private static final long serialVersionUID = 204398558L;

    private Long id;
    private String firstName;
    private String lastName;

    public EmployeeJson() {
    }

    public EmployeeJson(Employee e) {
        this.id = e.getId();
        this.firstName = e.getFirstName();
        this.lastName = e.getLastName();
    }

}
