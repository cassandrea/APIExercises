package com.apiexercises.services;

import com.apiexercises.mappers.EmployeeMapper;
import com.apiexercises.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
/**
 * Contains any business logic and calls the mapper methods for Employee
 *
 * @author cass
 */
@Service
public class EmployeeService implements ServiceTemplate{

    //Uses Spring to control the creation of a mapper object
    @Autowired
    private EmployeeMapper mapper;

    //calls the mapper method to return an array list of all Employees
    @Override
    public ArrayList<Employee> getAll(){
        return mapper.getAll();
    }

    //calls the mapper method to return the Employee that matches the id passed down from the URI through the Resource
    @Override
    public Employee getById(int id){
        return mapper.getById(id);
    }

    //calls the mapper method to delete the Employee that matches the id passed down from the URI through the Resource
    @Override
    public String deleteById(int id){
        int success = mapper.deleteById(id);
        if (success > 0)
            return "successfully deleted";
        else
            return "failed to delete";
    }
    //calls the mapper method and passes the returned id to the getById method which allows you to return an object
    @Override
    public Employee addNew(Object employee){
        int id = mapper.addNew(employee);
        return mapper.getById(id);
    }
    //calls the mapper method and passes the returned id to the getById method which allows you to return an object
    @Override
    public Employee updateById(Object employee){
        int id = mapper.updateById(employee);
        return mapper.getById(id);
    }
}
/**
 * Improvements: The updateById method actually returns a status code, not an object - so I need to fix that
 */
