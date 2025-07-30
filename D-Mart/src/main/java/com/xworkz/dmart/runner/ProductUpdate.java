package com.xworkz.dmart.runner;

import com.xworkz.dmart.entity.ProductEntity;

import javax.persistence.*;

public class ProductUpdate {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et= null;
        try{
            emf = Persistence.createEntityManagerFactory("x-workz"); //loading, registering the driver name
            em = emf.createEntityManager();//DML (Insert,Update,Delete) and DQL(select)
            //TCL(set autocommit, rollback, savepoint) - in SQL
            //In java- begin(), commit() and rollback()
            et = em.getTransaction(); //methods are here
            et.begin();//set autocommit=0;
            //insert update and delete
            ProductEntity entity1 = em.find(ProductEntity.class,1);//find using ID
            if (entity1 != null){
                entity1.setPrice(50.0);
                entity1.setProductName("HandWash");
                ProductEntity UpdatedProd = em.merge(entity1);
                System.out.println("Data Updated");
                System.out.println(UpdatedProd);
            }
            et.commit();//set autocommit=1;
        }catch (PersistenceException e){
            System.out.println("Exception found in productRunner");
            e.getStackTrace();
            et.rollback();
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
