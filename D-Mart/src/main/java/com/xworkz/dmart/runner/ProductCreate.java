package com.xworkz.dmart.runner;

import com.xworkz.dmart.entity.ProductEntity;

import javax.persistence.*;

public class ProductCreate {
    public static void main(String[] args) {
        ProductEntity product = new ProductEntity();
        product.setProductName("Shampoo");
        product.setPrice(89.0);
        product.setMfd("20/2/25");
        product.setCompany("Apollo");

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
            System.out.println("Exception at Product Create");
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
