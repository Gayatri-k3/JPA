package com.xworkz.tourism.repository;

import com.xworkz.tourism.entity.TourismEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;
@Repository
public class TourismRepositoryImpl implements TourismRepository {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("x-workz");

    @Override
    public boolean saveTourism(TourismEntity tourismEntity) {
        System.out.println("save method in repository");
        System.out.println("Repo data: " + tourismEntity);
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        try {
            entityManager = emf.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(tourismEntity);
            entityTransaction.commit();

        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
            if (entityTransaction != null) {
                entityTransaction.rollback();
                System.out.println("roll backed");
                return false;
            }
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
                System.out.println("entityManager is closed");
            }
        }
        return true;
    }

    @Override
    public List<TourismEntity> getAllEntity() {
        System.out.println("getAllEntity method in repository");

        EntityManager entityManager=null;
        List<TourismEntity> list=null;
        try{
            entityManager=emf.createEntityManager();
            list =entityManager.createNamedQuery("getAllEntity").getResultList();
        }catch (PersistenceException e)
        {
            System.out.println(e.getMessage());

        }finally {
            if(entityManager!=null && entityManager.isOpen())
            {
                entityManager.close();
                System.out.println("Entity manager is closed");
            }
        }
        return list;
    }
}
