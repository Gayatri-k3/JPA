package com.xworkz.petsoupevent.entity;
import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "pet_adoption")
public class PetAdoptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adoption_id")
    private Integer id;

    @Column(name = "pet_name")
    private String petName;

    @Column(name = "pet_type")
    private String petType;

    @Column(name = "adopter_name")
    private String adopterName;

    @Column(name = "age")
    private int age;
}