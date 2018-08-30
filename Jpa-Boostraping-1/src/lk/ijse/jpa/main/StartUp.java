package lk.ijse.jpa.main;

import lk.ijse.jpa.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StartUp {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("boot1");
        EntityManager entityManager=entityManagerFactory.createEntityManager();


            entityManager.getTransaction().begin();
            Customer harsha=new Customer("harsha","Kadawatha");
            entityManager.persist(harsha);

            entityManager.getTransaction().commit();
            entityManager.close();
            entityManagerFactory.close();
    }
}
