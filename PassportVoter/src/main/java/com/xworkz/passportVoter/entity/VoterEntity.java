package com.xworkz.passportVoter.entity;


import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "voter_registration")
public class VoterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "voter_id")
    private Integer id;

    @Column(name = "voter_name")
    private String name;

    @Column(name = "voter_age")
    private Integer age;

    @Column(name = "voter_gender")
    private String gender;

    @Column(name = "voter_region")
    private String region;
}