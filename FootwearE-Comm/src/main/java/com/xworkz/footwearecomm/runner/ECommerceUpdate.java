package com.xworkz.footwearecomm.runner;

import com.xworkz.footwearecomm.entity.ClothingEntity;

import javax.persistence.*;

public class ECommerceUpdate {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            ClothingEntity entity = em.find(ClothingEntity.class, 1);
            if (entity != null) {
                entity.setPrice(1999.0);
                entity.setSize("L");
                ClothingEntity updated = em.merge(entity);
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