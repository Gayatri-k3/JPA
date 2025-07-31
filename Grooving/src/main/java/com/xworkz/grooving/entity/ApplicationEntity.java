package com.xworkz.grooving.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "grooving")
public class ApplicationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "app_id")
    private Integer applicationID;
    @Column(name = "app_name")
    private String applicationName;
    @Column(name = "app_size")
    private String applicationSize;
    @Column(name = "app_company")
    private String company;
    @Column(name = "app_users")
    private Integer noOfUSers;
    @Column(name = "app_ratings")
    private Float ratings;
    @Column(name = "app_launchDate")
    private LocalDate launchDate;

}
