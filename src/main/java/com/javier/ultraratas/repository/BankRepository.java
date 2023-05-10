package com.javier.ultraratas.repository;

import com.javier.ultraratas.models.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank,Integer> {
}
