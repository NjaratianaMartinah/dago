package com.example.dago.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dago.models.Spent;
import com.example.dago.services.SpentService;

@RestController
@RequestMapping("/spent")
public class SpentController {
    
    private SpentService spentService;

    public SpentController( SpentService spentService){
        this.spentService = spentService;
    }


 /**
     * @param month the month's date of the payement
     * @param year the year's date of the payement
     * @return a list of Spent in one month
     */
    @GetMapping("/{month}/{year}")
    public List<Spent> getMonthlySpent(@PathVariable int month, @PathVariable int year){
        return spentService.findMonthlySpent(month, year);
    }

    /**
     * @param spent the new spent
     * @return the created spent
     */
    @PostMapping("/")
    public Spent create(@RequestBody Spent spent){
        spent.setDate(new Date());
        return spentService.create(spent);
    }

    /**
     * @param spent the new value of the spent
     * @param spent the id  of the spent to update
     * @return the updated spent
     * @throws Exception
     */
    @PutMapping("/{id}")
    public Spent update(@RequestBody Spent spent, @PathVariable("id") int spentId) throws Exception{
        try {
            return spentService.update(spent, spentId);
        } catch (Exception e) {
            throw e;
        }
    }
}
