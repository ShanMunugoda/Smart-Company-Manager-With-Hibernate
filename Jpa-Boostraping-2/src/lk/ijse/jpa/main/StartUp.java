package lk.ijse.jpa.main;

import lk.ijse.jpa.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class StartUp {
    public static void main(String[] args) throws IOException {
//        String absolutePath = new File("application.properties").getAbsolutePath();
//        System.out.println(absolutePath);


        File file = new File("Jpa-Boostraping-2/application.properties");
        FileReader fileReader=new FileReader(file);
        Properties jpaProp=new Properties();
        jpaProp.load(fileReader);



        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("boot2",jpaProp);
        EntityManager entityManager=entityManagerFactory.createEntityManager();


            entityManager.getTransaction().begin();
            Customer harsha=new Customer("harsha","Kadawatha");
            entityManager.persist(harsha);

            entityManager.getTransaction().commit();
            entityManager.close();
            entityManagerFactory.close();
    }
}
