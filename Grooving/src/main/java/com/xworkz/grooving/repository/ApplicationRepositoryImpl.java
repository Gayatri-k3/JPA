package com.xworkz.grooving.repository;

import com.xworkz.grooving.entity.ApplicationEntity;
import com.xworkz.grooving.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
@Repository
public class ApplicationRepositoryImpl implements ApplicationRepository {
    EntityManagerFactory emf = null;
    EntityManager em = null;
    @Autowired
    ApplicationService service;
    ApplicationEntity app;

    @Override
    public void saveApplication(ApplicationEntity applicationEntity) {
        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(applicationEntity);
            em.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            if (emf != null) {
                emf.close();
            }
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public ApplicationEntity readApplication(Integer id) {
        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            em.getTransaction().begin();
            ApplicationEntity app = em.find(ApplicationEntity.class, id);
            System.out.println(app);
            em.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            if (emf != null) {
                emf.close();
            }
            if (em != null) {
                em.close();
            }
        }
        return app;
    }

    @Override
    public ApplicationEntity updateApplication(ApplicationEntity entity, Integer id) {
        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            em.getTransaction().begin();
            ApplicationEntity app = em.find(ApplicationEntity.class, id);
            if (app != null) {
                app.setNoOfUSers(entity.getNoOfUSers());
                app.setApplicationSize(entity.getApplicationSize());
                app.setApplicationName(entity.getApplicationName());
                app.setRatings(entity.getRatings());
                app.setCompany(entity.getCompany());
                app.setLaunchDate(entity.getLaunchDate());

                em.merge(app);
                em.getTransaction().commit();
                System.out.println("Updated");
            }
        } catch (PersistenceException e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            if (emf != null) {
                emf.close();
            }
            if (em != null) {
                em.close();
            }
        }
        return app;
    }

    @Override
    public ApplicationEntity deleteApplication(Integer id) {
        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            em.getTransaction().begin();
            ApplicationEntity app = em.find(ApplicationEntity.class, id);
            em.remove(app);
            em.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            if (emf != null) {
                emf.close();
            }
            if (em != null) {
                em.close();
            }
        }
        return app;
    }
}
