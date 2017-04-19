package com.apiexercises.resources;

import com.apiexercises.models.Response;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Abstract class to be extended by all Resource classes
 * It should be annotated with @RestController and contain @RequestMapping for all methods
 */
@RestController
@RequestMapping
public abstract class ResourceTemplate {
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
     * @return Response object with a Status Code and an ArrayList assigned to the data variable
     */
    abstract Object getById(@PathVariable(value="id")int id);

}
