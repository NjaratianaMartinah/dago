package com.example.dago.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dago.models.Spent;
import com.example.dago.repositories.SpentRepository;

@Service
public class SpentService {
    
    private SpentRepository spentRepository;

    public SpentService( SpentRepository spentRepository){
        this.spentRepository = spentRepository;
    }

    public List<Spent> findMonthlySpent(int month, int year){
        return (List<Spent>) spentRepository.findByDate(month, year);
    }

    public Spent create(Spent spent){
        return spentRepository.save(spent);
    }

    public Spent update(Spent spent, int spentId) throws Exception{
        if(spentRepository.findById(spentId).isPresent()){
            spent.setId(spentId); 
            spentRepository.save(spent);
            return spent;
        }
        throw new Exception("Ressource not found with id" + spentId);
    }
}
