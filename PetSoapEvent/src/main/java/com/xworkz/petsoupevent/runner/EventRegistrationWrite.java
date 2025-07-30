package com.xworkz.petsoupevent.runner;


import com.xworkz.petsoupevent.entity.EventRegistrationEntity;

import javax.persistence.*;

public class EventRegistrationWrite {
    public static void main(String[] args) {
        EventRegistrationEntity event = new EventRegistrationEntity();
        event.setEventName("TechFest 2025");
        event.setRegistrationDate("30/7/25");
        event.setLocation("Bangalore");
        event.setParticipantName("Gayatri Kulkarni");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(event);
            et.commit();
        } catch (PersistenceException e) {
            System.out.println("Exception at Create");
            e.printStackTrace();
            et.rollback();
        } finally {
            if (emf != null) emf.close();
            if (em != null) em.close();
        }
    }
}