package com.javier.ultraratas.services;

import com.javier.ultraratas.models.PointType;
import com.javier.ultraratas.repository.PointTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PointTypeService {


    private  final PointTypeRepository pointTypeRepository;
    @Autowired
    public PointTypeService(PointTypeRepository pointTypeRepository){

        this.pointTypeRepository=pointTypeRepository;
    }

    public Collection<PointType> getPoints(){
        return  pointTypeRepository.findAll();
    }
}
