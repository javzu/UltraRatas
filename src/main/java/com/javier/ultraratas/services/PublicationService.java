package com.javier.ultraratas.services;

import com.javier.ultraratas.enums.PublicationState;
import com.javier.ultraratas.models.PointPublication;
import com.javier.ultraratas.models.PointType;
import com.javier.ultraratas.models.User;
import com.javier.ultraratas.repository.PointTypeRepository;
import com.javier.ultraratas.repository.PublicationRepository;
import com.javier.ultraratas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class PublicationService {
    private final PublicationRepository publicationRepository;
    private final UserRepository userRepository;

    private  final PointTypeRepository pointTypeRepository;
    @Autowired
    public PublicationService(PublicationRepository publicationRepository, UserRepository userRepository, PointTypeRepository pointTypeRepository){
        this.publicationRepository=publicationRepository;
        this.userRepository=userRepository;
        this.pointTypeRepository=pointTypeRepository;
    }

    public Collection<PointPublication> get() {
        return  publicationRepository.findAll();
    }
    public Optional<PointPublication> get(int id) {
        return publicationRepository.findById(id);
    }

    public Optional<PointPublication> getByState(PublicationState publicationState){
        return null;
                //publicationRepository.findByState(publicationState);
    }

    public Optional<User> getUser(int id){
        return userRepository.findById(id);
    }

    public Optional<PointType> getPoint(int id){
        return pointTypeRepository.findById(id);
    }


    public PointPublication save(PointPublication publication) {
        PointPublication pointpublication= new PointPublication();
        publicationRepository.save(publication);
        //db.put("1",pointpublication);
        return pointpublication;
    }

    public void savePointType(PointType pointType){
        pointTypeRepository.save(pointType);
    }

    public PointPublication delete(String id) {
        return null;
    }
}
