package com.javier.ultraratas.controllers;

import com.javier.ultraratas.models.Bank;
import com.javier.ultraratas.models.PointPublication;
import com.javier.ultraratas.models.PointType;
import com.javier.ultraratas.models.User;
import com.javier.ultraratas.services.BankService;
import com.javier.ultraratas.services.PointTypeService;
import com.javier.ultraratas.services.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class PointsController {

    // private List<PointPublicationModel> db= List.of(new PointPublicationModel(1,"Test", 2000, PublicationState.published));
    private final PublicationService publicationService;
    private final PointTypeService pointTypeService;

    private final BankService bankService;
    @Autowired
    public PointsController(PublicationService publicationService, PointTypeService pointTypeService, BankService bankService) {
        this.publicationService = publicationService;
        this.pointTypeService=pointTypeService;
        this.bankService=bankService;
    }

    @GetMapping("/")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/publication")
    public Collection<PointPublication> get(){
        return (Collection<PointPublication>) publicationService.get();
    }
   // @GetMapping("/publication/{id}")
   // public Optional<PointPublication> get(@PathVariable int id){
   //     Optional<PointPublication> publication= publicationService.get(id);
   //     if(publication==null) throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
   //     return publication;
   // }

    @GetMapping("/publication/{byPointName}")
    public List<PointPublication> get(@PathVariable String byPointName){
        return publicationService.findByPointType(byPointName);
    }
    @GetMapping("/pointType/{name}")
    public List<PointType> getPointId(@PathVariable String name){
        List<PointType> pointType= (List<PointType>) pointTypeService.getByName(name);
        if(pointType==null) throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
        return pointType;
    }
    @DeleteMapping("/todo/{id}")
    public void del(@PathVariable String id){
        PointPublication publication= publicationService.delete(id);
        if(publication==null) throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/publication")
    public PointPublication post(@RequestBody PointPublication publication){
        System.out.println("POST");
        int userId = publication.getUser().getIdUser();
        int point = publication.getPointType().getIdPointType();
        User user = publicationService.getUser(userId).orElseThrow(() -> new IllegalArgumentException("No existe el usuario"));
        Optional<PointType> pointTypeOptional = pointTypeService.getPointDB(point);
        PointType pointType= new PointType();
        if (pointTypeOptional.isPresent()) {
            System.out.println("ENTRO ACA");
            pointType = pointTypeOptional.get();
            if (publication.getPointType().getIdPointType() != point) {
                throw new IllegalArgumentException("El ID del tipo de punto recibido no coincide con el ID del tipo de punto esperado");
            }
            pointType.setPointName(publication.getPointType().getPointName());
            pointType.setBank(publication.getPointType().getBank());
        } else {
            System.out.println("ELSE");
           // pointType = new PointType();
            pointType.setIdPointType(point);
            pointType.setPointName(publication.getPointType().getPointName());
            pointType.setBank(publication.getPointType().getBank());
            System.out.println(publication.getPointType().getPointName());
            System.out.println(publication.getPointType().getBank().getBankName());
            System.out.println(publication.getPointType().getBank().getId());
            pointTypeService.save(pointType);
        }
        publication.setUser(user);
        publication.setPointType(pointType);
        publicationService.save(publication);
        //pointTypeService.save(pointType);
        return publication;
    }

    @GetMapping("/getPoints")
    public  Collection<PointType> createPoint(@RequestBody PointType pointType){
        return  pointTypeService.getPoints();
    }

    @GetMapping("/banks")
    public Collection<Bank> getBanks(){
        Collection Banks= bankService.getBanks();
        return Banks;
    }


}
