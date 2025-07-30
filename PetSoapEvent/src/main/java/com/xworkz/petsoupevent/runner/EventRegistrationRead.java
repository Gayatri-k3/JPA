package com.xworkz.petsoupevent.runner;


import com.xworkz.petsoupevent.entity.EventRegistrationEntity;

import javax.persistence.*;

public class EventRegistrationRead {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            EventRegistrationEntity entity = em.find(EventRegistrationEntity.class, 1);
            System.out.println(entity);
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            if (emf != null) emf.close();
            if (em != null) em.close();
        }
    }
}