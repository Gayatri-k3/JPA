package com.xworkz.passportVoter.runner;


import com.xworkz.passportVoter.entity.PassportEntity;

import javax.persistence.*;

public class PassportUpdate {
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
            if (application != null) {
                application.setStatus("In Process");
                PassportEntity updated = em.merge(application);
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
