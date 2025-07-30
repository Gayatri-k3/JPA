package com.xworkz.footwearecomm.runner;


import com.xworkz.footwearecomm.entity.ClothingEntity;

import javax.persistence.*;

public class ECommerceRead {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            ClothingEntity ecommerce = em.find(ClothingEntity.class, 1);
            System.out.println(ecommerce);
            et.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            if (emf != null) emf.close();
            if (em != null) em.close();
        }
    }
}