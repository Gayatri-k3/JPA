package com.xworkz.petsoupevent.runner;


import com.xworkz.petsoupevent.entity.PetAdoptionEntity;

import javax.persistence.*;

public class PetAdoptionWrite {
    public static void main(String[] args) {
        PetAdoptionEntity pet = new PetAdoptionEntity();
        pet.setPetName("Bruno");
        pet.setPetType("Dog");
        pet.setAge(3);
        pet.setAdopterName("Kiran");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(pet);
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