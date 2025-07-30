package com.xworkz.petsoupevent.runner;


import com.xworkz.petsoupevent.entity.SoupEntity;

import javax.persistence.*;

public class SoupWrite {
    public static void main(String[] args) {
        SoupEntity soup = new SoupEntity();
        soup.setFlavor("Tomato");
        soup.setPrice(60.0);
        soup.setType("Knorr");
        soup.setType("Thick");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(soup);
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