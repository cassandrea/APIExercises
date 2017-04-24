package com.apiexercises.resources;

import com.apiexercises.models.Employee;
import com.apiexercises.utilities.Response;
import com.apiexercises.services.EmployeeService;
import com.apiexercises.utilities.HTTPStatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import static com.apiexercises.utilities.HTTPStatusCode.OK;

/**
 * Maps the URI to a method that calls the Service methods and returns a Response object with a status code, message,
 * and requested data
 */
@RestController
@RequestMapping ("/employees")
public class EmployeeResource extends ResourceTemplate{

    //Uses Spring to control the creation of a service object
    @Autowired
    private EmployeeService service;

    //calls the service method and assigns the returned ArrayList to the data parameter in the Response controller
    @Override
    @RequestMapping("/")
    public Response getAll() {
        ArrayList<Employee> employees = service.getAll();

        if (employees.size() == 0) {
            return new Response(HTTPStatusCode.NO_CONTENT);
        } else {
            return new Response(HTTPStatusCode.OK, employees);
        }
    }

    //calls the service method and assigns the returned object to the data parameter in the Response controller
    @RequestMapping("/{id}")
    @Override
    public Response getById(@PathVariable(value="id")int id) {
        Employee employee = service.getById(id);

        //add in some if statements with errors
        return new Response(HTTPStatusCode.OK, employee);
    }

    //calls the service method and returns a Response object with a custom message
    @RequestMapping(path="/{id}", method= RequestMethod.DELETE)
    @Override
    public Response deleteById(@PathVariable(value="id")int id){
        service.deleteById(id);
        return new Response(OK, "Successfully Deleted");
    }
}
