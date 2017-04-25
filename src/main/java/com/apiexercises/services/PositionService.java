package com.apiexercises.services;

import com.apiexercises.mappers.PositionMapper;
import com.apiexercises.models.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
/**
 * Contains any business logic and calls the mapper methods for Position
 *
 * @author cass
 */
@Service
public class PositionService implements ServiceTemplate{

    //Uses Spring to control the creation of a mapper object
    @Autowired
    private PositionMapper mapper;

    //calls the mapper method to return an array list of all Positions
    @Override
    public ArrayList<Position> getAll(){
        return mapper.getAll();
    }

    //calls the mapper method to return the Position that matches the id passed down from the URI through the Resource
    @Override
    public Position getById(int id){
        return mapper.getById(id);
    }

    //calls the mapper method to delete the Position that matches the id passed down from the URI through the Resource
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
    public Position addNew(Object position){
        int id = mapper.addNew(position);
        return mapper.getById(id);
    }
    //calls the mapper method and passes the returned id to the getById method which allows you to return an object
    @Override
    public Position updateById(Object position){
        int id = mapper.updateById(position);
        return mapper.getById(id);
    }

}
/**
 * Improvements: The updateById method actually returns a status code, not an object - so I need to fix that
 */
