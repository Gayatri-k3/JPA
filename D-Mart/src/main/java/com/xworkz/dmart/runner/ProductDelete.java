package com.xworkz.dmart.runner;

import com.xworkz.dmart.entity.ProductEntity;

import javax.persistence.*;

public class ProductDelete {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;
        try {
            emf= Persistence.createEntityManagerFactory("x-workz");
            em= emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            ProductEntity entity1 = em.find(ProductEntity.class, 1);
            if (entity1!=null){
                em.remove(entity1);
                System.out.println("Deleted Successfully");
                et.commit();
            }

        }catch (PersistenceException e){
            e.printStackTrace();
            et.rollback();
        }finally {
            if (emf!=null)
            {
                emf.close();
            }
            if (em!=null){
                em.close();
            }
        }
    }
}
