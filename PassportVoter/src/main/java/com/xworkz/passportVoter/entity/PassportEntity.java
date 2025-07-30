package com.xworkz.passportVoter.entity;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "passport_application")
public class PassportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private Integer id;

    @Column(name = "applicant_name")
    private String name;

    @Column(name = "passport_type")
    private String type;

    @Column(name = "application_status")
    private String status;

    @Column(name = "submission_date")
    private String submissionDate;
}