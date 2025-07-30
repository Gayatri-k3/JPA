package com.xworkz.petsoupevent.runner;


import com.xworkz.petsoupevent.entity.PetAdoptionEntity;

import javax.persistence.*;

public class PetAdoptionUpdate {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            PetAdoptionEntity pet = em.find(PetAdoptionEntity.class, 1);
            if (pet != null) {
                pet.setAdopterName("Shruti");
                PetAdoptionEntity updatedPet = em.merge(pet);
                System.out.println("Updated: " + updatedPet);
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