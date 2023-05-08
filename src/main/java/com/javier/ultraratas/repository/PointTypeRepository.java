package com.javier.ultraratas.repository;

import com.javier.ultraratas.models.PointType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointTypeRepository extends JpaRepository<PointType,Integer> {
}
