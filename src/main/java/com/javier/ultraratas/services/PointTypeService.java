package com.javier.ultraratas.services;

import com.javier.ultraratas.models.PointPublication;
import com.javier.ultraratas.models.PointType;
import com.javier.ultraratas.repository.BankRepository;
import com.javier.ultraratas.repository.PointTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class PointTypeService {


    private  final PointTypeRepository pointTypeRepository;
    private final BankRepository bankRepository;
    @Autowired
    public PointTypeService(PointTypeRepository pointTypeRepository, BankRepository bankRepository){

        this.pointTypeRepository=pointTypeRepository;
        this.bankRepository=bankRepository;
    }

    public Collection<PointType> getPoints(){
        return  pointTypeRepository.findAll();
    }

    public Optional<PointType> getPointDB(int id){
        return pointTypeRepository.findById(id);
    }

    public List<PointType> getPoint(int id){
        return pointTypeRepository.findByBankId(id);
    }

    public PointType save(PointType pointType) {
        try {
            //System.out.println("SAVING");
            PointType pointtype= new PointType();
            pointTypeRepository.save(pointType);
            //System.out.println("SAVED");
            return pointType;
        }
        catch (Exception e){
            System.out.println(e.toString());
        }

        return pointType;
    }

    public Collection<PointType> getByName(String name){
        return pointTypeRepository.findByPointNameContaining(name);
    }


}
