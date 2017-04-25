package com.apiexercises.mappers;

import com.apiexercises.models.Department;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
/**
 * Executes SQL queries for Department
 *
 * @author cass
 */
@Mapper
public interface DepartmentMapper extends MapperTemplate{

    //SQL queries
    String GET_ALL = "select * from departments";
    String GET_BY_ID = "select * from departments where id = #{id}";
    String DELETE_BY_ID = "delete from departments where id = #{id}";
    String UPDATE_BY_ID = "update departments set " +
            "name = #{name}," +
            "dept_no = #{dept_no}," +
            "where id = #{id}";
    String ADD_NEW = "insert into departments " +
            "(name, dept_no)" +
            "values (#{name}, #{dept_no})";

    //returns an array list of all departments
    @Select(GET_ALL)
    @Override
    ArrayList<Department> getAll();

    //returns the Department that matches the id passed down from the URI through the Resource and Service
    @Select(GET_BY_ID)
    @Override
    Department getById(int id);

    //deletes the Department that matches the id passed down from the URI through the Resource and Service
    @Delete(DELETE_BY_ID)
    @Override
    int deleteById(int id);

    //updates the Department received in the body of the HTTP request
    @Update(UPDATE_BY_ID)
    @Override
    int updateById(Object department);

    //adds the Department received in the body of the HTTP request
    @Insert(ADD_NEW)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Override
    int addNew(Object department);
}
