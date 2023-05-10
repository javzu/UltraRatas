package com.javier.ultraratas.repository;

import com.javier.ultraratas.models.PointType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PointTypeRepository extends JpaRepository<PointType,Integer> {
    List<PointType> findByBankId(int idBank);
    List<PointType> findAll();

}
