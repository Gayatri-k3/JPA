package com.xworkz.userlogin.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "registrations")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "contact_number", length = 10)
    private String contactNumber;

    @Column(length = 10)
    private String gender;

    boolean isPresent;
}
