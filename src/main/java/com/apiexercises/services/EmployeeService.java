package com.apiexercises.services;

import com.apiexercises.mappers.EmployeeMapper;
import com.apiexercises.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
/**
 * Contains any business logic and calls the mapper methods for Employee
 */
@Service
public class EmployeeService implements ServiceTemplate{

    //Uses Spring to control the creation of a mapper object
    @Autowired
    private EmployeeMapper mapper;

    //calls the mapper method to return an array list of all Employees
    public ArrayList<Employee> getAll(){
        return mapper.getAll();
    }

    //calls the mapper method to return the Employee that matches the id passed down from the URI through the Resource
    public Employee getById(int id){
        return mapper.getById(id);
    }

    //calls the mapper method to delete the Department that matches the id passed down from the URI through the Resource
    @Override
    public void deleteById(int id){
        mapper.deleteById(id);
    }
}
