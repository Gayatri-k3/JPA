package com.xworkz.chocobake.runner;

import com.xworkz.chocobake.entity.BakeryEntity;
import com.xworkz.chocobake.entity.ChocolateEntity;

import javax.persistence.*;

public class ChocolateRead {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;
        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            ChocolateEntity entity = em.find(ChocolateEntity.class, 1);
            System.out.println(entity);
            et.commit();
        }catch(PersistenceException e) {
            e.printStackTrace();
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

