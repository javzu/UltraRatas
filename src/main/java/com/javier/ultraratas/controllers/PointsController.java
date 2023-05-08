package com.javier.ultraratas.controllers;

import com.javier.ultraratas.models.PointPublication;
import com.javier.ultraratas.models.PointType;
import com.javier.ultraratas.models.User;
import com.javier.ultraratas.repository.UserRepository;
import com.javier.ultraratas.services.PointTypeService;
import com.javier.ultraratas.services.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.Optional;

@RestController
public class PointsController {

    // private List<PointPublicationModel> db= List.of(new PointPublicationModel(1,"Test", 2000, PublicationState.published));
    private final PublicationService publicationService;
    private final PointTypeService pointTypeService;
    @Autowired
    public PointsController(PublicationService publicationService, PointTypeService pointTypeService) {
        this.publicationService = publicationService;
        this.pointTypeService=pointTypeService;
    }

    @GetMapping("/")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/todo")
    public Collection<PointPublication> get(){
        return (Collection<PointPublication>) publicationService.get();
    }
    @GetMapping("/todo/{id}")
    public Optional<PointPublication> get(@PathVariable int id){
        Optional<PointPublication> publication= publicationService.get(id);
        if(publication==null) throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
        return publication;
    }
    @DeleteMapping("/todo/{id}")
    public void del(@PathVariable String id){
        PointPublication publication= publicationService.delete(id);
        if(publication==null) throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/add")
    public PointPublication post(@RequestBody PointPublication publication){
        int userId=publication.getUser().getIdUser();
        int point=publication.getPointType().getIdPointType();
        User user=publicationService.getUser(userId).orElseThrow(()->new IllegalArgumentException("No existe el usuario"));
        PointType pointType= publicationService.getPoint(point).orElseThrow(()->new IllegalArgumentException("Puntos no definidos"));
        publication.setUser(user);
        publication.setPointType(pointType);
        publicationService.save(publication);
        return publication;
    }

    @GetMapping("/getPoints")
    public  Collection<PointType> createPoint(@RequestBody PointType pointType){
        return  pointTypeService.getPoints();
    }


}
