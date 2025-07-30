package com.xworkz.passportVoter.runner;


import com.xworkz.passportVoter.entity.VoterEntity;

import javax.persistence.*;

public class VoterRead {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            VoterEntity voter = em.find(VoterEntity.class, 1);
            System.out.println(voter);
            et.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            if (emf != null) emf.close();
            if (em != null) em.close();
        }
    }
}