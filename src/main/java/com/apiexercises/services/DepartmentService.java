package com.apiexercises.services;

import com.apiexercises.mappers.DepartmentMapper;
import com.apiexercises.models.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
/**
 * Contains any business logic and calls the mapper methods for Department
 *
 * @author cass
 */
@Service
public class DepartmentService implements ServiceTemplate{

    //Uses Spring to control the creation of a mapper object
    @Autowired
    private DepartmentMapper mapper;

    //calls the mapper method to return an array list of all Departments
    @Override
    public ArrayList<Department> getAll(){
        return mapper.getAll();
    }

    //calls the mapper method to return the Department that matches the id passed down from the URI through the Resource
    @Override
    public Department getById(int id){return mapper.getById(id);
    }
    //calls the mapper method to delete the Department that matches the id passed down from the URI through the Resource
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
    public Department addNew(Object department){
        int id = mapper.addNew(department);
        return mapper.getById(id);
    }
    //calls the mapper method and passes the returned id to the getById method which allows you to return an object
    @Override
    public Department updateById(Object department){
        int id = mapper.updateById(department);
        return mapper.getById(id);
    }
}
/**
 * Improvements: The updateById method actually returns a status code, not an object - so I need to fix that
 */
