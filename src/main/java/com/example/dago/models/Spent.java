package com.example.dago.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
public class Spent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
    private Date date;
    
    @Column(name="description", nullable=false, length = 200)
    private String description;

    @Column(name="amount", nullable=false,columnDefinition = "DOUBLE NOT NULL DEFAULT 0")
    private double amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false,columnDefinition = "ENUM('FIX', 'EXTRA', 'OTHER') DEFAULT 'FIX'")
    private SpentType type = SpentType.FIX;

}
