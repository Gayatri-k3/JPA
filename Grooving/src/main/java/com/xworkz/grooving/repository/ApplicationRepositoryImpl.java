package com.xworkz.grooving.repository;

import com.xworkz.grooving.entity.ApplicationEntity;
import com.xworkz.grooving.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.time.LocalDate;

@Repository
public class ApplicationRepositoryImpl implements ApplicationRepository {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("x-workz");
    EntityManager em = null;
    @Autowired
    ApplicationService service;
    ApplicationEntity app;

    @Override
    public void saveApplication(ApplicationEntity applicationEntity) {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(applicationEntity);
            em.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public ApplicationEntity readApplication(Integer id) {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            ApplicationEntity app = em.find(ApplicationEntity.class, id);
            System.out.println(app);
            em.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {

            if (em != null) {
                em.close();
            }
        }
        return app;
    }

    @Override
    public ApplicationEntity updateApplication(ApplicationEntity entity, Integer id) {
        try {
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

            if (em != null) {
                em.close();
            }
        }
        return app;
    }

    @Override
    public ApplicationEntity deleteApplication(Integer id) {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            ApplicationEntity app = em.find(ApplicationEntity.class, id);
            em.remove(app);
            em.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return app;
    }

    @Override
    public ApplicationEntity findApplicationByName(String name) {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            app = (ApplicationEntity) em.createNamedQuery("findApplicationByName").setParameter("name",name).getSingleResult();
            System.out.println("findApplicationByName: "+app);
            em.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {

            if (em != null) {
                em.close();
            }
        }
        return app;
    }

    @Override
    public ApplicationEntity findBySize(String size) {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            app = (ApplicationEntity) em.createNamedQuery("findBySize").setParameter("size",size).getSingleResult();
            System.out.println("findBySize: "+app);
            em.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {

            if (em != null) {
                em.close();
            }
        }
        return app;
    }

    @Override
    public ApplicationEntity findByCompany(String company) {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            app = (ApplicationEntity) em.createNamedQuery("findByCompany").setParameter("comp",company).getSingleResult();
            System.out.println("findByCompany: "+app);
            em.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {

            if (em != null) {
                em.close();
            }
        }
        return app;
    }

    @Override
    public ApplicationEntity findByUsers(Integer users) {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            app = (ApplicationEntity) em.createNamedQuery("findByUsers").setParameter("users",users).getSingleResult();
            System.out.println("findByUsers: "+app);
            em.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {

            if (em != null) {
                em.close();
            }
        }
        return app;
    }

    @Override
    public ApplicationEntity findByRatings(Float ratings) {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            app = (ApplicationEntity) em.createNamedQuery("findByRatings").setParameter("ratings",ratings).getSingleResult();
            System.out.println("findByRatings: "+app);
            em.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {

            if (em != null) {
                em.close();
            }
        }
        return app;
    }

    @Override
    public ApplicationEntity findByDate(LocalDate date) {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            app = (ApplicationEntity) em.createNamedQuery("findByDate").setParameter("date",date).getSingleResult();
            System.out.println("findByDate: "+app);
            em.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {

            if (em != null) {
                em.close();
            }
        }
        return app;
    }
}
