package com.xworkz.chocobake.runner;

import com.xworkz.chocobake.entity.ChocolateEntity;

import javax.persistence.*;

public class ChocolateWrite {
    public static void main(String[] args) {
        ChocolateEntity product = new ChocolateEntity();
        product.setBrand("Shampoo");
        product.setPrice(89.0);
        product.setName("20/2/25");
        product.setBrand("Apollo");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;
        try{
            emf= Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(product);
            et.commit();
        }catch (PersistenceException e){
            System.out.println("Exception at  Create");
            e.printStackTrace();
            et.rollback();
        }finally {
            if (emf!= null){
                emf.close();
            }
            if (em!= null){
                em.close();
            }
        }
    }
}
