package com.xworkz.footwearecomm.runner;

import com.xworkz.footwearecomm.entity.FootwearEntity;

import javax.persistence.*;

public class FootwearRead {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            FootwearEntity footwear = em.find(FootwearEntity.class, 1);
            System.out.println(footwear);
            et.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            if (emf != null) emf.close();
            if (em != null) em.close();
        }
    }
}