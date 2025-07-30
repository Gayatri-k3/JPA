package com.xworkz.petsoupevent.entity;


import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "event_registration")
public class EventRegistrationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registration_id")
    private Integer id;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "participant_name")
    private String participantName;

    @Column(name = "registration_date")
    private String registrationDate;

    @Column(name = "event_location")
    private String location;
}