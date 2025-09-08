package com.xworkz.railways.repository;

import com.xworkz.railways.Util.DBUtils;
import com.xworkz.railways.entity.RailwayEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.Collections;
import java.util.List;
@Repository
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

    @Override
    public List<RailwayEntity> getAll() {
        System.out.println("getAll in repo");
        List<RailwayEntity> list= null;
        try{
            em=DBUtils.getEm();
            list=em.createNamedQuery("getAll").getResultList();
        }catch (PersistenceException e){
            System.out.println(e.getMessage());
        }finally {
            if (em!=null&& em.isOpen()){
                em.close();
                System.out.println("em is closed");
            }
        }
        return list;
    }
}
