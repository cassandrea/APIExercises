package com.apiexercises.resources;

import com.apiexercises.utilities.Response;
import com.apiexercises.models.Position;
import com.apiexercises.services.PositionService;
import com.apiexercises.utilities.HTTPStatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static com.apiexercises.utilities.HTTPStatusCode.OK;

/**
 * Maps the URI to a method that calls the Service methods and returns a Response object with a status code, message,
 * and requested data
 *
 * @author cass
 */
@RestController
@RequestMapping("/positions")
public class PositionResource extends ResourceTemplate{

    //Uses Spring to control the creation of a service object
    @Autowired
    private PositionService service;

    //calls the service method and assigns the returned ArrayList to the data parameter in the Response controller
    @Override
    @RequestMapping("/")
    public Response getAll() {
        ArrayList<Position> positions = service.getAll();

        if (positions.size() == 0) {
            return new Response(HTTPStatusCode.NO_CONTENT);
        } else {
            return new Response(HTTPStatusCode.OK, positions);
        }
    }
    //calls the service method and assigns the returned object to the data parameter in the Response controller
    @RequestMapping("")
    @Override
    public Response getById(@RequestParam(value="id")int id) {
        Position position = service.getById(id);
        return new Response(HTTPStatusCode.OK, position);
    }
    //calls the service method and returns a Response object with a custom message
    @RequestMapping(path="", method= RequestMethod.DELETE)
    @Override
    public Response deleteById(@RequestParam(value="emp_no")int id){
        String message = service.deleteById(id);
        return new Response(OK, message);
    }
    //calls the service method and assigns the returned object to the data parameter in the Response controller
    @RequestMapping(method = RequestMethod.PATCH, value = "/")
    @Override
    public Response updateById(@RequestBody Object position) {
        Position newPosition = service.updateById(position);
        return new Response(HTTPStatusCode.OK, newPosition);
    }
    //calls the service method and assigns the returned object to the data parameter in the Response controller
    @RequestMapping(method = RequestMethod.POST, value = "/")
    @Override
    public Response addNew(@RequestBody Object position) {
        Position newPosition = service.addNew(position);
        return new Response(HTTPStatusCode.OK, newPosition);
    }
    /**
     * Improvements
     *
     * add data cleansing methods to check for any possible errors in the API call and return custom exception
     * the HTTP methods can then call these to avoid try/catch and if statements
     */
}

