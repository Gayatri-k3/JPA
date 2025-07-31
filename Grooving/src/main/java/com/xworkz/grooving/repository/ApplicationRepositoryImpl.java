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
    @Override
    public void saveApplication(ApplicationEntity applicationEntity) {
        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(applicationEntity);
            em.getTransaction().commit();
        }catch (PersistenceException e){
            e.printStackTrace();
        }finally {
            if (emf!=null){
                emf.close();
            }
            if (em!=null){
                em.close();
            }
        }
    }

    @Override
    public ApplicationEntity readApplication(Integer id) {

        return null;
    }
}
