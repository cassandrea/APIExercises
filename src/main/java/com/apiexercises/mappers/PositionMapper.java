package com.apiexercises.mappers;

import com.apiexercises.models.Position;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
/**
 * Executes SQL queries for Position
 *
 * @author cass
 */
@Mapper
public interface PositionMapper extends MapperTemplate{

    //SQL queries
    String GET_ALL = "select * from positions";
    String GET_BY_ID = "select * from positions where id = #{id}";
    String DELETE_BY_ID = "delete from positions where id = #{id}";
    String UPDATE_BY_ID = "update positions set " +
            "name = #{name}, " +
            "dept_no = #{dept_no} " +
            "where id = #{id}";
    String ADD_NEW = "insert into positions " +
            "(name, dept_no)" +
            "values (#{name}, #{dept_no})";

    //returns an array list of all positions
    @Select(GET_ALL)
    @Override
    ArrayList<Position> getAll();

    //returns the Position that matches the id passed down from the URI through the Resource and Service
    @Select(GET_BY_ID)
    @Override
    Position getById(int id);

    //deletes the Position that matches the id passed down from the URI through the Resource and Service
    @Delete(DELETE_BY_ID)
    @Override
    int deleteById(int id);

    //updates the Position received in the body of the HTTP request
    @Update(UPDATE_BY_ID)
    @Override
    int updateById(Object position);

    //adds the Position received in the body of the HTTP request
    @Insert(ADD_NEW)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Override
    int addNew(Object position);
}
