package com.xworkz.petsoupevent.entity;
import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "soup")
public class SoupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "soup_id")
    private Integer id;

    @Column(name = "soup_name")
    private String name;

    @Column(name = "soup_type")
    private String type;

    @Column(name = "soup_flavor")
    private String flavor;

    @Column(name = "soup_price")
    private Double price;
}