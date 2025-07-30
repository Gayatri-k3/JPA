package com.xworkz.footwearecomm.entity;
import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "footwear")
public class FootwearEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "footwear_id")
    private Integer id;

    @Column(name = "footwear_type")
    private String type;

    @Column(name = "footwear_size")
    private String size;

    @Column(name = "footwear_price")
    private Double price;

    @Column(name = "footwear_brand")
    private String brand;
}
