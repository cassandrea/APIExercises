package com.apiexercises.resources;

import com.apiexercises.models.Department;
import com.apiexercises.utilities.Response;
import com.apiexercises.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import static com.apiexercises.utilities.HTTPStatusCode.NO_CONTENT;
import static com.apiexercises.utilities.HTTPStatusCode.OK;

/**
 * Maps the URI to a method that calls the Service methods and returns a Response object with a status code, message,
 * and requested data
 */
@RestController
@RequestMapping ("/departments")
public class DepartmentResource extends ResourceTemplate{

    //Uses Spring to control the creation of a service object
    @Autowired
    private DepartmentService service;

    //calls the service method and assigns the returned ArrayList to the data parameter in the Response controller
    @RequestMapping ("/")
    public Response getAll() {
        ArrayList<Department> departments = service.getAll();

        if (departments.size() == 0) {
            return new Response(NO_CONTENT);
        } else {
            return new Response(OK, departments);
        }
    }

    //calls the service method and assigns the returned object to the data parameter in the Response controller
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @Override
    public Response getByIdString(@PathVariable(value="id")String id){
            Department department = service.getByIdString(id);

            //add in some if statements with errors
            return new Response(OK, department);
        }

}
