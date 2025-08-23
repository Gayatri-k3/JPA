package com.xworkz.railways.Util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class DBUtils {
    private static EntityManagerFactory emf;

    static {
        try{
            emf= Persistence.createEntityManagerFactory("x-workz");
        }catch (PersistenceException e){
            e.printStackTrace();
            System.out.println("Exception with emf");
        }
    }
    public static EntityManager getEm() {
        return emf.createEntityManager();
    }

    public static void closeEmf() {
        if (emf.isOpen() && emf != null) {
            emf.close();
        }
    }
}
