package com.xworkz.tourism.repository;

import com.xworkz.tourism.entity.TourismEntity;
import org.hibernate.QueryException;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Repository
public class TourismRepositoryImpl implements TourismRepository {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("x-workz");

    public TourismRepositoryImpl()
    {
        System.out.println("TourismRepositoryImpl constructor");
    }

    @Override
    public boolean save(TourismEntity entity) {
        System.out.println("save method in repository");
        System.out.println("Repo data: "+entity);

        EntityManager entityManager=null;
        EntityTransaction entityTransaction=null;
        try{
            entityManager= emf.createEntityManager();
            entityTransaction=entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(entity);
            entityTransaction.commit();

        }catch (PersistenceException e)
        {
            System.out.println(e.getMessage());
            if(entityTransaction!=null)
            {
                entityTransaction.rollback();
                System.out.println("roll backed");
                return false;
            }
        }finally {
            if(entityManager!=null && entityManager.isOpen())
            {
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

    @Override
    public Optional<TourismEntity> findById(Integer id) {
        System.out.println("Find by id in repository");
        EntityManager entityManager=null;
        Optional<TourismEntity> optionalTourismEntity=null;
        try{
            entityManager=emf.createEntityManager();
            TourismEntity tourism=(TourismEntity) entityManager.createNamedQuery("findById").setParameter("id",id).getSingleResult();
            if(tourism!=null)
            {
                return Optional.of(tourism);
            }
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
        return optionalTourismEntity;
    }

    @Override
    public boolean updateTourism(TourismEntity entity) {
        EntityManager em = null;
        boolean isUpdated = false;
        try {
        em = emf.createEntityManager();
        em.getTransaction().begin();
            int check = em.createNamedQuery("update")
                    .setParameter("packageName", entity.getPackageName())
                    .setParameter("destination", entity.getDestination())
                    .setParameter("days", entity.getDays())
                    .setParameter("packagePrice", entity.getPackagePrice())
                    .setParameter("personsCount", entity.getPersonsCount())
                    .setParameter("packageId", entity.getPackageId())
                    .executeUpdate();

            if (check > 0) {
            em.getTransaction().commit();
            isUpdated = true;
        }
    }
        catch(NoResultException | QueryException e){
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
        }finally {
            if (em!=null && em.isOpen()){
                em.close();
            }
        }
        return isUpdated;
    }

    @Override
    public boolean deleteTourism(Integer id) {
        System.out.println("Delete method in repo");
        boolean isDeleted = false;
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            int check = em.createNamedQuery("delete").setParameter("packageId",id).executeUpdate();
            if (check>0){
                isDeleted = true;
                em.getTransaction().commit();
            }
        }catch (PersistenceException e){
            e.printStackTrace();
        }
        return false;
    }
}