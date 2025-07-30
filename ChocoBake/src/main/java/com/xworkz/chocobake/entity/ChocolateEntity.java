package com.xworkz.chocobake.entity;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "chocolate")
public class ChocolateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "choco_id")
    private Integer id;

    @Column(name = "choco_name")
    private String name;

    @Column(name = "choco_price")
    private Double price;

    @Column(name = "choco_weight")
    private Double weight;

    @Column(name = "choco_brand")
    private String brand;
}
