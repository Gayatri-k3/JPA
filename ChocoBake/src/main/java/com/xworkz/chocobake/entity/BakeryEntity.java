package com.xworkz.chocobake.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Table(name="bakery")

public class BakeryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bakery_id")
    private Integer id;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_price")
    private Double price;

    @Column(name = "baked_on")
    private String bakedOn;

    @Column(name = "bakery_brand")
    private String brand;
}
