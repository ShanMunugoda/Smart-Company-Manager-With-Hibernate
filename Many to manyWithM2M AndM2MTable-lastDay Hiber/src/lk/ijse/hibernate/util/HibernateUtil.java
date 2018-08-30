package lk.ijse.hibernate.util;

import lk.ijse.hibernate.entity.Item;
import lk.ijse.hibernate.entity.Order;
import lk.ijse.hibernate.entity.OrderDetails;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static SessionFactory sessionFactory=buildSessionFactory();

    private static SessionFactory buildSessionFactory(){
        StandardServiceRegistry registry=new StandardServiceRegistryBuilder()
                .loadProperties("application.properties").build();

        Metadata metadata=new MetadataSources(registry)
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(OrderDetails.class)
                .buildMetadata();

        return metadata.getSessionFactoryBuilder().build();
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;

    }
}
