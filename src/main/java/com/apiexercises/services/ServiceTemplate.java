package com.apiexercises.services;

import com.apiexercises.utilities.HTTPError;
import com.apiexercises.utilities.HTTPStatusCode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
/**
 * Generic interface to be implemented by all Service classes
 * It should be annotated with @Service
 * @param <T>
 */
@Service
public interface ServiceTemplate<T extends Object> {

    //An instance variable of the mapper class should be declared with the @Autowired annotation
    /**
     * This method calls the getAll method on the autowired mapper object
     * @return ArrayList of the object type indicated
     */
    public ArrayList<T> getAll();

    /**
     * This method calls the getById method on the autowired mapper object
     * @param id passed down from the URI through the Resource
     * @return HTTPError Exception - These methods are overridden in the implementation, based on String vs int id
     */
    default Object getById(int id){
        return new HTTPError(HTTPStatusCode.TEAPOT);
    }
    default Object getByIdString(String id){
        return new HTTPError(HTTPStatusCode.TEAPOT);
    }

    /**
     * This method calls the deleteById method on the autowired mapper object
     * @param id passed down from the URI through the Resource
     */
    default String  deleteById(int id) {return "failure";}
    default String deleteByIdString(String id) {return "failure";}

    //addNew
    //updateById
}
