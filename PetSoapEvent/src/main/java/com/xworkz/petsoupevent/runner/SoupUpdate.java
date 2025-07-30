package com.xworkz.petsoupevent.runner;


import com.xworkz.petsoupevent.entity.SoupEntity;

import javax.persistence.*;

public class SoupUpdate {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            SoupEntity soup = em.find(SoupEntity.class, 1);
            if (soup != null) {
                soup.setPrice(92.0);
                soup.setPrice(65.0);
                SoupEntity updated = em.merge(soup);
                System.out.println("Data Updated");
                System.out.println(updated);
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