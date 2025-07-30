package com.xworkz.petsoupevent.runner;


import com.xworkz.petsoupevent.entity.SoupEntity;

import javax.persistence.*;

public class SoupRead {
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
            System.out.println(soup);
            et.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            if (emf != null) emf.close();
            if (em != null) em.close();
        }
    }
}