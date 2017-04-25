package com.apiexercises.mappers;

import com.apiexercises.utilities.HTTPError;
import com.apiexercises.utilities.HTTPStatusCode;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
/**
 * Generic interface to be extended by all Mapper interfaces
 * It should be annotated with @Mapper
 * @param <T>
 *
 * @author cass
 */
@Mapper
public interface MapperTemplate<T extends Object> {

    //Instance variables should be set with SQL queries

    /**
     * This method will be annotated with @Select which takes a String containing a SQL query as a parameter
     *
     * @return : ArrayList of the object type indicated
     */
    ArrayList<T> getAll();

    /**
     * * These methods will be annotated with @Select which takes a String containing a SQL query as a parameter
     *
     * @param id passed down from the URI through the Resource and Service
     * @return HTTPError Exception - These methods are overridden in the implementation, based on String vs int id
     */
    Object getById(int id);

    /**
     * These methods will be annotated with @Select which takes a String containing a SQL query as a parameter
     *
     * These methods are overridden in the implementation, based on String vs int id
     *
     * @param id passed down from the URI through the Resource and Service
     * @return 0 for failure and 1 for success
     */
    int deleteById(int id);

    /**
     *This method will be annotated with @Select which takes a String containing a SQL query as a parameter
     *
     * @param object passed down from the URI through the Resource and Service
     * @return the id from the updated object
     */
    int updateById(Object object);
    /**
     *This method will be annotated with @Select which takes a String containing a SQL query as a parameter
     *
     * @param object passed down from the URI through the Resource and Service
     * @return the id from the new object
     */
    int addNew(Object object);
}
