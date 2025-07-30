package com.xworkz.footwearecomm.entity;


import lombok.*;

import javax.persistence.*;

    @Getter
    @Setter
    @RequiredArgsConstructor
    @ToString
    @Entity
    @Table(name = "clothing")
    public class ClothingEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "clothing_id")
        private Integer id;

        @Column(name = "cloth_type")
        private String type;

        @Column(name = "cloth_size")
        private String size;

        @Column(name = "cloth_price")
        private Double price;

        @Column(name = "cloth_brand")
        private String brand;
    }