package com.xworkz.passportVoter.runner;

import com.xworkz.passportVoter.entity.PassportEntity;

import javax.persistence.*;

public class PassportWrite {
    public static void main(String[] args) {
        PassportEntity application = new PassportEntity();
        application.setName("Aarav Kumar");
        application.setSubmissionDate("15/03/2000");
        application.setType("Indian");
        application.setStatus("Submitted");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(application);
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
