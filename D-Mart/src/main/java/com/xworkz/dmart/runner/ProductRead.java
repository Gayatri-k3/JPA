package com.xworkz.dmart.runner;

import com.xworkz.dmart.entity.ProductEntity;

import javax.persistence.*;

public class ProductRead {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;
        try{
            emf= Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            ProductEntity entity = em.find(ProductEntity.class, 1);
            System.out.println(entity);
            et.commit();
        }catch (PersistenceException e){
            e.printStackTrace();
            System.out.println("Exception at ProductRead");
        }
        finally {
            if (emf!=null){
                emf.close();
            }
            if (em!=null){
                em.close();
            }
        }
    }
}
