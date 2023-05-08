package com.javier.ultraratas.repository;

import com.javier.ultraratas.enums.PublicationState;
import com.javier.ultraratas.models.PointPublication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PublicationRepository extends JpaRepository<PointPublication,Integer> {
    //Optional<PointPublication> findByState(PublicationState publicationState);
}
