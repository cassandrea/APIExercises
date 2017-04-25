package com.apiexercises.services;

import com.apiexercises.utilities.HTTPError;
import com.apiexercises.utilities.HTTPStatusCode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
/**
 * Generic interface to be implemented by all Service classes
 * It should be annotated with @Service
 * @param <T>
 *
 * @author cass
 */
@Service
public interface ServiceTemplate<T extends Object> {

    //An instance variable of the mapper class should be declared with the @Autowired annotation
    /**
     * This method calls the getAll method on the autowired mapper object
     * @return ArrayList of the object type indicated
     */
    ArrayList<T> getAll();

    /**
     * This method calls the getById method on the autowired mapper object
     * @param id passed down from the URI through the Resource
     * @return HTTPError Exception - These methods are overridden in the implementation, based on String vs int id
     */
    Object getById(int id);

    /**
     * This method calls the deleteById method on the autowired mapper object
     * @param id passed down from the URI through the Resource
     */
    String  deleteById(int id);

    /**
     * This method calls the addNew method on the autowired mapper object and passes the returned id to the
     * getById method which allows you to return an object
     * @param object passed down from the request body through the Resource
     * @return object of the specific type
     */
    Object addNew(Object object);

    /**
     *
     * @param object passed down from the request body through the Resource
     * @return object of the specific type
     */
    Object updateById(Object object);
}
