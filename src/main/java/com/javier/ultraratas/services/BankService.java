package com.javier.ultraratas.services;

import com.javier.ultraratas.models.Bank;
import com.javier.ultraratas.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BankService {

    final BankRepository bankRepository;

    @Autowired
    public BankService(BankRepository bankRepository){
        this.bankRepository=bankRepository;
    }

    public Collection<Bank> getBanks(){
        return bankRepository.findAll();
    }
}
