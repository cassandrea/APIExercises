package com.apiexercises.resources;

import com.apiexercises.utilities.Response;
import com.apiexercises.utilities.HTTPError;
import com.apiexercises.utilities.HTTPStatusCode;
import org.springframework.web.bind.annotation.*;

/**
 * Abstract class to be extended by all Resource classes
 * It should be annotated with @RestController and contain @RequestMapping for all methods
 *
 * @author cass
 */
@RestController
@RequestMapping
public abstract class ResourceTemplate<T> {
//
    //An instance variable of the Service class should be declared with the @Autowired annotation

    /**
     * This method calls the getAll method on the service and passes it as a parameter to the Response controller
     * @return Response object with a Status Code and an ArrayList assigned to the data variable
     */
    abstract Response getAll();

    /**
     * This method calls the getById method on the service and passes it as a parameter to the Response controller
     * @param id received as a parameter in the URI
     * @return Response object with a Status Code and an object assigned to the data variable
     */
    abstract Response getById(@PathVariable(value="id")int id);

    /**
     * This method calls the deleteById method on the service and passes it as a parameter to the Response controller
     * @param id received as a parameter in the URI
     * @return Response object with a Status Code and a message
     */
    abstract Response deleteById(@RequestParam(value="id") int id);

    /**
     * This method calls the updateById method on the service and passes it as a parameter to the Response controller
     * @param object Received in the body of the request
     * @return Response object with a Status Code and an object assigned to the data variable
     */
    abstract Response updateById(@RequestBody Object object);

    /**
     * This method calls the addNew method on the service and passes it as a parameter to the Response controller
     * @param object Received in the body of the request
     * @return Response object with a Status Code and an object assigned to the data variable
     */
    abstract Response addNew(@RequestBody Object object);
}
