package com.apiexercises.resources;

import com.apiexercises.models.Employee;
import com.apiexercises.utilities.Response;
import com.apiexercises.services.EmployeeService;
import com.apiexercises.utilities.HTTPStatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping("")
    @Override
    public Response getById(@RequestParam(value="emp_no")int id) {
        Employee employee = service.getById(id);

        //add in some if statements with errors
        return new Response(HTTPStatusCode.OK, employee);
    }

    //calls the service method and returns a Response object with a custom message
    @RequestMapping(path="/{emp_no}", method= RequestMethod.DELETE)
    @Override
    public Response deleteById(@PathVariable(value="emp_no")int id){
        String message = service.deleteById(id);
        return new Response(OK, message);
    }
    //calls the service method and assigns the returned object to the data parameter in the Response controller
    @RequestMapping(method = RequestMethod.PATCH, value = "/")
    //override once added to template
    public Response updateById(@RequestBody Employee employee) {
        Employee newEmployee = service.updateById(employee);

        //add in some if statements with errors
        return new Response(HTTPStatusCode.OK, newEmployee);
    }
    //calls the service method and assigns the returned object to the data parameter in the Response controller
    @RequestMapping(method = RequestMethod.POST, value = "/")
    //override once added to template
    public Response addNew(@RequestBody Employee employee) {
        Employee newEmployee = service.addNew(employee);

        //add in some if statements with errors
        return new Response(HTTPStatusCode.OK, newEmployee);
    }
}
