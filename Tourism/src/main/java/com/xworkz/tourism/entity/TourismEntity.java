package com.xworkz.tourism.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "tourism")
@NamedQuery(name = "getAllEntity",query = "select a from TourismEntity a")
@NamedQuery(name = "findById",query = "select a from TourismEntity a where a.packageId=:id")
@NamedQuery(name = "update", query = "update TourismEntity e set e.packageName=:packageName, e.destination = :destination, e.days=:days, e.packagePrice =:packagePrice, e.personsCount = :personsCount where e.packageId=:packageId")
@NamedQuery(name = "delete", query = "delete from TourismEntity e where e.packageId=:packageId")
public class TourismEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "package_id")
    private Integer packageId;

    @Column(name = "package_name")
    private String packageName;

    @Column(name = "destination")
    private String destination;

    @Column(name = "days")
    private Integer days;

    @Column(name = "package_price")
    private Double packagePrice;

    @Column(name = "persons_count")
    private Integer personsCount;
}
