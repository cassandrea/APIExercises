package com.apiexercises.services;

import com.apiexercises.mappers.DepartmentMapper;
import com.apiexercises.models.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
/**
 * Contains any business logic and calls the mapper methods for Department
 */
@Service
public class DepartmentService implements ServiceTemplate{

    //Uses Spring to control the creation of a mapper object
    @Autowired
    private DepartmentMapper mapper;

    //calls the mapper method to return an array list of all Departments
    public ArrayList<Department> getAll(){
        return mapper.getAll();
    }

    //calls the mapper method to return the Department that matches the id passed down from the URI through the Resource
    @Override
    public Department getByIdString(String id){
        return mapper.getByIdString(id);
    }


}
