package com.apiexercises.mappers;

import com.apiexercises.models.Department;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.ArrayList;
/**
 * Executes SQL queries for Department
 */
@Mapper
public interface DepartmentMapper extends MapperTemplate{

    //SQL queries
    String GET_ALL = "select * from departments";
    String GET_BY_ID = "select * from departments where dept_no = #{id}";

    //returns an array list of all departments
    @Select(GET_ALL)
    @Override
    ArrayList<Department> getAll();

    //returns the Department that matches the id passed down from the URI through the Resource and Service
    @Select(GET_BY_ID)
    @Override
    Department getByIdString(String id);



}
