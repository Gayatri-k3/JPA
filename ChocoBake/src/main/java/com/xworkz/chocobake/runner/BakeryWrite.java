package com.xworkz.chocobake.runner;

import com.xworkz.chocobake.entity.BakeryEntity;

import javax.persistence.*;

public class BakeryWrite {
    public static void main(String[] args) {
        BakeryEntity product = new BakeryEntity();
        product.setBakedOn("26/9/24");
        product.setPrice(89.0);
        product.setItemName("Cake");
        product.setBrand("Britania");

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

