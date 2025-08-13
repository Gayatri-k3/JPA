package com.xworkz.tourism.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "tourism")
public class TourismEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer Id;

    @Column(name = "place")
    private String place;

    @Column(name = "noOfPeople")
    private Integer noOfPeople;

    @Column(name = "noOfDays")
    private Integer noOfDays;

    @Column(name = "startDate")
    private LocalDate startDate;

    @Column(name = "endDate")
    private LocalDate endDate;
}
