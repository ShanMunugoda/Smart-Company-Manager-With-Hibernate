package lk.ijsw.hibernate.main;

import lk.ijsw.hibernate.entity.Customer;
import lk.ijsw.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;

public class Demo2persistinJPA {
    public static void main(String[] args) {
        SessionFactory sessionFactory=HibernateUtil.getSessionFactory();

        Session session=sessionFactory.openSession();
        session.getTransaction().begin();

       Customer customer= new Customer("c008","Akmil","Panadura");

        session.persist(customer);

        //System.out.println(id);

        session.getTransaction().commit();

        session.close();

        sessionFactory.close();
    }
}
