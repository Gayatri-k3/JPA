package com.xworkz.railways.repository;

import com.xworkz.railways.Util.DBUtils;
import com.xworkz.railways.entity.RailwayEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

public class RailwayRepositoryImpl implements RailwayRepository{
    public RailwayRepositoryImpl(){
        System.out.println("RailwayRepositoryImpl Loaded");
    }
    private EntityManager em;
    @Override
    public boolean save(RailwayEntity entity) {
        try {
            em = DBUtils.getEm();
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        }catch (PersistenceException e){
            System.out.println(e.getMessage());
        }
        finally {
            if (em!=null && em.isOpen()){
                em.close();
            }

        }

        return false;
    }
}
