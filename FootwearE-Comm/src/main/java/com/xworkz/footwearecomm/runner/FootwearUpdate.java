package com.xworkz.footwearecomm.runner;

import com.xworkz.footwearecomm.entity.FootwearEntity;

import javax.persistence.*;

public class FootwearUpdate {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            FootwearEntity footwear = em.find(FootwearEntity.class, 1);
            if (footwear != null) {
                footwear.setPrice(999.0);
                footwear.setType("Formal Shoes");
                FootwearEntity updated = em.merge(footwear);
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