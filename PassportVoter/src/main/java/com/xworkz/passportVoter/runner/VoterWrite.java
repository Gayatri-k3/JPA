package com.xworkz.passportVoter.runner;


import com.xworkz.passportVoter.entity.VoterEntity;

import javax.persistence.*;

public class VoterWrite {
    public static void main(String[] args) {
        VoterEntity voter = new VoterEntity();
        voter.setName("Suman R");
        voter.setAge(28);
        voter.setRegion("Bangalore South");
        voter.setAge(18);

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(voter);
            et.commit();
        } catch (PersistenceException e) {
            System.out.println("Exception at Create");
            e.printStackTrace();
            et.rollback();
        } finally {
            if (emf != null) emf.close();
            if (em != null) em.close();
        }
    }
}