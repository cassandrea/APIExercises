package com.apiexercises.mappers;

import com.apiexercises.models.Employee;
import org.apache.ibatis.annotations.*;

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
    String UPDATE_BY_ID = "update employees set " +
            "birth_date = #{birth_date}," +
            "first_name = #{first_name}," +
            "last_name = #{last_name}," +
            "gender = #{gender}," +
            "hire_date = #{hire_date}" +
            "where emp_no = #{emp_no}";
    String ADD_NEW = "insert into employees " +
            "(birth_date, first_name, last_name, gender, hire_date)" +
            "values (#{birth_date}, #{first_name}, #{last_name}, #{gender}, #{hire_date} )";

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
    int deleteById(int id);

    //
    @Update(UPDATE_BY_ID)
    @Override
    int updateById(Object employee);

    //
    @Insert(ADD_NEW)
    @Options(useGeneratedKeys = true, keyProperty = "emp_no")
    @Override
    int addNew(Object employee);
}
