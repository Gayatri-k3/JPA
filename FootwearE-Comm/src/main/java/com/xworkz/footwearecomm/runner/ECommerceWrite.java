package com.xworkz.footwearecomm.runner;

import com.xworkz.footwearecomm.entity.ClothingEntity;

import javax.persistence.*;

public class ECommerceWrite {
    public static void main(String[] args) {
        ClothingEntity ecommerce = new ClothingEntity();
        ecommerce.setType("Denim Jacket");
        ecommerce.setBrand("Levis");
        ecommerce.setPrice(2499.0);
        ecommerce.setSize("M");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(ecommerce);
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