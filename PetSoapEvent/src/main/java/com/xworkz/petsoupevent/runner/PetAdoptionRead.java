package com.xworkz.petsoupevent.runner;


import com.xworkz.petsoupevent.entity.PetAdoptionEntity;

import javax.persistence.*;

public class PetAdoptionRead {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            PetAdoptionEntity pet = em.find(PetAdoptionEntity.class, 1);
            System.out.println(pet);
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            if (emf != null) emf.close();
            if (em != null) em.close();
        }
    }
}