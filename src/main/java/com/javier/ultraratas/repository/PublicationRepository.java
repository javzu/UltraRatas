package com.javier.ultraratas.repository;

import com.javier.ultraratas.models.PointPublication;
import com.javier.ultraratas.models.PointType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicationRepository extends JpaRepository<PointPublication,Integer> {
    //Optional<PointPublication> findByState(PublicationState publicationState);
    List<PointPublication> findByPointTypeIn(List<PointType> pointTypes);
}
