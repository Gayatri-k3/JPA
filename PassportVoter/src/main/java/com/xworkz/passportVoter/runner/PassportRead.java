package com.xworkz.passportVoter.runner;

import com.xworkz.passportVoter.entity.PassportEntity;

import javax.persistence.*;

public class PassportRead {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            PassportEntity application = em.find(PassportEntity.class, 1);
            System.out.println(application);
            et.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            if (emf != null) emf.close();
            if (em != null) em.close();
        }
    }
}