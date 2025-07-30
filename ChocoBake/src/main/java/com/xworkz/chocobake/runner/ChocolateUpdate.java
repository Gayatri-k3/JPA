package com.xworkz.chocobake.runner;

import com.xworkz.chocobake.entity.ChocolateEntity;

import javax.persistence.*;

public class ChocolateUpdate {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;
        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            ChocolateEntity entity1 = em.find(ChocolateEntity.class, 1);
            if (entity1 != null) {
                entity1.setPrice(50.0);
                entity1.setName("HandWash");
                ChocolateEntity UpdatedProd = em.merge(entity1);
                System.out.println("Data Updated");
                System.out.println(UpdatedProd);
            }
            et.commit();
        } catch (PersistenceException e) {
            System.out.println("Exception found in Update");
            e.getStackTrace();
            et.rollback();
        } finally {
            if (emf != null) {
                emf.close();
            }
            if (em != null) {
                em.close();
            }
        }

    }
}
