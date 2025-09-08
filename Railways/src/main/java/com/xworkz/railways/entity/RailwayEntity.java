package com.xworkz.railways.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "Railways")
@NamedQuery(name=("getAll"), query = "select a from RailwayEntity a")
public class RailwayEntity {
    public RailwayEntity(){
        System.out.println("RailwayEntity loaded");
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "railwayId")
    private Integer railwayId;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "age")
    private Integer age;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "source")
    private String source;
    @Column(name = "destination")
    private String destination;
}
