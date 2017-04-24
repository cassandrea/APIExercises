package com.apiexercises.mappers;

import com.apiexercises.models.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.ArrayList;
/**
 * Executes SQL queries for Employee
 */
@Mapper
public interface EmployeeMapper extends MapperTemplate{

    //SQL queries
    String GET_ALL = "select * from employees";
    String GET_BY_ID = "select * from employees where emp_no = #{id}";
    String DELETE_BY_ID = "delete from employees where emp_no = #{id}";

    //returns an array list of all employees
    @Select(GET_ALL)
    @Override
    ArrayList<Employee> getAll();

    //returns the Employee that matches the id passed down from the URI through the Resource and Service
    @Select(GET_BY_ID)
    @Override
    Employee getById(int id);

    //deletes the Department that matches the id passed down from the URI through the Resource and Service
    @Delete(DELETE_BY_ID)
    @Override
    void deleteById(int id);
}
