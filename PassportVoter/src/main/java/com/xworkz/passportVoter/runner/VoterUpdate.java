package com.xworkz.passportVoter.runner;


import com.xworkz.passportVoter.entity.VoterEntity;

import javax.persistence.*;

public class VoterUpdate {
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
            if (voter != null) {
                voter.setRegion("Bangalore North");
                VoterEntity updated = em.merge(voter);
                System.out.println("Data Updated");
                System.out.println(updated);
            }
            et.commit();
        } catch (PersistenceException e) {
            System.out.println("Exception in Update");
            e.printStackTrace();
            et.rollback();
        } finally {
            if (emf != null) emf.close();
            if (em != null) em.close();
        }
    }
}