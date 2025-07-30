package com.xworkz.petsoupevent.runner;


import com.xworkz.petsoupevent.entity.EventRegistrationEntity;

import javax.persistence.*;

public class EventRegistrationUpdate {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            EventRegistrationEntity entity = em.find(EventRegistrationEntity.class, 1);
            if (entity != null) {
                entity.setLocation("Hubballi");
                EventRegistrationEntity updatedEntity = em.merge(entity);
                System.out.println("Updated: " + updatedEntity);
            }
            et.commit();
        } catch (PersistenceException e) {
            System.out.println("Exception in Update");
            e.printStackTrace();
            et.rollback();
        } finally {
            if (emf != null) emf.close();
            if (em != null) em.close();
        }
    }
}