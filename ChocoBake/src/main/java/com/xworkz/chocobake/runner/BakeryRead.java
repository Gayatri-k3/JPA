package com.xworkz.chocobake.runner;

import com.xworkz.chocobake.entity.BakeryEntity;

import javax.persistence.*;

public class BakeryRead {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;
        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            BakeryEntity entity = em.find(BakeryEntity.class, 1);
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