package com.apiexercises.resources;

import com.apiexercises.models.Department;
import com.apiexercises.utilities.HTTPStatusCode;
import com.apiexercises.utilities.Response;
import com.apiexercises.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static com.apiexercises.utilities.HTTPStatusCode.NO_CONTENT;
import static com.apiexercises.utilities.HTTPStatusCode.OK;

/**
 * Maps the URI to a method that calls the Service methods and returns a Response object with a status code, message,
 * and requested data
 *
 * @author cass
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
    @RequestMapping("")
    @Override
    public Response getById(@RequestParam(value="id")int id){
            Department department = service.getById(id);
            return new Response(OK, department);
        }
    //calls the service method and returns a Response object with a custom message
    @RequestMapping(path="", method= RequestMethod.DELETE)
    @Override
    public Response deleteById(@RequestParam(value="id")int id){
        String message = service.deleteById(id);
        return new Response(OK, message);
    }
    //calls the service method and assigns the returned object to the data parameter in the Response controller
    @RequestMapping(method = RequestMethod.PATCH, value = "/")
    @Override
    public Response updateById(@RequestBody Object department) {
        Department newDepartment = service.updateById(department);
        return new Response(HTTPStatusCode.OK, newDepartment);
    }
    //calls the service method and assigns the returned object to the data parameter in the Response controller
    @RequestMapping(method = RequestMethod.POST, value = "/")
    @Override
    public Response addNew(@RequestBody Object department) {
        Department newDepartment = service.addNew(department);
        return new Response(HTTPStatusCode.OK, newDepartment);
    }

    /**
     * Improvements
     *
     * add data cleansing methods to check for any possible errors in the API call and return custom exception
     * the HTTP methods can then call these to avoid try/catch and if statements
     */
}
