package com.xworkz.footwearecomm.runner;


import com.xworkz.footwearecomm.entity.FootwearEntity;

import javax.persistence.*;

public class FootwearWrite {
    public static void main(String[] args) {
        FootwearEntity footwear = new FootwearEntity();
        footwear.setBrand("Bata");
        footwear.setSize("8");
        footwear.setType("Sneakers");
        footwear.setPrice(1200.0);

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(footwear);
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