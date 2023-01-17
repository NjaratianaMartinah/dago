package com.example.dago.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
    private Date date;

    @Column(name="amount", nullable=false, columnDefinition = "DOUBLE NOT NULL DEFAULT 0")
    private double amount;
   
    @Column(name="start_counter", nullable=false, columnDefinition = " INT NOT NULL DEFAULT 0")
    private int startCounter;

    @Column(name="end_counter", nullable=false, columnDefinition = " INT NOT NULL DEFAULT 0")
    private int endCounter;

    @Column(name="diff_counter", nullable=false, columnDefinition = " INT NOT NULL DEFAULT 0")
    private int diffCounter;

    @Column(name="responsible", nullable=false, length = 200)
    private String responsible;

    public void setDiffCounter(){
        this.diffCounter = endCounter - startCounter;
    }
    
}
