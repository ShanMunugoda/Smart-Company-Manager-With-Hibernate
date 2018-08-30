package lk.ijse.hibernate.main;

import lk.ijse.hibernate.entity.Customer;
import lk.ijse.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class StartUp {
    public static void main(String[] args) {
        SessionFactory sessionFactory=HibernateUtil.getSessionFactory();

        Session session=sessionFactory.openSession();
        session.getTransaction().begin();

       Customer customer= session.get(Customer.class,"c001");

        System.out.println(customer);

        session.getTransaction().commit();

        session.close();

        sessionFactory.close();
    }
}
