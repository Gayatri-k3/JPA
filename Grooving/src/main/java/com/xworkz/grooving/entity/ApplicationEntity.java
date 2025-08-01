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

@NamedQuery(name="findApplicationByName", query = "select a from ApplicationEntity a where a.applicationName=:name")
@NamedQuery(name="findBySize", query = "select s from ApplicationEntity s where s.applicationSize=:size")
@NamedQuery(name = "findByCompany",query = "select c from ApplicationEntity c where c.company=:comp")
@NamedQuery(name = "findByUsers",query = "select u from ApplicationEntity u where u.noOfUSers=:users")
@NamedQuery(name = "findByRatings",query = "select r from ApplicationEntity r where r.ratings=:ratings")
@NamedQuery(name = "findByDate",query = "select d from ApplicationEntity d where d.launchDate=:date")


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
